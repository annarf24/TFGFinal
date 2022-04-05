package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class RowCacheHitsClass implements globales{
    private ObjectName urlRowCacheHits = null;
    private MBeanInfo MBeanRowCacheHits = null;
    private MBeanAttributeInfo[] RowCacheHitsAtributes = null;
    private MBeanServerConnection MC = null;

    public RowCacheHitsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlRowCacheHits = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=RowCache,name=Hits");
        MBeanRowCacheHits = CM.getMBeanInfo(urlRowCacheHits);
        RowCacheHitsAtributes = MBeanRowCacheHits.getAttributes();
        MC = CM;
    }

    public String getAtributsRowCacheHits(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < RowCacheHitsAtributes.length; j++) {
                if (atrCons[i].equals(RowCacheHitsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheHits (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro RowCache Hits");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(RowCacheHitsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlRowCacheHits, RowCacheHitsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}