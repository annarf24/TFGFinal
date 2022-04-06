package TFGPkg;

import javax.management.*;
import java.io.IOException;

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
                    attrNames[1] += CompletedTasksAtributes[j].getName();
                    attrNames[1] += ",";
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

        //------------------------------------

        String[] attrSeparats = AtrConsultar.split(",");
        String[] nameAttrSeparats = globales.attrNames[1].split(",");

        for (int j = 0; j < attrSeparats.length; j++) {

            String a = "";
            a += MC.getAttribute(urlCompletedTasks, nameAttrSeparats[j]);
            String[] partes = a.split("E");
            globales.dcd[1][Integer.parseInt(attrSeparats[j])].addValue(Double.parseDouble(partes[0]),nameAttrSeparats[j],String.valueOf(qtyVal[1][j]));
            qtyVal[1][j]++;
            ValAct[1][j] = a;

        }

    }

    public String getValActualCT(String AtrCons) throws ReflectionException, AttributeNotFoundException, InstanceNotFoundException, MBeanException, IOException {
        return String.valueOf(MC.getAttribute(urlCompletedTasks,AtrCons));
    }
}
