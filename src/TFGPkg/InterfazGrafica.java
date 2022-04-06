package TFGPkg;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazGrafica extends JFrame{
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel AllMemtablesHeapSizeJPanel;
    private JPanel CompletedTasksJPanel;
    private JPanel ExceptionsJPanel;
    private JPanel KeyCacheHitRateJPanel;
    private JPanel KeyCacheHitsJPanel;
    private JPanel KeyCacheMissesJPanel;
    private JPanel KeyCacheRequestsJPanel;
    private JPanel ReadLatencyJPanel;
    private JPanel ReadTimeOutsJPanel;
    private JPanel ReadTotalLatencyJPanel;
    private JPanel ReadUnavailablesJPanel;
    private JPanel RowCacheHitRateJPanel;
    private JPanel RowCacheHitsJPanel;
    private JPanel RowCacheMissesJPanel;
    private JPanel RowCacheRequestsJPanel;
    private JComboBox comboBoxAMHS;
    private JTextField NombrePngAMHS;
    private JLabel ValorActualAMHS;
    private JPanel GraficaAMHS;
    private JButton ResetButtonAMHS;
    private JTextField NombrePngCT;
    private JComboBox comboBoxCT;
    private JButton SaveButtonCT;
    private JPanel GraficaCT;
    private JLabel ValorActualCT;
    private JComboBox comboBoxE;
    private JTextField NombrePngE;
    private JButton ResetButtonE;
    private JButton SaveButtonE;
    private JPanel GraficaE;
    private JLabel ValorActualE;
    private JComboBox comboBoxKCHR;
    private JTextField NombrePngKCHR;
    private JButton ResetButtonKCHR;
    private JButton SaveButtonKCHR;
    private JPanel GraficaKCHR;
    private JLabel ValorActualKCHR;
    private JComboBox comboBoxKCH;
    private JTextField NombrePngKCH;
    private JButton SaveButtonKCH;
    private JButton ResetButtonKCH;
    private JPanel GraficaKCH;
    private JLabel ValorActualKCH;
    private JComboBox comboBoxKCM;
    private JTextField NombrePngKCM;
    private JButton ResetButtonKCM;
    private JButton SaveButtonKCM;
    private JPanel GraficaKCM;
    private JLabel ValorActualKCM;
    private JComboBox comboBoxKCR;
    private JTextField NombrePngKCR;
    private JButton SaveButtonKCR;
    private JButton ResetButtonKCR;
    private JPanel GraficaKCR;
    private JLabel ValorActualKCR;
    private JComboBox comboBoxRL;
    private JTextField NombrePngRL;
    private JButton ResetButtonRL;
    private JButton SaveButtonRL;
    private JPanel GraficaRL;
    private JLabel ValorActualRL;
    private JComboBox comboBoxRTO;
    private JTextField NombrePngRTO;
    private JButton SaveButtonRTO;
    private JButton ResetButtonRTO;
    private JPanel GraficaRTO;
    private JLabel ValorActualRTO;
    private JComboBox comboBoxRTL;
    private JTextField NombrePngRTL;
    private JButton ResetButtonRTL;
    private JButton SaveButtonRTL;
    private JPanel GraficaRTL;
    private JLabel ValorActualRTL;
    private JComboBox comboBoxRU;
    private JTextField NombrePngRU;
    private JButton ResetButtonRU;
    private JButton SaveButtonRU;
    private JPanel GraficaRU;
    private JLabel ValorActualRU;
    private JComboBox comboBoxRCHR;
    private JTextField NombrePngRCHR;
    private JButton ResetButtonRCHR;
    private JButton SaveButtonRCHR;
    private JPanel GraficaRCHR;
    private JLabel ValorActualRCHR;
    private JComboBox comboBoxRCH;
    private JTextField NombrePngRCH;
    private JButton SaveButtonRCH;
    private JButton ResetButtonRCH;
    private JPanel GraficaRCH;
    private JLabel ValorActualRCH;
    private JComboBox comboBoxRCM;
    private JTextField NombrePngRCM;
    private JButton ResetButtonRCM;
    private JButton SaveButtonRCM;
    private JPanel GraficaRCM;
    private JLabel ValorActualRCM;
    private JComboBox comboBoxRCR;
    private JTextField NombrePngRCR;
    private JButton ResetButtonRCR;
    private JButton SaveButtonRCR;
    private JPanel GraficaRCR;
    private JLabel ValorActualRCR;
    private JPanel TotalDiskSpaceUsedJPanel;
    private JComboBox comboBoxTDSU;
    private JTextField NombrePngTDSU;
    private JButton ResetButtonTDSU;
    private JButton SaveButtonTDSU;
    private JPanel GraficaTDSU;
    private JLabel ValorActualTDSU;
    private JPanel WriteLatencyJPanel;
    private JComboBox comboBoxWL;
    private JTextField NombrePngWL;
    private JButton ResetButtonWL;
    private JButton SaveButtonWL;
    private JPanel GraficaWL;
    private JLabel ValorActualWL;
    private JPanel WriteTimeOutsJPanel;
    private JComboBox comboBoxWTO;
    private JTextField NombrePngWTO;
    private JButton ResetButtonWTO;
    private JButton SaveButtonWTO;
    private JPanel GraficaWTO;
    private JLabel ValorActualWTO;
    private JPanel WriteTotalLatencyJPanel;
    private JPanel WriteUnavailablesJPanel;
    private JComboBox comboBoxWTL;
    private JTextField NombrePngWTL;
    private JButton ResetButtonWTL;
    private JButton SaveButtonWTL;
    private JPanel GraficaWTL;
    private JLabel ValorActualWTL;
    private JComboBox comboBoxWU;
    private JTextField NombrePngWU;
    private JButton ResetButtonWU;
    private JButton SaveButtonWU;
    private JPanel GraficaWU;
    private JLabel ValorActualWU;
    private JButton SaveButtonAMHS;
    private JButton chooseButtonKCH;
    private JButton chooseButtonKCHR;
    private JButton chooseButtonAMHS;
    private JButton chooseButtonCT;
    private JButton chooseButtonE;
    private JButton resetButton;
    private JButton chooseButtonKCM;
    private JButton chooseButtonKCR;
    private JButton chooseButtonRL;
    private JButton chooseButtonRTO;
    private JButton chooseButtonRTL;
    private JButton chooseButtonRU;
    private JButton chooseButtonRCHR;
    private JButton chooseButtonRCH;
    private JButton chooseButtonRCM;
    private JButton chooseButtonRCR;
    private JButton chooseButtonTDSU;
    private JButton chooseButtonWL;
    private JButton chooseButtonWTO;
    private JButton chooseButtonWTL;
    private JButton chooseButtonWU;


    public InterfazGrafica(String title) {
        //para ponerle titulo a la pestaña
        super(title);

        //para que se terminen todos los procesos al cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(mainPanel);
        this.pack();

        //para hacer que al iniciar aparezca de un tamaño razonable
        this.setMinimumSize(new Dimension(960, 640));

        //para hacer que al iniciar aparezca en el centro de la pantalla
        this.setLocationRelativeTo(null);


        //matriz de JFreeChart para cada uno de los atributos
        final JFreeChart[][] jchart = {new JFreeChart[1], //AllMemtablesHeapSize
                new JFreeChart[1], //CompletedTasks
                new JFreeChart[1], //Exceptions
                new JFreeChart[1], //KeyCacheHitRate
                new JFreeChart[6], //KeyCacheHits
                new JFreeChart[6], //KeyCacheMisses
                new JFreeChart[1], //KeyCacheRequests
                new JFreeChart[18], //ReadLatency
                new JFreeChart[6], //ReadTimeOuts
                new JFreeChart[1], //ReadTotalLatency
                new JFreeChart[6], //ReadUnavailables
                new JFreeChart[1], //RowCacheHitRate
                new JFreeChart[6], //RowCacheHits
                new JFreeChart[6], //RowCacheMisses
                new JFreeChart[6], //RowCacheRequests
                new JFreeChart[1], //TotalDiskSpaceUsed
                new JFreeChart[18], //WriteLatency
                new JFreeChart[6], //WriteTimeOuts
                new JFreeChart[1], //WriteTotalLatency
                new JFreeChart[6]}; //WriteUnavailables

        //Array que contiene qué opcion del combobox està seleccionada para cada parametro
        final int[] gNum = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        for (int i = 0; i < 20; i++) {
            if (globales.EliminarTab[i]) {
                String [] attrNamesSeparats = globales.attrNames[i].split(",");

                switch (i) {
                    case 0:
                        comboBoxAMHS.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxAMHS.addItem(attr);
                        }
                    case 1:
                        comboBoxCT.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxCT.addItem(attr);
                        }
                    case 2:
                        comboBoxE.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxE.addItem(attr);
                        }
                    case 3:
                        comboBoxKCHR.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCHR.addItem(attr);
                        }
                    case 4:
                        comboBoxKCH.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCH.addItem(attr);
                        }
                    case 5:
                        comboBoxKCM.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCM.addItem(attr);
                        }
                    case 6:
                        comboBoxKCR.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCR.addItem(attr);
                        }
                    case 7:
                        comboBoxRL.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRL.addItem(attr);
                        }
                    case 8:
                        comboBoxRTO.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRTO.addItem(attr);
                        }
                    case 9:
                        comboBoxRTL.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRTL.addItem(attr);
                        }
                    case 10:
                        comboBoxRU.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRU.addItem(attr);
                        }
                    case 11:
                        comboBoxRCHR.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCHR.addItem(attr);
                        }
                    case 12:
                        comboBoxRCH.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCH.addItem(attr);
                        }
                    case 13:
                        comboBoxRCM.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCM.addItem(attr);
                        }
                    case 14:
                        comboBoxRCR.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCR.addItem(attr);
                        }
                    case 15:
                        comboBoxTDSU.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxTDSU.addItem(attr);
                        }
                    case 16:
                        comboBoxWL.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxWL.addItem(attr);
                        }
                    case 17:
                        comboBoxWTO.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxWTO.addItem(attr);
                        }
                    case 18:
                        comboBoxWTL.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxWTL.addItem(attr);
                        }
                    case 19:
                        comboBoxWU.removeAllItems();
                        for (String attr : attrNamesSeparats) {
                            comboBoxWU.addItem(attr);
                        }
                    default:

                }
            }
        }

        int i = 0;
        int j = 0;
        while (i < 20) {
            if (!globales.EliminarTab[i]) {
                this.tabbedPane1.remove(j);
            }
            else j++;
            i++;
        }

        chooseButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[4].split(",");
                gNum[4] = comboBoxKCH.getSelectedIndex();
                GraficaKCH.removeAll();

                jchart[4][gNum[4]] = ChartFactory.createLineChart("Grafica " + gNum[4], "Cantidad de datos","Total Sales",
                        globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])]);

                ChartPanel cPanel = new ChartPanel(jchart[4][gNum[4]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaKCH.setLayout(new BorderLayout());
                GraficaKCH.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[0].split(",");
                gNum[0] = comboBoxAMHS.getSelectedIndex();
                GraficaAMHS.removeAll();

                jchart[0][gNum[0]] = ChartFactory.createLineChart("Grafica " + gNum[0], "Cantidad de datos","Total Sales",
                        globales.dcd[0][Integer.parseInt(IndexAttr[gNum[4]])]);

                ChartPanel cPanel = new ChartPanel(jchart[0][gNum[0]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaAMHS.setLayout(new BorderLayout());
                GraficaAMHS.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });
    }

    public void actualitzaLabel(String val, int i) {
        switch (i) {

            //AllMemtablesHeapSize
            case 1:
                ValorActualAMHS.setText("Valor: "+val);
                break;

            //CompletedTasks
            case 2:
                ValorActualCT.setText("Valor: "+val);
                break;

            //Exceptions
            case 3:
                ValorActualE.setText("Valor: "+val);
                break;

            //KeyCacheHitRate
            case 4:
                ValorActualKCHR.setText("Valor: "+val);
                break;

            //KeyCacheHits
            case 5:
                ValorActualKCH.setText("Valor: "+val);
                break;

            //KeyCacheMisses
            case 6:
                ValorActualKCM.setText("Valor: "+val);
                break;

            //KeyCacheRequests
            case 7:
                ValorActualKCR.setText("Valor: "+val);
                break;

            //ReadLatency
            case 8:
                ValorActualRL.setText("Valor: "+val);
                break;

            //ReadTimeOuts
            case 9:
                ValorActualRTO.setText("Valor: "+val);
                break;

            //ReadTotalLatency
            case 10:
                ValorActualRTL.setText("Valor: "+val);
                break;

            //ReadUnavailables
            case 11:
                ValorActualRU.setText("Valor: "+val);
                break;

            //RowCacheHitRate
            case 12:
                ValorActualRCHR.setText("Valor: "+val);
                break;

            //RowCacheHits
            case 13:
                ValorActualRCH.setText("Valor: "+val);
                break;

            //RowCacheMisses
            case 14:
                ValorActualRCM.setText("Valor: "+val);
                break;

            //RowCacheRequests
            case 15:
                ValorActualRCR.setText("Valor: "+val);
                break;

            //TotalDiskSpaceUsed
            case 16:
                ValorActualTDSU.setText("Valor: "+val);
                break;

            //WriteLatency
            case 17:
                ValorActualWL.setText("Valor: "+val);
                break;

            //WriteTimeOuts
            case 18:
                ValorActualWTO.setText("Valor: "+val);
                break;

            //WriteTotalLatency
            case 19:
                ValorActualWTL.setText("Valor: "+val);
                break;

            //WriteUnavailables
            case 20:
                ValorActualWU.setText("Valor: "+val);
                break;

            default:
                break;
        }

    }

    public String getAtrConsultat(int i) {
        String ret;
        switch (i) {

            //AllMemtablesHeapSize
            case 1:
                ret = String.valueOf(comboBoxAMHS.getSelectedItem());
                break;

            //CompletedTasks
            case 2:
                ret =  String.valueOf(comboBoxCT.getSelectedItem());
                break;

            //Exceptions
            case 3:
                ret = String.valueOf(comboBoxE.getSelectedItem());
                break;

            //KeyCacheHitRate
            case 4:
                ret = String.valueOf(comboBoxKCHR.getSelectedItem());
                break;

            //KeyCacheHits
            case 5:
                ret = String.valueOf(comboBoxKCH.getSelectedItem());
                break;

            //KeyCacheMisses
            case 6:
                ret = String.valueOf(comboBoxKCM.getSelectedItem());
                break;

            //KeyCacheRequests
            case 7:
                ret = String.valueOf(comboBoxKCR.getSelectedItem());
                break;

            //ReadLatency
            case 8:
                ret = String.valueOf(comboBoxRL.getSelectedItem());
                break;

            //ReadTimeOuts
            case 9:
                ret = String.valueOf(comboBoxRTO.getSelectedItem());
                break;

            //ReadTotalLatency
            case 10:
                ret = String.valueOf(comboBoxRTL.getSelectedItem());
                break;

            //ReadUnavailables
            case 11:
                ret = String.valueOf(comboBoxRU.getSelectedItem());
                break;

            //RowCacheHitRate
            case 12:
                ret = String.valueOf(comboBoxRCHR.getSelectedItem());
                break;

            //RowCacheHits
            case 13:
                ret = String.valueOf(comboBoxRCH.getSelectedItem());
                break;

            //RowCacheMisses
            case 14:
                ret = String.valueOf(comboBoxRCM.getSelectedItem());
                break;

            //RowCacheRequests
            case 15:
                ret = String.valueOf(comboBoxRCR.getSelectedItem());
                break;

            //TotalDiskSpaceUsed
            case 16:
                ret = String.valueOf(comboBoxTDSU.getSelectedItem());
                break;

            //WriteLatency
            case 17:
                ret = String.valueOf(comboBoxWL.getSelectedItem());
                break;

            //WriteTimeOuts
            case 18:
                ret = String.valueOf(comboBoxWTO.getSelectedItem());
                break;

            //WriteTotalLatency
            case 19:
                ret = String.valueOf(comboBoxWTL.getSelectedItem());
                break;

            //WriteUnavailables
            case 20:
                ret = String.valueOf(comboBoxWU.getSelectedItem());
                break;

            default:
                ret = "";
                break;
        }

        return ret;
    }
}
