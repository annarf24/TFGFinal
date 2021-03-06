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
                    attrNames[11] += RowCacheHitRateAtributes[j].getName();
                    attrNames[11] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheHitRate(String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[11].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlRowCacheHitRate, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[11][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[11][j]));
            qtyVal[11][j]++;
            ValAct[11][j] = a;
        }
    }

    public String getValActualRCHR(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlRowCacheHitRate,AtrCons));
    }

}

