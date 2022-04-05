package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class ReadUnavailablesClass implements globales{
    private ObjectName urlReadUnavailables = null;
    private MBeanInfo MBeanReadUnavailables = null;
    private MBeanAttributeInfo[] ReadUnavailablesAtributes = null;
    private MBeanServerConnection MC = null;

    public ReadUnavailablesClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlReadUnavailables = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Read,name=Unavailables");
        MBeanReadUnavailables = CM.getMBeanInfo(urlReadUnavailables);
        ReadUnavailablesAtributes = MBeanReadUnavailables.getAttributes();
        MC = CM;
    }

    public String getAtributsReadUnavailables(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < ReadUnavailablesAtributes.length; j++) {
                if (atrCons[i].equals(ReadUnavailablesAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaReadUnavailables (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Read Unavailables");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(ReadUnavailablesAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlReadUnavailables, ReadUnavailablesAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}