package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class KeyCacheHitsClass implements globales{
    private ObjectName urlKeyCacheHits = null;
    private MBeanInfo MBeanKeyCacheHits = null;
    private MBeanAttributeInfo[] KeyCacheHitsAtributes = null;
    private MBeanServerConnection MC = null;

    public KeyCacheHitsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlKeyCacheHits = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=KeyCache,name=Hits");
        MBeanKeyCacheHits = CM.getMBeanInfo(urlKeyCacheHits);
        KeyCacheHitsAtributes = MBeanKeyCacheHits.getAttributes();
        MC = CM;
    }
    public String getAtributsKeyCacheHits(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < KeyCacheHitsAtributes.length; j++) {
                if (atrCons[i].equals(KeyCacheHitsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[4] += KeyCacheHitsAtributes[j].getName();
                    attrNames[4] += ",";
                }
            }
        }


        return atributs;

    }
    public void consultaKeyCacheHits (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro KeyCache Hits");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(KeyCacheHitsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlKeyCacheHits, KeyCacheHitsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //_-----------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[4].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlKeyCacheHits, nameAttrSeparats[j]);
            globales.dcd[4][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[4][j]));
            qtyVal[4][j]++;
        }

    }
    public String getValActualKCH(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlKeyCacheHits,AtrCons));
    }
}
