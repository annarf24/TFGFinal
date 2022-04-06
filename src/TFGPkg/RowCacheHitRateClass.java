package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class RowCacheHitRateClass implements globales{
    private ObjectName urlRowCacheHitRate = null;
    private MBeanInfo MBeanRowCacheHitRate = null;
    private MBeanAttributeInfo[] RowCacheHitRateAtributes = null;
    private MBeanServerConnection MC = null;

    public RowCacheHitRateClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlRowCacheHitRate = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=RowCache,name=HitRate");
        MBeanRowCacheHitRate = CM.getMBeanInfo(urlRowCacheHitRate);
        RowCacheHitRateAtributes = MBeanRowCacheHitRate.getAttributes();
        MC = CM;
    }

    public String getAtributsRowCacheHitRate(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++) {
            for (int j = 0; j < RowCacheHitRateAtributes.length; j++) {
                if (atrCons[i].equals(RowCacheHitRateAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheHitRate(String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro RowCache HitRate");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(RowCacheHitRateAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlRowCacheHitRate, RowCacheHitRateAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
