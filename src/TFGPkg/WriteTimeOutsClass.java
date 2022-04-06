package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class WriteTimeOutsClass implements globales{
    private ObjectName urlWriteTimeOuts = null;
    private MBeanInfo MBeanWriteTimeOuts = null;
    private MBeanAttributeInfo[] WriteTimeOutsAtributes = null;
    private MBeanServerConnection MC = null;

    public WriteTimeOutsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlWriteTimeOuts = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Write,name=Timeouts");
        MBeanWriteTimeOuts = CM.getMBeanInfo(urlWriteTimeOuts);
        WriteTimeOutsAtributes = MBeanWriteTimeOuts.getAttributes();
        MC = CM;
    }

    public String getAtributsWriteTimeOuts(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < WriteTimeOutsAtributes.length; j++) {
                if (atrCons[i].equals(WriteTimeOutsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                    attrNames[17] += WriteTimeOutsAtributes[j].getName();
                    attrNames[17] += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaWriteTimeOuts (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Write TimeOuts");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(WriteTimeOutsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlWriteTimeOuts, WriteTimeOutsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[17].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlWriteTimeOuts, nameAttrSeparats[j]);
            globales.dcd[17][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(a),nameAttrSeparats[j],String.valueOf(qtyVal[17][j]));
            qtyVal[17][j]++;
        }
    }

    public String getValActualWTO(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlWriteTimeOuts,AtrCons));
    }
}
