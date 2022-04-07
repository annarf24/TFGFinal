package TFGPkg;

import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

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


        //Bucle que añade los atributos a los comboBox de los parametros seleccionados en el YAML
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

        //Bucle para borrar los tabs que no se han seleccionado en el YAML
        int i = 0;
        int j = 0;
        while (i < 20) {
            if (!globales.EliminarTab[i]) {
                this.tabbedPane1.remove(j);
            }
            else j++;
            i++;
        }

        //---------------------------------------------------------------------------------------------
        //---------------------------LISTENERS DE LOS BOTONES DE CHOOSE--------------------------------
        //---------------------------------------------------------------------------------------------
        chooseButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[0].split(",");
                gNum[0] = comboBoxAMHS.getSelectedIndex();
                GraficaAMHS.removeAll();

                if(globales.ValAct[0][gNum[0]].contains("E")) {
                    String[] partes = globales.ValAct[0][gNum[0]].split("E");
                    jchart[0][gNum[0]] = ChartFactory.createLineChart("Parametro AllMemtablesHeapSize", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])]);
                }
                else {
                    jchart[0][gNum[0]] = ChartFactory.createLineChart("Parametro AllMemtablesHeapSize", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[0][gNum[0]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaAMHS.setLayout(new BorderLayout());
                GraficaAMHS.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[1].split(",");
                gNum[1] = comboBoxCT.getSelectedIndex();
                GraficaCT.removeAll();

                if(globales.ValAct[1][gNum[1]].contains("E")) {
                    String[] partes = globales.ValAct[1][gNum[1]].split("E");
                    jchart[1][gNum[1]] = ChartFactory.createLineChart("Parametro CompetedTasks", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])]);
                }
                else {
                    jchart[1][gNum[1]] = ChartFactory.createLineChart("Parametro CompletedTasks", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[1][gNum[1]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaCT.setLayout(new BorderLayout());
                GraficaCT.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[2].split(",");
                gNum[2] = comboBoxE.getSelectedIndex();
                GraficaE.removeAll();

                if(globales.ValAct[2][gNum[2]].contains("E")) {
                    String[] partes = globales.ValAct[2][gNum[2]].split("E");
                    jchart[2][gNum[2]] = ChartFactory.createLineChart("Parametro Exceptions", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])]);
                }
                else {
                    jchart[2][gNum[2]] = ChartFactory.createLineChart("Parametro Exceptions", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[2][gNum[2]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaE.setLayout(new BorderLayout());
                GraficaE.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[3].split(",");
                gNum[3] = comboBoxKCHR.getSelectedIndex();
                GraficaKCHR.removeAll();

                if(globales.ValAct[3][gNum[3]].contains("E")) {
                    String[] partes = globales.ValAct[3][gNum[3]].split("E");
                    jchart[3][gNum[3]] = ChartFactory.createLineChart("Parametro KeyCacheHitRate", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])]);
                }
                else {
                    jchart[3][gNum[3]] = ChartFactory.createLineChart("Parametro KeyCacheHitRate", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[3][gNum[3]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaKCHR.setLayout(new BorderLayout());
                GraficaKCHR.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[4].split(",");
                gNum[4] = comboBoxKCH.getSelectedIndex();
                GraficaKCH.removeAll();

                if(globales.ValAct[4][gNum[4]].contains("E")) {
                    String[] partes = globales.ValAct[4][gNum[4]].split("E");
                    jchart[4][gNum[4]] = ChartFactory.createLineChart("Parametro KeyCacheHits", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])]);
                }
                else {
                    jchart[4][gNum[4]] = ChartFactory.createLineChart("Parametro KeyCacheHits", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[4][gNum[4]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaKCH.setLayout(new BorderLayout());
                GraficaKCH.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[5].split(",");
                gNum[5] = comboBoxKCM.getSelectedIndex();
                GraficaKCM.removeAll();
                if(globales.ValAct[5][gNum[5]].contains("E")) {
                    String[] partes = globales.ValAct[5][gNum[5]].split("E");
                    jchart[5][gNum[5]] = ChartFactory.createLineChart("Parametro KeyCacheMisses", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])]);
                }
                else {
                    jchart[5][gNum[5]] = ChartFactory.createLineChart("Parametro KeyCacheMisses", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[5][gNum[5]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaKCM.setLayout(new BorderLayout());
                GraficaKCM.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[6].split(",");
                gNum[6] = comboBoxKCR.getSelectedIndex();
                GraficaKCR.removeAll();

                if(globales.ValAct[6][gNum[6]].contains("E")) {
                    String[] partes = globales.ValAct[6][gNum[6]].split("E");
                    jchart[6][gNum[6]] = ChartFactory.createLineChart("Parametro KeyCacheRequests", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])]);
                }
                else {
                    jchart[6][gNum[6]] = ChartFactory.createLineChart("Parametro KeyCacheRequests", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[6][gNum[6]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaKCR.setLayout(new BorderLayout());
                GraficaKCR.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[7].split(",");
                gNum[7] = comboBoxRL.getSelectedIndex();
                GraficaRL.removeAll();

                if(globales.ValAct[7][gNum[7]].contains("E")) {
                    String[] partes = globales.ValAct[7][gNum[7]].split("E");
                    jchart[7][gNum[7]] = ChartFactory.createLineChart("Parametro ReadLatency", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])]);
                }
                else {
                    jchart[7][gNum[7]] = ChartFactory.createLineChart("Parametro ReadLatency", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[7][gNum[7]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRL.setLayout(new BorderLayout());
                GraficaRL.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[8].split(",");
                gNum[8] = comboBoxRTO.getSelectedIndex();
                GraficaRTO.removeAll();

                if(globales.ValAct[8][gNum[8]].contains("E")) {
                    String[] partes = globales.ValAct[8][gNum[8]].split("E");
                    jchart[8][gNum[8]] = ChartFactory.createLineChart("Parametro ReadTimeOuts", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[6][Integer.parseInt(IndexAttr[gNum[8]])]);
                }
                else {
                    jchart[8][gNum[8]] = ChartFactory.createLineChart("Parametro ReadTimeOuts", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[8][Integer.parseInt(IndexAttr[gNum[8]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[8][gNum[8]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRTO.setLayout(new BorderLayout());
                GraficaRTO.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[9].split(",");
                gNum[9] = comboBoxRTL.getSelectedIndex();
                GraficaRTL.removeAll();

                if(globales.ValAct[9][gNum[9]].contains("E")) {
                    String[] partes = globales.ValAct[9][gNum[9]].split("E");
                    jchart[9][gNum[9]] = ChartFactory.createLineChart("Parametro ReadTotalLatency", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])]);
                }
                else {
                    jchart[9][gNum[9]] = ChartFactory.createLineChart("Parametro ReadTotalLatency", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[9][gNum[9]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRTL.setLayout(new BorderLayout());
                GraficaRTL.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[10].split(",");
                gNum[10] = comboBoxRU.getSelectedIndex();
                GraficaRU.removeAll();

                if(globales.ValAct[10][gNum[10]].contains("E")) {
                    String[] partes = globales.ValAct[10][gNum[10]].split("E");
                    jchart[10][gNum[10]] = ChartFactory.createLineChart("Parametro ReadUnavailables", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])]);
                }
                else {
                    jchart[10][gNum[10]] = ChartFactory.createLineChart("Parametro ReadUnavailables", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[10][gNum[10]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRU.setLayout(new BorderLayout());
                GraficaRU.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[11].split(",");
                gNum[11] = comboBoxRCHR.getSelectedIndex();
                GraficaRCHR.removeAll();

                if(globales.ValAct[11][gNum[11]].contains("E")) {
                    String[] partes = globales.ValAct[11][gNum[11]].split("E");
                    jchart[11][gNum[11]] = ChartFactory.createLineChart("Parametro RowCacheHitRate", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])]);
                }
                else {
                    jchart[11][gNum[11]] = ChartFactory.createLineChart("Parametro RowCacheHitRate", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[11][gNum[11]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRCHR.setLayout(new BorderLayout());
                GraficaRCHR.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[12].split(",");
                gNum[12] = comboBoxRCH.getSelectedIndex();
                GraficaRCH.removeAll();

                if(globales.ValAct[12][gNum[12]].contains("E")) {
                    String[] partes = globales.ValAct[12][gNum[12]].split("E");
                    jchart[12][gNum[12]] = ChartFactory.createLineChart("Parametro RowCacheHits", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])]);
                }
                else {
                    jchart[12][gNum[12]] = ChartFactory.createLineChart("Parametro RowCacheHits", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[12][gNum[12]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRCH.setLayout(new BorderLayout());
                GraficaRCH.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[13].split(",");
                gNum[13] = comboBoxRCM.getSelectedIndex();
                GraficaRCM.removeAll();

                if(globales.ValAct[13][gNum[13]].contains("E")) {
                    String[] partes = globales.ValAct[13][gNum[13]].split("E");
                    jchart[13][gNum[13]] = ChartFactory.createLineChart("Parametro RowCacheMisses", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])]);
                }
                else {
                    jchart[13][gNum[13]] = ChartFactory.createLineChart("Parametro RowCacheMisses", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[13][gNum[13]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRCM.setLayout(new BorderLayout());
                GraficaRCM.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[14].split(",");
                gNum[14] = comboBoxRCR.getSelectedIndex();
                GraficaRCR.removeAll();

                if(globales.ValAct[14][gNum[14]].contains("E")) {
                    String[] partes = globales.ValAct[14][gNum[14]].split("E");
                    jchart[14][gNum[14]] = ChartFactory.createLineChart("Parametro RowCacheRequests", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])]);
                }
                else {
                    jchart[14][gNum[14]] = ChartFactory.createLineChart("Parametro RowCacheRequests", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[14][gNum[14]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaRCR.setLayout(new BorderLayout());
                GraficaRCR.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();

            }
        });

        chooseButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[15].split(",");
                gNum[15] = comboBoxTDSU.getSelectedIndex();
                GraficaTDSU.removeAll();

                if(globales.ValAct[15][gNum[15]].contains("E")) {
                    String[] partes = globales.ValAct[15][gNum[15]].split("E");
                    jchart[15][gNum[15]] = ChartFactory.createLineChart("Parametro TotalDiskSpaceUsed", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])]);
                }
                else {
                    jchart[15][gNum[15]] = ChartFactory.createLineChart("Parametro TotalDiskSpaceUsed", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[15][gNum[15]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaTDSU.setLayout(new BorderLayout());
                GraficaTDSU.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[16].split(",");
                gNum[16] = comboBoxWL.getSelectedIndex();
                GraficaWL.removeAll();

                if(globales.ValAct[16][gNum[16]].contains("E")) {
                    String[] partes = globales.ValAct[16][gNum[16]].split("E");
                    jchart[16][gNum[16]] = ChartFactory.createLineChart("Parametro WriteLatency", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])]);
                }
                else {
                    jchart[16][gNum[16]] = ChartFactory.createLineChart("Parametro WriteLatency", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[16][gNum[16]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaWL.setLayout(new BorderLayout());
                GraficaWL.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[17].split(",");
                gNum[17] = comboBoxWTO.getSelectedIndex();
                GraficaWTO.removeAll();

                if(globales.ValAct[17][gNum[17]].contains("E")) {
                    String[] partes = globales.ValAct[17][gNum[17]].split("E");
                    jchart[17][gNum[17]] = ChartFactory.createLineChart("Parametro WriteTimeOuts", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])]);
                }
                else {
                    jchart[17][gNum[17]] = ChartFactory.createLineChart("Parametro WriteTimeOuts", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[17][gNum[17]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaWTO.setLayout(new BorderLayout());
                GraficaWTO.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[18].split(",");
                gNum[18] = comboBoxWTL.getSelectedIndex();
                GraficaWTL.removeAll();

                if(globales.ValAct[18][gNum[18]].contains("E")) {
                    String[] partes = globales.ValAct[18][gNum[18]].split("E");
                    jchart[18][gNum[18]] = ChartFactory.createLineChart("Parametro WriteTotalLatency", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])]);
                }
                else {
                    jchart[18][gNum[18]] = ChartFactory.createLineChart("Parametro WriteTotalLatency", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[18][gNum[18]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaWTL.setLayout(new BorderLayout());
                GraficaWTL.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        chooseButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[19].split(",");
                gNum[19] = comboBoxWU.getSelectedIndex();
                GraficaWU.removeAll();

                if(globales.ValAct[19][gNum[19]].contains("E")) {
                    String[] partes = globales.ValAct[19][gNum[19]].split("E");
                    jchart[19][gNum[19]] = ChartFactory.createLineChart("Parametro WriteUnavailables", "Cantidad de datos recogidos", "Valor del atributo (E" + partes[1] + ")",
                            globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])]);
                }
                else {
                    jchart[19][gNum[19]] = ChartFactory.createLineChart("Parametro WriteUnavailables", "Cantidad de datos recogidos","Valor del atributo",
                            globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])]);
                }

                ChartPanel cPanel = new ChartPanel(jchart[19][gNum[19]]);
                cPanel.setMouseWheelEnabled(true);
                cPanel.setPreferredSize(new Dimension(500,400));

                GraficaWU.setLayout(new BorderLayout());
                GraficaWU.add(cPanel, BorderLayout.NORTH);
                pack();
                repaint();
            }
        });

        //---------------------------------------------------------------------------------------------
        //---------------------------LISTENERS DE LOS BOTONES DE RESET---------------------------------
        //---------------------------------------------------------------------------------------------

        ResetButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[0].split(",");
                globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])].clear();
                globales.qtyVal[0][gNum[0]] = 0;
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[1].split(",");
                globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])].clear();
                globales.qtyVal[1][gNum[1]] = 0;
            }
        });

        ResetButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[2].split(",");
                globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])].clear();
                globales.qtyVal[2][gNum[2]] = 0;
            }
        });

        ResetButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[3].split(",");
                globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])].clear();
                globales.qtyVal[3][gNum[3]] = 0;
            }
        });

        ResetButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[4].split(",");
                globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])].clear();
                globales.qtyVal[4][gNum[4]] = 0;
            }
        });

        ResetButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[5].split(",");
                globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])].clear();
                globales.qtyVal[5][gNum[5]] = 0;
            }
        });

        ResetButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[6].split(",");
                globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])].clear();
                globales.qtyVal[6][gNum[6]] = 0;
            }
        });

        ResetButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[7].split(",");
                globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])].clear();
                globales.qtyVal[7][gNum[7]] = 0;
            }
        });

        ResetButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[8].split(",");
                globales.dcd[8][Integer.parseInt(IndexAttr[gNum[8]])].clear();
                globales.qtyVal[8][gNum[8]] = 0;
            }
        });

        ResetButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[9].split(",");
                globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])].clear();
                globales.qtyVal[9][gNum[9]] = 0;
            }
        });

        ResetButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[10].split(",");
                globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])].clear();
                globales.qtyVal[10][gNum[10]] = 0;
            }
        });

        ResetButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[11].split(",");
                globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])].clear();
                globales.qtyVal[11][gNum[11]] = 0;
            }
        });

        ResetButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[12].split(",");
                globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])].clear();
                globales.qtyVal[12][gNum[12]] = 0;
            }
        });

        ResetButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[13].split(",");
                globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])].clear();
                globales.qtyVal[13][gNum[13]] = 0;
            }
        });

        ResetButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[14].split(",");
                globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])].clear();
                globales.qtyVal[14][gNum[14]] = 0;
            }
        });

        ResetButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[15].split(",");
                globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])].clear();
                globales.qtyVal[15][gNum[15]] = 0;
            }
        });

        ResetButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[16].split(",");
                globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])].clear();
                globales.qtyVal[16][gNum[16]] = 0;
            }
        });

        ResetButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[17].split(",");
                globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])].clear();
                globales.qtyVal[17][gNum[17]] = 0;
            }
        });

        ResetButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[18].split(",");
                globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])].clear();
                globales.qtyVal[18][gNum[18]] = 0;
            }
        });

        ResetButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] IndexAttr = globales.attr[19].split(",");
                globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])].clear();
                globales.qtyVal[19][gNum[19]] = 0;
            }
        });

        //---------------------------------------------------------------------------------------------
        //---------------------------LISTENERS DE LOS BOTONES DE SAVE----------------------------------
        //---------------------------------------------------------------------------------------------

        SaveButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngAMHS.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[0][gNum[0]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngCT.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[1][gNum[1]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngE.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[2][gNum[2]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngKCHR.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[3][gNum[3]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngKCH.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[4][gNum[4]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngKCM.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[5][gNum[5]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngKCR.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[6][gNum[6]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRL.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[7][gNum[7]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRTO.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[8][gNum[8]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRTL.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[9][gNum[9]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRU.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[10][gNum[10]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRCHR.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[11][gNum[11]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRCH.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[12][gNum[12]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRCM.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[13][gNum[13]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngRCR.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[14][gNum[14]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        SaveButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngTDSU.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[15][gNum[15]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngWL.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[16][gNum[16]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngWTO.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[17][gNum[17]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngWTL.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[18][gNum[18]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        SaveButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File(NombrePngWU.getText() + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[19][gNum[19]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
