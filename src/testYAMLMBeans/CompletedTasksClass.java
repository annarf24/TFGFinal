package testYAMLMBeans;

import javax.management.*;
import java.io.IOException;
import java.util.Scanner;

public class CompletedTasksClass implements globales{
    private ObjectName urlCompletedTasks = null;
    private MBeanInfo MBeanCompletedTasks = null;
    private MBeanAttributeInfo[] CompletedTasksAtributes = null;
    private MBeanServerConnection MC = null;

    public CompletedTasksClass(MBeanServerConnection CM) throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, IntrospectionException, IOException {
        urlCompletedTasks = new ObjectName("org.apache.cassandra.metrics:type=Compaction,name=CompletedTasks");
        MBeanCompletedTasks = CM.getMBeanInfo(urlCompletedTasks);
        CompletedTasksAtributes = MBeanCompletedTasks.getAttributes();
        MC = CM;
    }

    public String getAtributsCompletedTasks(Parametro p) {
        String atributs = "";
        String[] atrCons = p.getAtributs();
        for (int i = 0; i < atrCons.length; i++ ) {
            for (int j = 0; j < CompletedTasksAtributes.length; j++) {
                if (atrCons[i].equals(CompletedTasksAtributes[j].getName())) {
                    atributs += j;
                    atributs += ",";
                }
            }
        }
        return atributs;
    }

    public void consultaCompletedTasks (String AtrConsultar) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        System.out.println("parametro CompletedTasks");
        String[] parts = AtrConsultar.split(",");
        for (String part : parts) {
            System.out.println(CompletedTasksAtributes[Integer.parseInt(part)].getName() + " : "
                    + MC.getAttribute(urlCompletedTasks, CompletedTasksAtributes[Integer.parseInt(part)].getName()));
        }
        System.out.println("---------------------------------");

    }

}
