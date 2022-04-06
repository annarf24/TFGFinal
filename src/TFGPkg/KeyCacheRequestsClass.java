package TFGPkg;

import javax.management.*;
import java.io.IOException;

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
                    attrNames[6] += KeyCacheRequestsAtributes[j].getName();
                    attrNames[6] += ",";
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
        }
        System.out.println("---------------------------------");

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[6].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlKeyCacheRequests, nameAttrSeparats[j]);
            globales.dcd[6][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[6][j]));
            qtyVal[6][j]++;
        }
    }

    public String getValActualKCR(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlKeyCacheRequests,AtrCons));
    }
}

