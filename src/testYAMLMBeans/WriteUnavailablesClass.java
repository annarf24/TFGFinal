package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class WriteUnavailablesClass implements globales{
    private ObjectName urlWriteUnavailables = null;
    private MBeanInfo MBeanWriteUnavailables = null;
    private MBeanAttributeInfo[] WriteUnavailablesAtributes = null;
    private MBeanServerConnection MC = null;

    public WriteUnavailablesClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlWriteUnavailables = new ObjectName("org.apache.cassandra.metrics:type=ClientRequest,scope=Write,name=Unavailables");
        MBeanWriteUnavailables = CM.getMBeanInfo(urlWriteUnavailables);
        WriteUnavailablesAtributes = MBeanWriteUnavailables.getAttributes();
        MC = CM;
    }

    public String getAtributsWriteUnavailables(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < WriteUnavailablesAtributes.length; j++) {
                if (atrCons[i].equals(WriteUnavailablesAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaWriteUnavailables (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro Write Unavailables");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(WriteUnavailablesAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlWriteUnavailables, WriteUnavailablesAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }
}

