package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class KeyCacheHitRateClass implements globales {
    private ObjectName urlKeyCacheHitRate = null;
    private MBeanInfo MBeanKeyCacheHitRate = null;
    private MBeanAttributeInfo[] KeyCacheHitRateAtributes = null;
    private MBeanServerConnection MC = null;

    public KeyCacheHitRateClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlKeyCacheHitRate = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=KeyCache,name=HitRate");
        MBeanKeyCacheHitRate = CM.getMBeanInfo(urlKeyCacheHitRate);
        KeyCacheHitRateAtributes = MBeanKeyCacheHitRate.getAttributes();
        MC = CM;
    }

    public String getAtributsKeyCacheHitRate(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < KeyCacheHitRateAtributes.length; j++) {
                if (atrCons[i].equals(KeyCacheHitRateAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[3] += KeyCacheHitRateAtributes[j].getName();
                    attrNames[3] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaKeyCacheHitRate(String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro KeyCache HitRate");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(KeyCacheHitRateAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlKeyCacheHitRate, KeyCacheHitRateAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[3].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlKeyCacheHitRate, nameAttrSeparats[j]);
            globales.dcd[3][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[3][j]));
            qtyVal[3][j]++;
        }
    }

    public String getValActualKCHR(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlKeyCacheHitRate,AtrCons));
    }
}

