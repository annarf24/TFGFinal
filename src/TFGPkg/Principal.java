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

    String[][] ValAct = {{""}, //AllMemtablesHeapSize
            {""}, //CompletedTasks
            {""}, //Exceptions
            {""}, //KeyCacheHitRate
            {"", "", "", "", "", ""}, //KeyCacheHits
            {"", "", "", "", "", ""}, //KeyCacheMisses
            {"", "", "", "", "", ""}, //KeyCacheRequests
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, //ReadLatency
            {"", "", "", "", "", ""}, //ReadTimeouts
            {""}, //ReadTotalLatency
            {"", "", "", "", "", ""}, //ReadUnavailabes
            {""}, //RowCahceHitRate
            {"", "", "", "", "", ""}, //RowCacheHits
            {"", "", "", "", "", ""}, //RowCacheMisses
            {"", "", "", "", "", ""}, //RowCacheRequests
            {""}, //TotalDiskSpaceUsed
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, //WriteLatency
            {"", "", "", "", "", ""}, //WriteTimeouts
            {""}, //WriteTotalLatency
            {"", "", "", "", "", ""}, //WriteUnavailabes
    };
}

public class Principal extends JFrame implements globales{


    public static void main(String[] args) throws IOException, ReflectionException, MalformedObjectNameException,
            InstanceNotFoundException, IntrospectionException, AttributeNotFoundException, MBeanException, InterruptedException {
        //omplir l'array de tabs a eliminar de la GUI de false (iniciailzar)
        Arrays.fill(globales.EliminarTab, false);
        globales.cerrar[0] = false;

        //Lectura del ficher YAML
        InputStream inputStream = new FileInputStream(new File("configMonitorizador.yaml"));
        Yaml yaml = new Yaml(new Constructor(DataConfig.class));
        DataConfig data = yaml.load(inputStream);

        //creació de la conexió al node de minerva seleccionat en el YAML
        JMXConnector JMXMinerva = ConnexioMinerva(data.getNodo() , "7199");
        MBeanServerConnection MC = JMXMinerva.getMBeanServerConnection();


        //selecció de quins tabs no eliminar de la GUI
        for(int i = 0; i < data.getParametros().length; i++) {
            globales.EliminarTab[data.getParametros()[i].getNum() - 1] = true;
        }


        //equest bucle s'executa par cada un dels parametres escollits al YAML que s'emmagatzemen a la variable data
        //el bucle serveix para obtenir els atributs de cada un dels paràmetres escollits, mitjançant la funció
        //getAtributs de cada una de les classes
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

        //creació de la GUI

        InterfazGrafica frame = new InterfazGrafica("Consultor de rendimiento de Cassandra");
        frame.setVisible(true);
        
        //aquest bucle consulta per cada parametre seleccionat al YAML, el valor de cada atributo seleccionat al YAML
        //i processat al bucle anterior, i li passa els valors a la interfície gràfica perque pugui crear
        // les gràfiques i actualitzar l'etiqueta de valor actual. Està separat de l'anterior para poder posar
        //aquest en un bucle while infinito sense haber d'estar llegint el YAML constantement.
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
                        atrCons = frame.getAtrConsultat(2);
                        frame.actualitzaLabel(CT.getValActualCT(atrCons),2);
                        break;

                    //datos Exceptions
                    case 3:
                        ExceptionsClass E = new ExceptionsClass(MC);
                        E.consultaExceptions(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(3);
                        frame.actualitzaLabel(E.getValActualE(atrCons),3);
                        break;

                    //datos KeyCacheHitRate
                    case 4:
                        KeyCacheHitRateClass KCHR = new KeyCacheHitRateClass(MC);
                        KCHR.consultaKeyCacheHitRate(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(4);
                        frame.actualitzaLabel(KCHR.getValActualKCHR(atrCons),4);
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
                        atrCons = frame.getAtrConsultat(6);
                        frame.actualitzaLabel(KCM.getValActualKCM(atrCons),6);
                        break;

                    //datos KeyCacheRequests
                    case 7:
                        KeyCacheRequestsClass KCR = new KeyCacheRequestsClass(MC);
                        KCR.consultaKeyCacheRequests(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(7);
                        frame.actualitzaLabel(KCR.getValActualKCR(atrCons),7);
                        break;

                    //datos ReadLatency
                    case 8:
                        ReadLatencyClass RL = new ReadLatencyClass(MC);
                        RL.consultaReadLatency(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(8);
                        frame.actualitzaLabel(RL.getValActualRL(atrCons),8);
                        break;

                    //datos ReadTimeOuts
                    case 9:
                        ReadTimeOutsClass RTO = new ReadTimeOutsClass(MC);
                        RTO.consultaReadTimeOuts(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(9);
                        frame.actualitzaLabel(RTO.getValActualRTO(atrCons),9);
                        break;

                    //datos ReadTotalLatency
                    case 10:
                        ReadTotalLatencyClass RTL = new ReadTotalLatencyClass(MC);
                        RTL.consultaReadTotalLatency(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(10);
                        frame.actualitzaLabel(RTL.getValActualRTL(atrCons),10);
                        break;

                    //datos ReadUnavailables
                    case 11:
                        ReadUnavailablesClass RU = new ReadUnavailablesClass(MC);
                        RU.consultaReadUnavailables(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(11);
                        frame.actualitzaLabel(RU.getValActualRU(atrCons),11);
                        break;

                    //datos RowCacheHitRate
                    case 12:
                        RowCacheHitRateClass RCHR = new RowCacheHitRateClass(MC);
                        RCHR.consultaRowCacheHitRate(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(12);
                        frame.actualitzaLabel(RCHR.getValActualRCHR(atrCons),12);
                        break;

                    //datos RowCacheHits
                    case 13:
                        RowCacheHitsClass RCH = new RowCacheHitsClass(MC);
                        RCH.consultaRowCacheHits(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(13);
                        frame.actualitzaLabel(RCH.getValActualRCH(atrCons),13);
                        break;

                    //datos RowCacheMisses
                    case 14:
                        RowCacheMissesClass RCM = new RowCacheMissesClass(MC);
                        RCM.consultaRowCacheMisses(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(14);
                        frame.actualitzaLabel(RCM.getValActualRCM(atrCons),14);
                        break;

                    //datos RowCacheRequests
                    case 15:
                        RowCacheRequestsClass RCR = new RowCacheRequestsClass(MC);
                        RCR.consultaRowCacheRequests(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(15);
                        frame.actualitzaLabel(RCR.getValActualRCR(atrCons),15);
                        break;

                    //datos TotalDiskSpaceUsed
                    case 16:
                        TotalDiskSpaceUsedClass TDSU = new TotalDiskSpaceUsedClass(MC);
                        TDSU.consultaTotalDiskSpaceUsed(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(16);
                        frame.actualitzaLabel(TDSU.getValActualTDSU(atrCons),16);
                        break;

                    //datos WriteLatency
                    case 17:
                        WriteLatencyClass WL = new WriteLatencyClass(MC);
                        WL.consultaWriteLatency(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(17);
                        frame.actualitzaLabel(WL.getValActualWL(atrCons),17);
                        break;

                    //datos WriteTimeOuts
                    case 18:
                        WriteTimeOutsClass WTO = new WriteTimeOutsClass(MC);
                        WTO.consultaWriteTimeOuts(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(18);
                        frame.actualitzaLabel(WTO.getValActualWTO(atrCons),18);
                        break;

                    //datos WriteTotalLatency
                    case 19:
                        WriteTotalLatencyClass WTL = new WriteTotalLatencyClass(MC);
                        WTL.consultaWriteTotalLatency(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(19);
                        frame.actualitzaLabel(WTL.getValActualWTL(atrCons),19);
                        break;

                    //datos WriteUnavailables
                    case 20:
                        WriteUnavailablesClass WU = new WriteUnavailablesClass(MC);
                        WU.consultaWriteUnavailables(globales.attr[opcion - 1]);
                        atrCons = frame.getAtrConsultat(20);
                        frame.actualitzaLabel(WU.getValActualWU(atrCons),20);
                        break;

                    default:
                        System.out.println("Esta no es una opcion");
                        break;
                }
            }
            //es para dos segons entre cada consulta
            Thread.sleep(2000);
        }
        //es tanca la conexió de minerva
        JMXMinerva.close();
    }

    //conexión a un nodo de Minerva
    public static JMXConnector ConnexioMinerva(String hostname, String portNum) throws IOException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + hostname + ":" + portNum + "/jmxrmi");
        return JMXConnectorFactory.connect(url);
    }
}
