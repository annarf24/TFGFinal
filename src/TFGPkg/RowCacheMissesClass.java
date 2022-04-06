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
                    attrNames[13] += RowCacheMissesAtributes[j].getName();
                    attrNames[13] += ",";
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

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[13].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {
            String a = "";
            a += MC.getAttribute(urlRowCacheMisses, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[13][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[13][j]));
            qtyVal[13][j]++;
            ValAct[13][j] = a;
        }
    }

    public String getValActualRCM(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlRowCacheMisses,AtrCons));
    }
}