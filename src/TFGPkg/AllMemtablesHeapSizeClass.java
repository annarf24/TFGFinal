package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class AllMemtablesHeapSizeClass implements globales {
    private ObjectName urlAllMemtablesHeapSize = null;
    private MBeanInfo MBeanAllMemtablesHeapSize = null;
    private MBeanAttributeInfo[] AllMemtablesHeapSizeAtributes = null;
    private MBeanServerConnection MC = null;

    public AllMemtablesHeapSizeClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlAllMemtablesHeapSize = new ObjectName("org.apache.cassandra.metrics:type=Table,name=AllMemtablesHeapSize");
        MBeanAllMemtablesHeapSize = CM.getMBeanInfo(urlAllMemtablesHeapSize);
        AllMemtablesHeapSizeAtributes = MBeanAllMemtablesHeapSize.getAttributes();
        MC = CM;
    }

    //se pasa el parametro que se quiere consultar para obtener los atributos a consultar
    public String getAtributsAllMemtablesHeapSize(Parametro p) {
        //inicialitza atributs
        String atributs = "";

        //Array amb els nomes dels atributs que es volen consultar del parametre
        String[] atrCons = p.getAtributs();

        //en aquest bucle es comparen els noms dels atributs del parametre amb els noms dels atributs que es volen consultar
        //i en cas de que coincideixi es guarda el seu index (la j) al vector atributs
        //a mes a mes es guarden tots els noms dels atributs que es volen consultar en un sol string separat per comes (attrNames)
        //el qual es un array que te una posició per cadascun dels parametres posibles
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < AllMemtablesHeapSizeAtributes.length; j++) {
                if (atrCons[i].equals(AllMemtablesHeapSizeAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[0] += AllMemtablesHeapSizeAtributes[j].getName();
                    attrNames[0] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaAllMemtablesHeapSize (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        //---------------------hay que borrar ---------------------------
        System.out.println("parametro All Memtables Heap Size");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(AllMemtablesHeapSizeAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlAllMemtablesHeapSize, AllMemtablesHeapSizeAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //-----------------------------------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[0].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlAllMemtablesHeapSize, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[0][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[0][j]));
            qtyVal[0][j]++;
            ValAct[0][j] = a;
        }
    }
    public String getValActualAMHS(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlAllMemtablesHeapSize,AtrCons));
    }

}
