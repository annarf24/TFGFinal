package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class ExceptionsClass implements globales{
    private ObjectName urlExceptions = null;
    private MBeanInfo MBeanExceptions = null;
    private MBeanAttributeInfo[] ExceptionsAtributes = null;
    private MBeanServerConnection MC = null;

    public ExceptionsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlExceptions = new ObjectName("org.apache.cassandra.metrics:type=Storage,name=Exceptions");
        MBeanExceptions = CM.getMBeanInfo(urlExceptions);
        ExceptionsAtributes = MBeanExceptions.getAttributes();
        MC = CM;
    }

    public String getAtributsExceptions(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < ExceptionsAtributes.length; j++) {
                if (atrCons[i].equals(ExceptionsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[2] += ExceptionsAtributes[j].getName();
                    attrNames[2] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaExceptions (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[2].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlExceptions, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[2][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[2][j]));
            qtyVal[2][j]++;
            ValAct[2][j] = a;

        }

    }
    public String getValActualE(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlExceptions,AtrCons));
    }

}
