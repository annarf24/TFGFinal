package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

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

    }
}
