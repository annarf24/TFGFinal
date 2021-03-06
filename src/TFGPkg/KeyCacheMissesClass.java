package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class KeyCacheMissesClass implements globales{
    private ObjectName urlKeyCacheMisses = null;
    private MBeanInfo MBeanKeyCacheMisses = null;
    private MBeanAttributeInfo[] KeyCacheMissesAtributes = null;
    private MBeanServerConnection MC = null;

    public KeyCacheMissesClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlKeyCacheMisses = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=KeyCache,name=Misses");
        MBeanKeyCacheMisses = CM.getMBeanInfo(urlKeyCacheMisses);
        KeyCacheMissesAtributes = MBeanKeyCacheMisses.getAttributes();
        MC = CM;
    }

    public String getAtributsKeyCacheMisses(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < KeyCacheMissesAtributes.length; j++) {
                if (atrCons[i].equals(KeyCacheMissesAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[5] += KeyCacheMissesAtributes[j].getName();
                    attrNames[5] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaKeyCacheMisses (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[5].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {
            String a = "";
            a += MC.getAttribute(urlKeyCacheMisses, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[5][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[5][j]));
            qtyVal[5][j]++;
            ValAct[5][j] = a;
        }
    }

    public String getValActualKCM(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlKeyCacheMisses,AtrCons));
    }
}
