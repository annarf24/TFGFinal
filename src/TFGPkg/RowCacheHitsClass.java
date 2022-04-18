package TFGPkg;

import javax.management.*;
import java.io.IOException;

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
                    attrNames[12] += RowCacheHitsAtributes[j].getName();
                    attrNames[12] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheHits (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[12].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlRowCacheHits, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[12][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[12][j]));
            qtyVal[12][j]++;
            ValAct[12][j] = a;

        }
    }

    public String getValActualRCH(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlRowCacheHits,AtrCons));
    }

}