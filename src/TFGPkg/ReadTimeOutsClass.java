package TFGPkg;

import javax.management.*;
import java.io.IOException;

public class ReadTimeOutsClass implements globales{
    private ObjectName urlReadTimeOuts = null;
    private MBeanInfo MBeanReadTimeOuts = null;
    private MBeanAttributeInfo[] ReadTimeOutsAtributes = null;
    private MBeanServerConnection MC = null;

    public ReadTimeOutsClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlReadTimeOuts = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=Timeouts");
        MBeanReadTimeOuts = CM.getMBeanInfo(urlReadTimeOuts);
        ReadTimeOutsAtributes = MBeanReadTimeOuts.getAttributes();
        MC = CM;
    }

    public String getAtributsReadTimeOuts(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < ReadTimeOutsAtributes.length; j++) {
                if (atrCons[i].equals(ReadTimeOutsAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaReadTimeOuts (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Read TimeOuts");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(ReadTimeOutsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlReadTimeOuts, ReadTimeOutsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
