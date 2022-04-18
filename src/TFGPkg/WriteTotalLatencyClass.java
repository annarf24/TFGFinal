package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class WriteTotalLatencyClass implements globales{
    private ObjectName urlWriteTotalLatency = null;
    private MBeanInfo MBeanWriteTotalLatency = null;
    private MBeanAttributeInfo[] WriteTotalLatencyAtributes = null;
    private MBeanServerConnection MC = null;

    public WriteTotalLatencyClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlWriteTotalLatency = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Write,name=TotalLatency");
        MBeanWriteTotalLatency = CM.getMBeanInfo(urlWriteTotalLatency);
        WriteTotalLatencyAtributes = MBeanWriteTotalLatency.getAttributes();
        MC = CM;
    }

    public String getAtributsWriteTotalLatency(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < WriteTotalLatencyAtributes.length; j++) {
                if (atrCons[i].equals(WriteTotalLatencyAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[18] += WriteTotalLatencyAtributes[j].getName();
                    attrNames[18] += ",";
                }
            }
        }
        return atributs;

    }

    public void consultaWriteTotalLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[18].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {
            String a = "";
            a += MC.getAttribute(urlWriteTotalLatency, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[18][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[18][j]));
            qtyVal[18][j]++;
            ValAct[18][j] = a;
        }
    }

    public String getValActualWTL(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlWriteTotalLatency,AtrCons));
    }
}
