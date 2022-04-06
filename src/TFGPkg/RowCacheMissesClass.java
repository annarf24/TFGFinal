package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class RowCacheMissesClass implements globales{
    private ObjectName urlRowCacheMisses = null;
    private MBeanInfo MBeanRowCacheMisses = null;
    private MBeanAttributeInfo[] RowCacheMissesAtributes = null;
    private MBeanServerConnection MC = null;

    public RowCacheMissesClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlRowCacheMisses = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=RowCache,name=Misses");
        MBeanRowCacheMisses = CM.getMBeanInfo(urlRowCacheMisses);
        RowCacheMissesAtributes = MBeanRowCacheMisses.getAttributes();
        MC = CM;
    }

    public String getAtributsRowCacheMisses(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < RowCacheMissesAtributes.length; j++) {
                if (atrCons[i].equals(RowCacheMissesAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheMisses (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro RowCache Misses");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(RowCacheMissesAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlRowCacheMisses, RowCacheMissesAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}