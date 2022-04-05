package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

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
                }
            }
        }
        return atributs;

    }
    public void consultaReadTotalLatency (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Read TotalLatency");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(ReadTotalLatencyAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlReadTotalLatency, ReadTotalLatencyAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}