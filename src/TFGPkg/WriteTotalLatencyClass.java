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
                }
            }
        }
        return atributs;

    }

    public void consultaWriteTotalLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Write TotalLatency");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(WriteTotalLatencyAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlWriteTotalLatency, WriteTotalLatencyAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
