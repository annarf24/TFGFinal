package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class RowCacheRequestsClass implements globales{
    private ObjectName urlRowCacheRequests = null;
    private MBeanInfo MBeanRowCacheRequests = null;
    private MBeanAttributeInfo[] RowCacheRequestsAtributes = null;
    private MBeanServerConnection MC = null;

    public RowCacheRequestsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlRowCacheRequests = new ObjectName("org.apache.cassandra.metrics:type=Cache,scope=RowCache,name=Requests");
        MBeanRowCacheRequests = CM.getMBeanInfo(urlRowCacheRequests);
        RowCacheRequestsAtributes = MBeanRowCacheRequests.getAttributes();
        MC = CM;
    }

    public String getAtributsRowCacheRequests(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < RowCacheRequestsAtributes.length; j++) {
                if (atrCons[i].equals(RowCacheRequestsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[14] += RowCacheRequestsAtributes[j].getName();
                    attrNames[14] += ",";

                }
            }
        }
        return atributs;
    }

    public void consultaRowCacheRequests (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[14].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {
            String a = "";
            a += MC.getAttribute(urlRowCacheRequests, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[14][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[14][j]));
            qtyVal[14][j]++;
            ValAct[14][j] = a;
        }
    }

    public String getValActualRCR(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlRowCacheRequests,AtrCons));
    }
}
