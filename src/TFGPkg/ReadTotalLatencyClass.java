package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class ReadTotalLatencyClass implements globales{
    private ObjectName urlReadTotalLatency = null;
    private MBeanInfo MBeanReadTotalLatency = null;
    private MBeanAttributeInfo[] ReadTotalLatencyAtributes = null;
    private MBeanServerConnection MC = null;

    public ReadTotalLatencyClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlReadTotalLatency = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=TotalLatency");
        MBeanReadTotalLatency = CM.getMBeanInfo(urlReadTotalLatency);
        ReadTotalLatencyAtributes = MBeanReadTotalLatency.getAttributes();
        MC = CM;
    }

    public String getAtributsReadTotalLatency(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < ReadTotalLatencyAtributes.length; j++) {
                if (atrCons[i].equals(ReadTotalLatencyAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[9] += ReadTotalLatencyAtributes[j].getName();
                    attrNames[9] += ",";
                }
            }
        }
        return atributs;

    }
    public void consultaReadTotalLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[9].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlReadTotalLatency, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[9][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[9][j]));
            qtyVal[9][j]++;
            ValAct[9][j] = a;
        }
    }

    public String getValActualRTL(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlReadTotalLatency,AtrCons));
    }
}