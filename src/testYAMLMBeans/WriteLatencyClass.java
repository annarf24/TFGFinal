package testYAMLMBeans;


import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class WriteLatencyClass implements globales{
    private ObjectName urlWriteLatency = null;
    private MBeanInfo MBeanWriteLatency = null;
    private MBeanAttributeInfo[] WriteLatencyAtributes = null;
    private MBeanServerConnection MC = null;

    public WriteLatencyClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlWriteLatency = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Write,name=Latency");
        MBeanWriteLatency = CM.getMBeanInfo(urlWriteLatency);
        WriteLatencyAtributes = MBeanWriteLatency.getAttributes();
        MC = CM;
    }

    public String getAtributsWriteLatency(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < WriteLatencyAtributes.length; j++) {
                if (atrCons[i].equals(WriteLatencyAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaWriteLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Write Latency");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(WriteLatencyAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlWriteLatency, WriteLatencyAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
