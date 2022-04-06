package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class TotalDiskSpaceUsedClass implements globales{
    private ObjectName urlTotalDiskSpaceUsed = null;
    private MBeanInfo MBeanTotalDiskSpaceUsed = null;
    private MBeanAttributeInfo[] TotalDiskSpaceUsedAtributes = null;
    private MBeanServerConnection MC = null;

    public TotalDiskSpaceUsedClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlTotalDiskSpaceUsed = new ObjectName("org.apache.cassandra.metrics:type=Table,name=TotalDiskSpaceUsed");
        MBeanTotalDiskSpaceUsed = CM.getMBeanInfo(urlTotalDiskSpaceUsed);
        TotalDiskSpaceUsedAtributes = MBeanTotalDiskSpaceUsed.getAttributes();
        MC = CM;
    }

    public String getAtributsTotalDiskSpaceUsed(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < TotalDiskSpaceUsedAtributes.length; j++) {
                if (atrCons[i].equals(TotalDiskSpaceUsedAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[15] += TotalDiskSpaceUsedAtributes[j].getName();
                    attrNames[15] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaTotalDiskSpaceUsed (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro TotalDiskSpaceUsed");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(TotalDiskSpaceUsedAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlTotalDiskSpaceUsed, TotalDiskSpaceUsedAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[15].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlTotalDiskSpaceUsed, nameAttrSeparats[j]);
            globales.dcd[15][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[15][j]));
            qtyVal[15][j]++;
        }
    }

    public String getValActualTDSU(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlTotalDiskSpaceUsed,AtrCons));
    }

}