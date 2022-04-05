package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class RowCacheRequestsClass implements globales{
    private ObjectName urlRowCacheRequests = null;
    private MBeanInfo MBeanRowCacheRequests = null;
    private MBeanAttributeInfo[] RowCacheRequestsAtributes = null;
    private MBeanServerConnection MC = null;

    public RowCacheRequestsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlRowCacheRequests = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=RowCache,name=Requests");
        MBeanRowCacheRequests = CM.getMBeanInfo(urlRowCacheRequests);
        RowCacheRequestsAtributes = MBeanRowCacheRequests.getAttributes();
        MC = CM;
    }

    public String getAtributsRowCacheRequests(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < RowCacheRequestsAtributes.length; j++) {
                if (atrCons[i].equals(RowCacheRequestsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheRequests (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro RowCache Requests");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(RowCacheRequestsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlRowCacheRequests, RowCacheRequestsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
