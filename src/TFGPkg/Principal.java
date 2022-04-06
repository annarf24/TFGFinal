package TFGPkg;

import org.jfree.data.category.DefaultCategoryDataset;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


//el programa tiene, una clase por cada parametro que se puede consultar,
//las clases DataConfig y Parametro que se usan para poder leer el YAML
//y la clase ... junto con el .form que son para la interfaz gráfica.
//finalmente tiene la clase LectYAML que es la principal

interface globales {

    //Array de booleans para eliminar tabs innecesarias en la GUI
    Boolean[] EliminarTab = new Boolean[20];

    //boolean para termianr el while infinito, todavia no se usa
    Boolean[] cerrar = new Boolean[1];

    //string per guardar quins atributs es volen consultar de cada parametre
    String[] attr = new String[20];
    String[] attrNames = {"","","","","","","","","","","","","","","","","","","",""};

    //Matriz de DefaultCategoryDatasets, donde se guradara el valor de los atributos para cada parametro
    //para poder crear las graficas, es global para que se pueda acceder desde todas las clases
    DefaultCategoryDataset[][] dcd = {{new DefaultCategoryDataset()}, //AllMemtablesHeapSize
            {new DefaultCategoryDataset()}, //Completed Tasks
            {new DefaultCategoryDataset()}, //Exceptions
            {new DefaultCategoryDataset()}, //KeyCacheHitRate
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //KeyCacheHits
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //KeyCacheMises
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //KeyCacheRequests
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //ReadLatency
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //ReadTimeOuts
            {new DefaultCategoryDataset()}, //ReadTotalLatency
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //ReadUnavailables
            {new DefaultCategoryDataset()},//RowCacheHitRate
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //RowCacheHits
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //RowCacheMisses
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //RowCacheRequests
            {new DefaultCategoryDataset()},//TotalDiskSpaceUsed
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),
                    new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //WriteLatency
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}, //WriteTimeous
            {new DefaultCategoryDataset()},//WriteTotalLatency
            {new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset(),new DefaultCategoryDataset()}}; //WriteUnavailables

    //Matriz que guarda la cantidad de valores que se han almacenado hasta el momento de cada atributo
    int[][] qtyVal = {{0}, //AllMemtablesHeapSize
            {0}, //CompletedTasks
            {0}, //Exceptions
            {0}, //KeyCacheHitRate
            {0,0,0,0,0,0}, //KeyCacheHits
            {0,0,0,0,0,0}, //KeyCacheMisses
            {0,0,0,0,0,0}, //KeyCacheRequests
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //ReadLatency
            {0,0,0,0,0,0}, //ReadTimeouts
            {0}, //ReadTotalLatency
            {0,0,0,0,0,0}, //ReadUnavailabes
            {0}, //RowCahceHitRate
            {0,0,0,0,0,0}, //RowCacheHits
            {0,0,0,0,0,0}, //RowCacheMisses
            {0,0,0,0,0,0}, //RowCacheRequests
            {0}, //TotalDiskSpaceUsed
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, //WriteLatency
            {0,0,0,0,0,0}, //WriteTimeouts
            {0}, //WriteTotalLatency
            {0,0,0,0,0,0}, //WriteUnavailabes
    };

    }

public class Principal extends JFrame implements globales{

    public static void main(String[] args) throws IOException, ReflectionException, MalformedObjectNameException, InstanceNotFoundException, IntrospectionException, AttributeNotFoundException, MBeanException, InterruptedException {
        //rellenar el array de tabs a eliminar de la GUI de false (iniciailzar)
        Arrays.fill(globales.EliminarTab, false);
        globales.cerrar[0] = false;

        //Lectura del fichero YAML
        InputStream inputStream = new FileInputStream(new File("configMonitorizador.yaml"));
        Yaml yaml = new Yaml(new Constructor(DataConfig.class));
        DataConfig data = yaml.load(inputStream);

        //creación de la conexión al nodo de minerva seleccionado en el YAML
        JMXConnector JMXMinerva = ConnexioMinerva(data.getNodo() , "7199");
        MBeanServerConnection MC = JMXMinerva.getMBeanServerConnection();


        //selecció de quins tabs no eliminar de la GUI
        for(int i = 0; i < data.getParametros().length; i++) {
            globales.EliminarTab[data.getParametros()[i].getNum() - 1] = true;
        }


        //este bucle se ejecuta para cada uno de los parametros elegidos en el YAML que se almacenan en la variable data
        //el bucle sirbe para obtener los atributos de cada uno de los parametros escogidos, mediante la función
        //getAtributs de cada una de las clases
        for (int i = 0; i < data.getParametros().length; i++) {
            int opcion = data.getParametros()[i].getNum();
            switch (opcion) {

                //datos AllMemtablesHeapSize
                case 1:
                    AllMemtablesHeapSizeClass AMHS = new AllMemtablesHeapSizeClass(MC);
                    globales.attr[opcion-1] = AMHS.getAtributsAllMemtablesHeapSize(data.getParametros()[i]);
                    break;

                //datos CompletedTasks
                case 2:
                    CompletedTasksClass CT = new CompletedTasksClass(MC);
                    globales.attr[opcion-1] = CT.getAtributsCompletedTasks(data.getParametros()[i]);
                    break;

                //datos Exceptions
                case 3:
                    ExceptionsClass E = new ExceptionsClass(MC);
                    globales.attr[opcion-1] = E.getAtributsExceptions(data.getParametros()[i]);
                    break;

                //datos KeyCacheHitRate
                case 4:
                    KeyCacheHitRateClass KCHR = new KeyCacheHitRateClass(MC);
                    globales.attr[opcion-1] = KCHR.getAtributsKeyCacheHitRate(data.getParametros()[i]);
                    break;

                //datos KeyCacheHits
                case 5:
                    KeyCacheHitsClass KCH = new KeyCacheHitsClass(MC);
                    globales.attr[opcion-1] = KCH.getAtributsKeyCacheHits(data.getParametros()[i]);
                    break;

                //datos KeyCacheMisses
                case 6:
                    KeyCacheMissesClass KCM = new KeyCacheMissesClass(MC);
                    globales.attr[opcion-1] = KCM.getAtributsKeyCacheMisses(data.getParametros()[i]);
                    break;

                //datos KeyCacheRequests
                case 7:
                    KeyCacheRequestsClass KCR = new KeyCacheRequestsClass(MC);
                    globales.attr[opcion-1] = KCR.getAtributsKeyCacheRequests(data.getParametros()[i]);
                    break;

                //datos ReadLatency
                case 8:
                    ReadLatencyClass RL = new ReadLatencyClass(MC);
                    globales.attr[opcion-1] = RL.getAtributsReadLatency(data.getParametros()[i]);
                    break;

                //datos ReadTimeOuts
                case 9:
                    ReadTimeOutsClass RTO = new ReadTimeOutsClass(MC);
                    globales.attr[opcion-1] = RTO.getAtributsReadTimeOuts(data.getParametros()[i]);
                    break;

                //datos ReadTotalLatency
                case 10:
                    ReadTotalLatencyClass RTL = new ReadTotalLatencyClass(MC);
                    globales.attr[opcion-1] = RTL.getAtributsReadTotalLatency(data.getParametros()[i]);
                    break;

                //datos ReadUnavailables
                case 11:
                    ReadUnavailablesClass RU = new ReadUnavailablesClass(MC);
                    globales.attr[opcion-1] = RU.getAtributsReadUnavailables(data.getParametros()[i]);
                    break;

                //datos RowCacheHitRate
                case 12:
                    RowCacheHitRateClass RCHR = new RowCacheHitRateClass(MC);
                    globales.attr[opcion-1] = RCHR.getAtributsRowCacheHitRate(data.getParametros()[i]);
                    break;

                //datos RowCacheHits
                case 13:
                    RowCacheHitsClass RCH = new RowCacheHitsClass(MC);
                    globales.attr[opcion-1] = RCH.getAtributsRowCacheHits(data.getParametros()[i]);
                    break;

                //datos RowCacheMisses
                case 14:
                    RowCacheMissesClass RCM = new RowCacheMissesClass(MC);
                    globales.attr[opcion-1] = RCM.getAtributsRowCacheMisses(data.getParametros()[i]);
                    break;

                //datos RowCacheRequests
                case 15:
                    RowCacheRequestsClass RCR = new RowCacheRequestsClass(MC);
                    globales.attr[opcion-1] = RCR.getAtributsRowCacheRequests(data.getParametros()[i]);
                    break;

                //datos TotalDiskSpaceUsed
                case 16:
                    TotalDiskSpaceUsedClass TDSU = new TotalDiskSpaceUsedClass(MC);
                    globales.attr[opcion-1] = TDSU.getAtributsTotalDiskSpaceUsed(data.getParametros()[i]);
                    break;

                //datos WriteLatency
                case 17:
                    WriteLatencyClass WL = new WriteLatencyClass(MC);
                    globales.attr[opcion-1] = WL.getAtributsWriteLatency(data.getParametros()[i]);
                    break;

                //datos WriteTimeOuts
                case 18:
                    WriteTimeOutsClass WTO = new WriteTimeOutsClass(MC);
                    globales.attr[opcion-1] = WTO.getAtributsWriteTimeOuts(data.getParametros()[i]);
                    break;

                //datos WriteTotalLatency
                case 19:
                    WriteTotalLatencyClass WTL = new WriteTotalLatencyClass(MC);
                    globales.attr[opcion-1] = WTL.getAtributsWriteTotalLatency(data.getParametros()[i]);
                    break;

                //datos WriteUnavailables
                case 20:
                    WriteUnavailablesClass WU = new WriteUnavailablesClass(MC);
                    globales.attr[opcion-1] = WU.getAtributsWriteUnavailables(data.getParametros()[i]);
                    break;

                default:
                    System.out.println(opcion + " no es una opcion");
                    break;
            }
        }

        //creacion de la GUI

        InterfazGrafica frame = new InterfazGrafica("Consultor de rendimiento de Cassandra");
        frame.setVisible(true);

        //este bucle consulta por cada parametro seleccionado en el YAML, el valor de cada atributo seleccionado en el YAML
        //i procesado en el bucle anterior e imprime los valores por terminal. Esta separado del anterior para poder poner
        //este en un bucle while infinito sin tener que estar leyendo el YAML constantemente
        while (!globales.cerrar[0]) {
            for (int i = 0; i < data.getParametros().length; i++) {
                int opcion = data.getParametros()[i].getNum();
                String atrCons = "";
                switch (opcion) {

                    //datos AllMemtablesHeapSize
                    case 1:
                        AllMemtablesHeapSizeClass AMHS = new AllMemtablesHeapSizeClass(MC);
                        AMHS.consultaAllMemtablesHeapSize(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(1);
                        frame.actualitzaLabel(AMHS.getValActualAMHS(atrCons),1);
                        break;

                    //datos CompletedTasks
                    case 2:
                        CompletedTasksClass CT = new CompletedTasksClass(MC);
                        CT.consultaCompletedTasks(globales.attr[opcion - 1]);
                        break;

                    //datos Exceptions
                    case 3:
                        ExceptionsClass E = new ExceptionsClass(MC);
                        E.consultaExceptions(globales.attr[opcion - 1]);
                        break;

                    //datos KeyCacheHitRate
                    case 4:
                        KeyCacheHitRateClass KCHR = new KeyCacheHitRateClass(MC);
                        KCHR.consultaKeyCacheHitRate(globales.attr[opcion - 1]);
                        break;

                    //datos KeyCacheHits
                    case 5:
                        KeyCacheHitsClass KCH = new KeyCacheHitsClass(MC);
                        KCH.consultaKeyCacheHits(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(5);
                        frame.actualitzaLabel(KCH.getValActualKCH(atrCons),5);
                        break;

                    //datos KeyCacheMisses
                    case 6:
                        KeyCacheMissesClass KCM = new KeyCacheMissesClass(MC);
                        KCM.consultaKeyCacheMisses(globales.attr[opcion - 1]);
                        break;

                    //datos KeyCacheRequests
                    case 7:
                        KeyCacheRequestsClass KCR = new KeyCacheRequestsClass(MC);
                        KCR.consultaKeyCacheRequests(globales.attr[opcion - 1]);
                        break;

                    //datos ReadLatency
                    case 8:
                        ReadLatencyClass RL = new ReadLatencyClass(MC);
                        RL.consultaReadLatency(globales.attr[opcion - 1]);
                        break;

                    //datos ReadTimeOuts
                    case 9:
                        ReadTimeOutsClass RTO = new ReadTimeOutsClass(MC);
                        RTO.consultaReadTimeOuts(globales.attr[opcion - 1]);
                        break;

                    //datos ReadTotalLatency
                    case 10:
                        ReadTotalLatencyClass RTL = new ReadTotalLatencyClass(MC);
                        RTL.consultaReadTotalLatency(globales.attr[opcion - 1]);
                        break;

                    //datos ReadUnavailables
                    case 11:
                        ReadUnavailablesClass RU = new ReadUnavailablesClass(MC);
                        RU.consultaReadUnavailables(globales.attr[opcion - 1]);
                        break;

                    //datos RowCacheHitRate
                    case 12:
                        RowCacheHitRateClass RCHR = new RowCacheHitRateClass(MC);
                        RCHR.consultaRowCacheHitRate(globales.attr[opcion - 1]);
                        break;

                    //datos RowCacheHits
                    case 13:
                        RowCacheHitsClass RCH = new RowCacheHitsClass(MC);
                        RCH.consultaRowCacheHits(globales.attr[opcion - 1]);
                        break;

                    //datos RowCacheMisses
                    case 14:
                        RowCacheMissesClass RCM = new RowCacheMissesClass(MC);
                        RCM.consultaRowCacheMisses(globales.attr[opcion - 1]);
                        break;

                    //datos RowCacheRequests
                    case 15:
                        RowCacheRequestsClass RCR = new RowCacheRequestsClass(MC);
                        RCR.consultaRowCacheRequests(globales.attr[opcion - 1]);
                        break;

                    //datos TotalDiskSpaceUsed
                    case 16:
                        TotalDiskSpaceUsedClass TDSU = new TotalDiskSpaceUsedClass(MC);
                        TDSU.consultaTotalDiskSpaceUsed(globales.attr[opcion - 1]);
                        break;

                    //datos WriteLatency
                    case 17:
                        WriteLatencyClass WL = new WriteLatencyClass(MC);
                        WL.consultaWriteLatency(globales.attr[opcion - 1]);
                        break;

                    //datos WriteTimeOuts
                    case 18:
                        WriteTimeOutsClass WTO = new WriteTimeOutsClass(MC);
                        WTO.consultaWriteTimeOuts(globales.attr[opcion - 1]);
                        break;

                    //datos WriteTotalLatency
                    case 19:
                        WriteTotalLatencyClass WTL = new WriteTotalLatencyClass(MC);
                        WTL.consultaWriteTotalLatency(globales.attr[opcion - 1]);
                        break;

                    //datos WriteUnavailables
                    case 20:
                        WriteUnavailablesClass WU = new WriteUnavailablesClass(MC);
                        WU.consultaWriteUnavailables(globales.attr[opcion - 1]);
                        break;

                    default:
                        System.out.println("Esta no es una opcion");
                        break;
                }
            }
            //se para dos segundos entre cada consulta
            Thread.sleep(2000);
        }
        //se cierra la conexión de minerva, como hacerlo con un while infinito????
        JMXMinerva.close();
    }

    //conexión a un nodo de Minerva
    public static JMXConnector ConnexioMinerva(String hostname, String portNum) throws IOException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + hostname + ":" + portNum + "/jmxrmi");
        return JMXConnectorFactory.connect(url);
    }
}