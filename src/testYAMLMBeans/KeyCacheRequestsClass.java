package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class KeyCacheRequestsClass implements globales{
    private ObjectName urlKeyCacheRequests = null;
    private MBeanInfo MBeanKeyCacheRequests = null;
    private MBeanAttributeInfo[] KeyCacheRequestsAtributes = null;
    private MBeanServerConnection MC = null;

    public KeyCacheRequestsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlKeyCacheRequests = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=KeyCache,name=Requests");
        MBeanKeyCacheRequests = CM.getMBeanInfo(urlKeyCacheRequests);
        KeyCacheRequestsAtributes = MBeanKeyCacheRequests.getAttributes();
        MC = CM;
    }

    public String getAtributsKeyCacheRequests(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < KeyCacheRequestsAtributes.length; j++) {
                if (atrCons[i].equals(KeyCacheRequestsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaKeyCacheRequests (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro KeyCache Requests");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(KeyCacheRequestsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlKeyCacheRequests, KeyCacheRequestsAtributes[Integer.parseInt(part)].getName()));
        }System.out.println("---------------------------------");

    }

}

