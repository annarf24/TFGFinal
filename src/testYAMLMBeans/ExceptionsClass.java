package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

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
                }
            }
        }
        return atributs;
    }

    public void consultaExceptions (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Exceptions");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(ExceptionsAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlExceptions, ExceptionsAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
