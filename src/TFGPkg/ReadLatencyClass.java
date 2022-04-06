package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class ReadLatencyClass implements globales{
    private ObjectName urlReadLatency = null;
    private MBeanInfo MBeanReadLatency = null;
    private MBeanAttributeInfo[] ReadLatencyAtributes = null;
    private MBeanServerConnection MC = null;

    public ReadLatencyClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlReadLatency = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=Latency");
        MBeanReadLatency = CM.getMBeanInfo(urlReadLatency);
        ReadLatencyAtributes = MBeanReadLatency.getAttributes();
        MC = CM;
    }

    public String getAtributsReadLatency(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < ReadLatencyAtributes.length; j++) {
                if (atrCons[i].equals(ReadLatencyAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[7] += ReadLatencyAtributes[j].getName();
                    attrNames[7] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaReadLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Read Latency");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(ReadLatencyAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlReadLatency, ReadLatencyAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[7].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlReadLatency, nameAttrSeparats[j]);
            globales.dcd[7][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[7][j]));
            qtyVal[7][j]++;
        }
    }

    public String getValActualRL(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlReadLatency,AtrCons));
    }
}
