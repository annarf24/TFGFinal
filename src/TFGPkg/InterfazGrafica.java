package TFGPkg;

import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Timestamp;
import java.util.Arrays;

public class InterfazGrafica extends JFrame implements globales{
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
    private JLabel ValorActualAMHS;
    private JPanel GraficaAMHS;
    private JButton ResetButtonAMHS;
    private JComboBox comboBoxCT;
    private JButton SaveButtonCT;
    private JPanel GraficaCT;
    private JLabel ValorActualCT;
    private JComboBox comboBoxE;
    private JButton ResetButtonE;
    private JButton SaveButtonE;
    private JPanel GraficaE;
    private JLabel ValorActualE;
    private JComboBox comboBoxKCHR;
    private JButton ResetButtonKCHR;
    private JButton SaveButtonKCHR;
    private JPanel GraficaKCHR;
    private JLabel ValorActualKCHR;
    private JComboBox comboBoxKCH;
    private JButton SaveButtonKCH;
    private JButton ResetButtonKCH;
    private JPanel GraficaKCH;
    private JLabel ValorActualKCH;
    private JComboBox comboBoxKCM;
    private JButton ResetButtonKCM;
    private JButton SaveButtonKCM;
    private JPanel GraficaKCM;
    private JLabel ValorActualKCM;
    private JComboBox comboBoxKCR;
    private JButton SaveButtonKCR;
    private JButton ResetButtonKCR;
    private JPanel GraficaKCR;
    private JLabel ValorActualKCR;
    private JComboBox comboBoxRL;
    private JButton ResetButtonRL;
    private JButton SaveButtonRL;
    private JPanel GraficaRL;
    private JLabel ValorActualRL;
    private JComboBox comboBoxRTO;
    private JButton SaveButtonRTO;
    private JButton ResetButtonRTO;
    private JPanel GraficaRTO;
    private JLabel ValorActualRTO;
    private JComboBox comboBoxRTL;
    private JButton ResetButtonRTL;
    private JButton SaveButtonRTL;
    private JPanel GraficaRTL;
    private JLabel ValorActualRTL;
    private JComboBox comboBoxRU;
    private JButton ResetButtonRU;
    private JButton SaveButtonRU;
    private JPanel GraficaRU;
    private JLabel ValorActualRU;
    private JComboBox comboBoxRCHR;
    private JButton ResetButtonRCHR;
    private JButton SaveButtonRCHR;
    private JPanel GraficaRCHR;
    private JLabel ValorActualRCHR;
    private JComboBox comboBoxRCH;
    private JButton SaveButtonRCH;
    private JButton ResetButtonRCH;
    private JPanel GraficaRCH;
    private JLabel ValorActualRCH;
    private JComboBox comboBoxRCM;
    private JButton ResetButtonRCM;
    private JButton SaveButtonRCM;
    private JPanel GraficaRCM;
    private JLabel ValorActualRCM;
    private JComboBox comboBoxRCR;
    private JButton ResetButtonRCR;
    private JButton SaveButtonRCR;
    private JPanel GraficaRCR;
    private JLabel ValorActualRCR;
    private JPanel TotalDiskSpaceUsedJPanel;
    private JComboBox comboBoxTDSU;
    private JButton ResetButtonTDSU;
    private JButton SaveButtonTDSU;
    private JPanel GraficaTDSU;
    private JLabel ValorActualTDSU;
    private JPanel WriteLatencyJPanel;
    private JComboBox comboBoxWL;
    private JButton ResetButtonWL;
    private JButton SaveButtonWL;
    private JPanel GraficaWL;
    private JLabel ValorActualWL;
    private JPanel WriteTimeOutsJPanel;
    private JComboBox comboBoxWTO;
    private JButton ResetButtonWTO;
    private JButton SaveButtonWTO;
    private JPanel GraficaWTO;
    private JLabel ValorActualWTO;
    private JPanel WriteTotalLatencyJPanel;
    private JPanel WriteUnavailablesJPanel;
    private JComboBox comboBoxWTL;
    private JButton ResetButtonWTL;
    private JButton SaveButtonWTL;
    private JPanel GraficaWTL;
    private JLabel ValorActualWTL;
    private JComboBox comboBoxWU;
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
    private JButton saveAllChartsButtonWTL;
    private JLabel InitialTSWTL;
    private JLabel CurrentTSWTL;
    private JLabel ElapsedTimeWTL;
    private JButton saveAllChartsButtonWU;
    private JButton saveAllDataButtonWTL;
    private JButton saveCurrentDataButtonWTL;
    private JButton saveAllChartsButtonAMHS;
    private JButton saveCurrentDataButtonAMHS;
    private JButton saveAllDataButtonAMHS;
    private JButton saveAllChartsButtonCT;
    private JButton saveCurrentDataButtonCT;
    private JButton saveAllDataButtonCT;
    private JLabel InitialTSAMHS;
    private JLabel CurrentTSAMHS;
    private JLabel ElapsedTimeAMHS;
    private JLabel InitialTSCT;
    private JLabel CurrentTSCT;
    private JLabel ElapsedTimeCT;
    private JButton saveAllChartsButtonE;
    private JButton saveCurrentDataButtonE;
    private JButton saveAllDataButtonE;
    private JButton saveAllChartsButtonKCHR;
    private JButton saveCurrentDataButtonKCHR;
    private JButton saveAllDataButtonKCHR;
    private JButton saveCurrentDataButtonKCH;
    private JButton saveAllDataButtonKCH;
    private JButton saveAllChartsButtonKCH;
    private JButton saveAllChartsButtonKCM;
    private JButton saveCurrentDataButtonKCM;
    private JButton saveAllDataButtonKCM;
    private JButton saveAllChartsButtonKCR;
    private JButton saveCurrentDataButtonKCR;
    private JButton saveAllDataButtonKCR;
    private JButton saveAllChartsButtonRL;
    private JButton saveCurrentDataButtonRL;
    private JButton saveAllDataButtonRL;
    private JButton saveAllChartsButtonRTO;
    private JButton saveCurrentDataButtonRTO;
    private JButton saveAllDataButtonRTO;
    private JButton saveAllChartsButtonRTL;
    private JButton saveCurrentDataButtonRTL;
    private JButton saveAllDataButtonRTL;
    private JButton saveAllChartsButtonRU;
    private JButton saveCurrentDataButtonRU;
    private JButton saveAllDataButtonRU;
    private JButton saveAllChartsButtonRCHR;
    private JButton saveCurrentDataButtonRCHR;
    private JButton saveAllDataButtonRCHR;
    private JButton saveAllChartsButtonRCH;
    private JButton saveCurrentDataButtonRCH;
    private JButton saveAllDataButtonRCH;
    private JButton saveAllChartsButtonRCM;
    private JButton saveCurrentDataButtonRCM;
    private JButton saveAllDataButtonRCM;
    private JButton saveAllChartsButtonRCR;
    private JButton saveCurrentDataButtonRCR;
    private JButton saveAllDataButtonRCR;
    private JButton saveAllChartsButtonTDSU;
    private JButton saveCurrentDataButtonTDSU;
    private JButton saveAllDataButtonTDSU;
    private JButton saveAllChartsButtonWL;
    private JButton saveCurrentDataButtonWL;
    private JButton saveAllDataButtonWL;
    private JButton saveAllChartsButtonWTO;
    private JButton saveCurrentDataButtonWTO;
    private JButton saveAllDataButtonWTO;
    private JButton saveCurrentDataButtonWU;
    private JButton saveAllDataButtonWU;
    private JLabel InitialTSE;
    private JLabel CurrentTSE;
    private JLabel ElapsedTimeE;
    private JLabel InitialTSKCHR;
    private JLabel CurrentTSKCHR;
    private JLabel ElapsedTimeKCHR;
    private JLabel InitialTSKCH;
    private JLabel CurrentTSKCH;
    private JLabel ElapsedTimeKCH;
    private JLabel InitialTSKCM;
    private JLabel CurrentTSKCM;
    private JLabel ElapsedTimeKCM;
    private JLabel InitialTSKCR;
    private JLabel CurrentTSKCR;
    private JLabel ElapsedTimeKCR;
    private JLabel InitialTSRL;
    private JLabel CurrentTSRL;
    private JLabel ElapsedTimeRL;
    private JLabel InitialTSWU;
    private JLabel CurrentTSWU;
    private JLabel ElapsedTimeWU;
    private JLabel ElapsedTimeWTO;
    private JLabel CurrentTSWTO;
    private JLabel InitialTSWTO;
    private JLabel ElapsedTimeWL;
    private JLabel CurrentTSWL;
    private JLabel InitialTSWL;
    private JLabel ElapsedTimeTDSU;
    private JLabel CurrentTSTDSU;
    private JLabel InitialTSTDSU;
    private JLabel ElapsedTimeRCR;
    private JLabel CurrentTSRCR;
    private JLabel InitialTSRCR;
    private JLabel ElapsedTimeRCM;
    private JLabel CurrentTSRCM;
    private JLabel InitialTSRCM;
    private JLabel ElapsedTimeRCH;
    private JLabel CurrentTSRCH;
    private JLabel InitialTSRCH;
    private JLabel ElapsedTimeRCHR;
    private JLabel CurrentTSRCHR;
    private JLabel InitialTSRCHR;
    private JLabel ElapsedTimeRU;
    private JLabel CurrentTSRU;
    private JLabel InitialTSRU;
    private JLabel ElapsedTimeRTL;
    private JLabel CurrentTSRTL;
    private JLabel InitialTSRTL;
    private JLabel ElapsedTimeRTO;
    private JLabel CurrentTSRTO;
    private JLabel InitialTSRTO;

    private Boolean[][] creada = {{false}, //AllMemtablesHeapSize
            {false}, //CompletedTasks
            {false}, //Exceptions
            {false}, //KeyCacheHitRate
            {false, false, false, false, false, false}, //KeyCacheHits
            {false, false, false, false, false, false}, //KeyCacheMisses
            {false, false, false, false, false, false}, //KeyCacheRequests
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, //ReadLatency
            {false, false, false, false, false, false}, //ReadTimeouts
            {false}, //ReadTotalLatency
            {false, false, false, false, false, false}, //ReadUnavailabes
            {false}, //RowCahceHitRate
            {false, false, false, false, false, false}, //RowCacheHits
            {false, false, false, false, false, false}, //RowCacheMisses
            {false, false, false, false, false, false}, //RowCacheRequests
            {false}, //TotalDiskSpaceUsed
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, //WriteLatency
            {false, false, false, false, false, false}, //WriteTimeouts
            {false}, //WriteTotalLatency
            {false, false, false, false, false, false}, //WriteUnavailabes
    };

    final int[] h = {0};
    final int[] m = {0};
    final int[] s = {0};


    private void actualizarTimeLabel() {
        String tiempo = (h[0]<=9?"0":"")+h[0]+":"+(m[0]<=9?"0":"")+m[0]+":"+(s[0]<=9?"0":"")+s[0];
        Long datatimeE = System.currentTimeMillis();
        Timestamp timeE = new Timestamp(datatimeE);

        for (int i = 0; i < 20; i++) {
            if (globales.EliminarTab[i]) {
                switch (i) {
                    case 0:
                        ElapsedTimeAMHS.setText("Elapsed Time: "+tiempo);
                        CurrentTSAMHS.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 1:
                        ElapsedTimeCT.setText("Elapsed Time: "+tiempo);
                        CurrentTSCT.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 2:
                        ElapsedTimeE.setText("Elapsed Time: "+tiempo);
                        CurrentTSE.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 3:
                        ElapsedTimeKCHR.setText("Elapsed Time: "+tiempo);
                        CurrentTSKCHR.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 4:
                        ElapsedTimeKCH.setText("Elapsed Time: "+tiempo);
                        CurrentTSKCH.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 5:
                        ElapsedTimeKCM.setText("Elapsed Time: "+tiempo);
                        CurrentTSKCM.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 6:
                        ElapsedTimeKCR.setText("Elapsed Time: "+tiempo);
                        CurrentTSKCR.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 7:
                        ElapsedTimeRL.setText("Elapsed Time: "+tiempo);
                        CurrentTSRL.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 8:
                        ElapsedTimeRTO.setText("Elapsed Time: "+tiempo);
                        CurrentTSRTO.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 9:
                        ElapsedTimeRTL.setText("Elapsed Time: "+tiempo);
                        CurrentTSRTL.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 10:
                        ElapsedTimeRU.setText("Elapsed Time: "+tiempo);
                        CurrentTSRU.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 11:
                        ElapsedTimeRCHR.setText("Elapsed Time: "+tiempo);
                        CurrentTSRCHR.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 12:
                        ElapsedTimeRCH.setText("Elapsed Time: "+tiempo);
                        CurrentTSRCH.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 13:
                        ElapsedTimeRCM.setText("Elapsed Time: "+tiempo);
                        CurrentTSRCM.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 14:
                        ElapsedTimeRCR.setText("Elapsed Time: "+tiempo);
                        CurrentTSRCR.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 15:
                        ElapsedTimeTDSU.setText("Elapsed Time: "+tiempo);
                        CurrentTSTDSU.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 16:
                        ElapsedTimeWL.setText("Elapsed Time: "+tiempo);
                        CurrentTSWL.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 17:
                        ElapsedTimeWTO.setText("Elapsed Time: "+tiempo);
                        CurrentTSWTO.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 18:
                        ElapsedTimeWTL.setText("Elapsed Time: "+tiempo);
                        CurrentTSWTL.setText("Current Time stamp: " + String.valueOf(timeE));
                    case 19:
                        ElapsedTimeWU.setText("Elapsed Time: "+tiempo);
                        CurrentTSWU.setText("Current Time stamp: " + String.valueOf(timeE));
                    default:

                }
            }
        }

    }

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

        /*Lo relacionado con las labels del tiempo*/
        Long datatime = System.currentTimeMillis();
        Timestamp timeS = new Timestamp(datatime);

        ActionListener acciones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s[0] += 2;
                if(s[0] == 60) {
                    s[0] = 0;
                    ++m[0];
                }
                if(m[0]==60) {
                    m[0] = 0;
                    ++h[0];
                }
                actualizarTimeLabel();
            }
        };
        Timer t = new Timer(2000, acciones);
        t.start();

        //Bucle que añade los atributos a los comboBox de los parametros seleccionados en el YAML
        for (int i = 0; i < 20; i++) {
            if (globales.EliminarTab[i]) {
                String [] attrNamesSeparats = globales.attrNames[i].split(",");

                switch (i) {
                    case 0:
                        comboBoxAMHS.removeAllItems();
                        InitialTSAMHS.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxAMHS.addItem(attr);
                        }
                    case 1:
                        comboBoxCT.removeAllItems();
                        InitialTSCT.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxCT.addItem(attr);
                        }
                    case 2:
                        comboBoxE.removeAllItems();
                        InitialTSE.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxE.addItem(attr);
                        }
                    case 3:
                        comboBoxKCHR.removeAllItems();
                        InitialTSKCHR.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCHR.addItem(attr);
                        }
                    case 4:
                        comboBoxKCH.removeAllItems();
                        InitialTSKCH.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCH.addItem(attr);
                        }
                    case 5:
                        comboBoxKCM.removeAllItems();
                        InitialTSKCM.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCM.addItem(attr);
                        }
                    case 6:
                        comboBoxKCR.removeAllItems();
                        InitialTSKCR.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxKCR.addItem(attr);
                        }
                    case 7:
                        comboBoxRL.removeAllItems();
                        InitialTSRL.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRL.addItem(attr);
                        }
                    case 8:
                        comboBoxRTO.removeAllItems();
                        InitialTSRTO.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRTO.addItem(attr);
                        }
                    case 9:
                        comboBoxRTL.removeAllItems();
                        InitialTSRTL.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRTL.addItem(attr);
                        }
                    case 10:
                        comboBoxRU.removeAllItems();
                        InitialTSRU.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRU.addItem(attr);
                        }
                    case 11:
                        comboBoxRCHR.removeAllItems();
                        InitialTSRCHR.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCHR.addItem(attr);
                        }
                    case 12:
                        comboBoxRCH.removeAllItems();
                        InitialTSRCH.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCH.addItem(attr);
                        }
                    case 13:
                        comboBoxRCM.removeAllItems();
                        InitialTSRCM.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCM.addItem(attr);
                        }
                    case 14:
                        comboBoxRCR.removeAllItems();
                        InitialTSRCR.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxRCR.addItem(attr);
                        }
                    case 15:
                        comboBoxTDSU.removeAllItems();
                        InitialTSTDSU.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxTDSU.addItem(attr);
                        }
                    case 16:
                        comboBoxWL.removeAllItems();
                        InitialTSWL.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxWL.addItem(attr);
                        }
                    case 17:
                        comboBoxWTO.removeAllItems();
                        InitialTSWTO.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxWTO.addItem(attr);
                        }
                    case 18:
                        comboBoxWTL.removeAllItems();
                        InitialTSWTL.setText("Initial Time Stamp: " + timeS);
                        for (String attr : attrNamesSeparats) {
                            comboBoxWTL.addItem(attr);
                        }
                    case 19:
                        comboBoxWU.removeAllItems();
                        InitialTSWU.setText("Initial Time Stamp: " + timeS);
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
                creada[0][Integer.parseInt(IndexAttr[gNum[0]])] = true;
                GraficaAMHS.removeAll();

                if(globales.ValAct[0][gNum[0]].contains("E")) {
                    String[] partes = globales.ValAct[0][gNum[0]].split("E");
                    jchart[0][gNum[0]] = ChartFactory.createLineChart("AllMemtablesHeapSize Parameter",
                            "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])]);
                }
                else {
                    jchart[0][gNum[0]] = ChartFactory.createLineChart("AllMemtablesHeapSize Parameter",
                            "Amount of Data","Attribute Value",
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
                creada[1][Integer.parseInt(IndexAttr[gNum[1]])] = true;
                GraficaCT.removeAll();

                if(globales.ValAct[1][gNum[1]].contains("E")) {
                    String[] partes = globales.ValAct[1][gNum[1]].split("E");
                    jchart[1][gNum[1]] = ChartFactory.createLineChart("CompetedTasks Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])]);
                }
                else {
                    jchart[1][gNum[1]] = ChartFactory.createLineChart("CompletedTasks Parameter", "Amount of Data","Attribute Value",
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
                creada[2][Integer.parseInt(IndexAttr[gNum[2]])] = true;
                GraficaE.removeAll();

                if(globales.ValAct[2][gNum[2]].contains("E")) {
                    String[] partes = globales.ValAct[2][gNum[2]].split("E");
                    jchart[2][gNum[2]] = ChartFactory.createLineChart("Exceptions Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])]);
                }
                else {
                    jchart[2][gNum[2]] = ChartFactory.createLineChart("Exceptions Parameter", "Amount of Data","Attribute Value",
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
                creada[3][Integer.parseInt(IndexAttr[gNum[3]])] = true;
                GraficaKCHR.removeAll();

                if(globales.ValAct[3][gNum[3]].contains("E")) {
                    String[] partes = globales.ValAct[3][gNum[3]].split("E");
                    jchart[3][gNum[3]] = ChartFactory.createLineChart("KeyCacheHitRate Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])]);
                }
                else {
                    jchart[3][gNum[3]] = ChartFactory.createLineChart("KeyCacheHitRate Parameter", "Amount of Data","Attribute Value",
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
                creada[4][Integer.parseInt(IndexAttr[gNum[4]])] = true;
                GraficaKCH.removeAll();

                if(globales.ValAct[4][gNum[4]].contains("E")) {
                    String[] partes = globales.ValAct[4][gNum[4]].split("E");
                    jchart[4][gNum[4]] = ChartFactory.createLineChart("KeyCacheHits Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])]);
                }
                else {
                    jchart[4][gNum[4]] = ChartFactory.createLineChart("KeyCacheHits Parameter", "Amount of Data","Attribute Value",
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
                creada[5][Integer.parseInt(IndexAttr[gNum[5]])] = true;
                GraficaKCM.removeAll();
                if(globales.ValAct[5][gNum[5]].contains("E")) {
                    String[] partes = globales.ValAct[5][gNum[5]].split("E");
                    jchart[5][gNum[5]] = ChartFactory.createLineChart("KeyCacheMisses Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])]);
                }
                else {
                    jchart[5][gNum[5]] = ChartFactory.createLineChart("KeyCacheMisses Parameter", "Amount of Data","Attribute Value",
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
                creada[6][Integer.parseInt(IndexAttr[gNum[6]])] = true;
                GraficaKCR.removeAll();

                if(globales.ValAct[6][gNum[6]].contains("E")) {
                    String[] partes = globales.ValAct[6][gNum[6]].split("E");
                    jchart[6][gNum[6]] = ChartFactory.createLineChart("KeyCacheRequests Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])]);
                }
                else {
                    jchart[6][gNum[6]] = ChartFactory.createLineChart("KeyCacheRequests Parameter", "Amount of Data","Attribute Value",
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
                creada[7][Integer.parseInt(IndexAttr[gNum[7]])] = true;
                GraficaRL.removeAll();

                if(globales.ValAct[7][gNum[7]].contains("E")) {
                    String[] partes = globales.ValAct[7][gNum[7]].split("E");
                    jchart[7][gNum[7]] = ChartFactory.createLineChart("ReadLatency Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])]);
                }
                else {
                    jchart[7][gNum[7]] = ChartFactory.createLineChart("ReadLatency Parameter", "Amount of Data","Attribute Value",
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
                creada[8][Integer.parseInt(IndexAttr[gNum[8]])] = true;
                GraficaRTO.removeAll();

                if(globales.ValAct[8][gNum[8]].contains("E")) {
                    String[] partes = globales.ValAct[8][gNum[8]].split("E");
                    jchart[8][gNum[8]] = ChartFactory.createLineChart("ReadTimeOuts Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[6][Integer.parseInt(IndexAttr[gNum[8]])]);
                }
                else {
                    jchart[8][gNum[8]] = ChartFactory.createLineChart("ReadTimeOuts Parameter", "Amount of Data","Attribute Value",
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
                creada[9][Integer.parseInt(IndexAttr[gNum[9]])] = true;
                GraficaRTL.removeAll();

                if(globales.ValAct[9][gNum[9]].contains("E")) {
                    String[] partes = globales.ValAct[9][gNum[9]].split("E");
                    jchart[9][gNum[9]] = ChartFactory.createLineChart("ReadTotalLatency Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])]);
                }
                else {
                    jchart[9][gNum[9]] = ChartFactory.createLineChart("ReadTotalLatency Parameter", "Amount of Data","Attribute Value",
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
                creada[10][Integer.parseInt(IndexAttr[gNum[10]])] = true;
                GraficaRU.removeAll();

                if(globales.ValAct[10][gNum[10]].contains("E")) {
                    String[] partes = globales.ValAct[10][gNum[10]].split("E");
                    jchart[10][gNum[10]] = ChartFactory.createLineChart("ReadUnavailables Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])]);
                }
                else {
                    jchart[10][gNum[10]] = ChartFactory.createLineChart("ReadUnavailables Parameter", "Amount of Data","Attribute Value",
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
                creada[11][Integer.parseInt(IndexAttr[gNum[11]])] = true;
                GraficaRCHR.removeAll();

                if(globales.ValAct[11][gNum[11]].contains("E")) {
                    String[] partes = globales.ValAct[11][gNum[11]].split("E");
                    jchart[11][gNum[11]] = ChartFactory.createLineChart("RowCacheHitRate Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])]);
                }
                else {
                    jchart[11][gNum[11]] = ChartFactory.createLineChart("RowCacheHitRate Parameter", "Amount of Data","Attribute Value",
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
                creada[12][Integer.parseInt(IndexAttr[gNum[12]])] = true;
                GraficaRCH.removeAll();

                if(globales.ValAct[12][gNum[12]].contains("E")) {
                    String[] partes = globales.ValAct[12][gNum[12]].split("E");
                    jchart[12][gNum[12]] = ChartFactory.createLineChart("RowCacheHits Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])]);
                }
                else {
                    jchart[12][gNum[12]] = ChartFactory.createLineChart("RowCacheHits Parameter", "Amount of Data","Attribute Value",
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
                creada[13][Integer.parseInt(IndexAttr[gNum[13]])] = true;
                GraficaRCM.removeAll();

                if(globales.ValAct[13][gNum[13]].contains("E")) {
                    String[] partes = globales.ValAct[13][gNum[13]].split("E");
                    jchart[13][gNum[13]] = ChartFactory.createLineChart("RowCacheMisses Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])]);
                }
                else {
                    jchart[13][gNum[13]] = ChartFactory.createLineChart("RowCacheMisses Parameter", "Amount of Data","Attribute Value",
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
                creada[14][Integer.parseInt(IndexAttr[gNum[14]])] = true;
                GraficaRCR.removeAll();

                if(globales.ValAct[14][gNum[14]].contains("E")) {
                    String[] partes = globales.ValAct[14][gNum[14]].split("E");
                    jchart[14][gNum[14]] = ChartFactory.createLineChart("RowCacheRequests Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])]);
                }
                else {
                    jchart[14][gNum[14]] = ChartFactory.createLineChart("RowCacheRequests Parameter", "Amount of Data","Attribute Value",
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
                creada[15][Integer.parseInt(IndexAttr[gNum[15]])] = true;
                GraficaTDSU.removeAll();

                if(globales.ValAct[15][gNum[15]].contains("E")) {
                    String[] partes = globales.ValAct[15][gNum[15]].split("E");
                    jchart[15][gNum[15]] = ChartFactory.createLineChart("TotalDiskSpaceUsed Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])]);
                }
                else {
                    jchart[15][gNum[15]] = ChartFactory.createLineChart("TotalDiskSpaceUsed Parameter", "Amount of Data","Attribute Value",
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
                creada[16][Integer.parseInt(IndexAttr[gNum[16]])] = true;
                GraficaWL.removeAll();

                if(globales.ValAct[16][gNum[16]].contains("E")) {
                    String[] partes = globales.ValAct[16][gNum[16]].split("E");
                    jchart[16][gNum[16]] = ChartFactory.createLineChart("WriteLatency Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])]);
                }
                else {
                    jchart[16][gNum[16]] = ChartFactory.createLineChart("WriteLatency Parameter", "Amount of Data","Attribute Value",
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
                creada[17][Integer.parseInt(IndexAttr[gNum[17]])] = true;
                GraficaWTO.removeAll();

                if(globales.ValAct[17][gNum[17]].contains("E")) {
                    String[] partes = globales.ValAct[17][gNum[17]].split("E");
                    jchart[17][gNum[17]] = ChartFactory.createLineChart("WriteTimeOuts Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])]);
                }
                else {
                    jchart[17][gNum[17]] = ChartFactory.createLineChart("WriteTimeOuts Parameter", "Amount of Data","Attribute Value",
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
                creada[18][Integer.parseInt(IndexAttr[gNum[18]])] = true;
                GraficaWTL.removeAll();

                if(globales.ValAct[18][gNum[18]].contains("E")) {
                    String[] partes = globales.ValAct[18][gNum[18]].split("E");
                    jchart[18][gNum[18]] = ChartFactory.createLineChart("WriteTotalLatency Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])]);
                }
                else {
                    jchart[18][gNum[18]] = ChartFactory.createLineChart("WriteTotalLatency Parameter", "Amount of Data","Attribute Value",
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
                creada[19][Integer.parseInt(IndexAttr[gNum[19]])] = true;
                GraficaWU.removeAll();

                if(globales.ValAct[19][gNum[19]].contains("E")) {
                    String[] partes = globales.ValAct[19][gNum[19]].split("E");
                    jchart[19][gNum[19]] = ChartFactory.createLineChart("WriteUnavailables Parameter", "Amount of Data", "Attribute Value (E" + partes[1] + ")",
                            globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])]);
                }
                else {
                    jchart[19][gNum[19]] = ChartFactory.createLineChart("WriteUnavailables Parameter", "Amount of Data","Attribute Value",
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("AllMemtablesHeapSize_"+ comboBoxAMHS.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("CompletedTasks_"+comboBoxCT.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("Exceptions_"+comboBoxE.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("KeyCacheHitRate_"+comboBoxKCHR.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("KeyChacheHits_"+comboBoxKCH.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("KeyCacheMisses_"+comboBoxKCM.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("KeyCacheRequests_"+comboBoxKCR.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("ReadLatency_"+comboBoxRL.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("ReadTimeOuts_"+comboBoxRTO.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("ReadUnavailables_"+comboBoxRTL.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("RowCacheHitRate_"+comboBoxRU.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("RowCacheHitRate_"+comboBoxRCHR.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("RowCacheHits_"+comboBoxRCH.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("RowCacheMisses_"+comboBoxRCM.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("RowCacheRequests_"+comboBoxRCR.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("TotalDiskSpaceUsed_"+comboBoxTDSU.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("WriteLatency_"+comboBoxWL.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("WriteTimeOuts_"+comboBoxWTO.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("WriteTotalLatency_"+comboBoxWTL.getSelectedItem() + "_Chart_" + timeE + ".png");
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
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                File f = new File("WriteUnavailables_"+comboBoxWU.getSelectedItem() + "_Chart_" + timeE + ".png");
                try {
                    ChartUtilities.saveChartAsPNG(f, jchart[19][gNum[19]], 400, 400, info);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //---------------------------------------------------------------------------------------------
        //-------------------------LISTENERS DE LOS BOTONES DE SAVE ALL CHARTS-------------------------
        //---------------------------------------------------------------------------------------------
        saveAllChartsButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);

            }
        });
        saveAllChartsButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        saveAllChartsButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveAllCharts(jchart);
            }
        });
        //---------------------------------------------------------------------------------------------
        //----------------------LISTENERS DE LOS BOTONES DE SAVE CURRENT DATA--------------------------
        //---------------------------------------------------------------------------------------------
        saveCurrentDataButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("AllMemtablesHeapSize_" + comboBoxAMHS.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[0].split(",");
                ps.println("Valores del atributo " + comboBoxAMHS.getSelectedItem());
                for(int i = 0; i < globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[0][Integer.parseInt(IndexAttr[gNum[0]])].getValue(0,i));
                }
            }
        });

        saveCurrentDataButtonCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("CompletedTasks_" + comboBoxCT.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[1].split(",");
                ps.println("Valores del atributo " + comboBoxCT.getSelectedItem());
                for(int i = 0; i < globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[1][Integer.parseInt(IndexAttr[gNum[1]])].getValue(0,i));
                }
            }
        });

        saveCurrentDataButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("Exceptions_" + comboBoxE.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[2].split(",");
                ps.println("Valores del atributo " + comboBoxE.getSelectedItem());
                for(int i = 0; i < globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[2][Integer.parseInt(IndexAttr[gNum[2]])].getValue(0,i));
                }
            }
        });

        saveCurrentDataButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("KeyCacheHitRate_" + comboBoxKCHR.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[3].split(",");
                ps.println("Valores del atributo " + comboBoxKCHR.getSelectedItem());
                for(int i = 0; i < globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[3][Integer.parseInt(IndexAttr[gNum[3]])].getValue(0,i));
                }

            }
        });

        saveCurrentDataButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("KeyCacheHits_" + comboBoxKCH.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[4].split(",");
                ps.println("Valores del atributo " + comboBoxKCH.getSelectedItem());
                for(int i = 0; i < globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[4][Integer.parseInt(IndexAttr[gNum[4]])].getValue(0,i));
                }

            }
        });

        saveCurrentDataButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("KeyCacheMisses_" + comboBoxKCM.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[5].split(",");
                ps.println("Valores del atributo " + comboBoxKCM.getSelectedItem());
                for(int i = 0; i < globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[5][Integer.parseInt(IndexAttr[gNum[5]])].getValue(0,i));
                }

            }
        });

        saveCurrentDataButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("KeyCacheRequests_" + comboBoxKCR.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[6].split(",");
                ps.println("Valores del atributo " + comboBoxKCR.getSelectedItem());
                for(int i = 0; i < globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[6][Integer.parseInt(IndexAttr[gNum[6]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("ReadLatency_" + comboBoxRL.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[7].split(",");
                ps.println("Valores del atributo " + comboBoxRL.getSelectedItem());
                for(int i = 0; i < globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[7][Integer.parseInt(IndexAttr[gNum[7]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("ReadTimeOuts_" + comboBoxRTO.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[8].split(",");
                ps.println("Valores del atributo " + comboBoxRTO.getSelectedItem());
                for(int i = 0; i < globales.dcd[8][Integer.parseInt(IndexAttr[gNum[8]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[8][Integer.parseInt(IndexAttr[gNum[8]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("ReadTotalLatency_" + comboBoxRTL.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[9].split(",");
                ps.println("Valores del atributo " + comboBoxRTL.getSelectedItem());
                for(int i = 0; i < globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[9][Integer.parseInt(IndexAttr[gNum[9]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("ReadUnavailables_" + comboBoxRU.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[10].split(",");
                ps.println("Valores del atributo " + comboBoxRU.getSelectedItem());
                for(int i = 0; i < globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[10][Integer.parseInt(IndexAttr[gNum[10]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("RowCacheHitRate_" + comboBoxRCHR.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[11].split(",");
                ps.println("Valores del atributo " + comboBoxRCHR.getSelectedItem());
                for(int i = 0; i < globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[11][Integer.parseInt(IndexAttr[gNum[11]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("RowCacheHits_" + comboBoxRCH.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[12].split(",");
                ps.println("Valores del atributo " + comboBoxRCH.getSelectedItem());
                for(int i = 0; i < globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[12][Integer.parseInt(IndexAttr[gNum[12]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("RowCacheMisses_" + comboBoxRCM.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[13].split(",");
                ps.println("Valores del atributo " + comboBoxRCM.getSelectedItem());
                for(int i = 0; i < globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[13][Integer.parseInt(IndexAttr[gNum[13]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("RowCacheRequests_" + comboBoxRCR.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[14].split(",");
                ps.println("Valores del atributo " + comboBoxRCR.getSelectedItem());
                for(int i = 0; i < globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[14][Integer.parseInt(IndexAttr[gNum[14]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("TotalDiskSpaceUsed_" + comboBoxTDSU.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[15].split(",");
                ps.println("Valores del atributo " + comboBoxTDSU.getSelectedItem());
                for(int i = 0; i < globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[15][Integer.parseInt(IndexAttr[gNum[15]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("WriteLatency_" + comboBoxWL.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[16].split(",");
                ps.println("Valores del atributo " + comboBoxWL.getSelectedItem());
                for(int i = 0; i < globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[16][Integer.parseInt(IndexAttr[gNum[16]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("WriteTimeOuts_" + comboBoxWTO.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[17].split(",");
                ps.println("Valores del atributo " + comboBoxWTO.getSelectedItem());
                for(int i = 0; i < globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[17][Integer.parseInt(IndexAttr[gNum[17]])].getValue(0,i));
                }
            }
        });
        saveCurrentDataButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("WriteTotalLatency_" + comboBoxWTL.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[18].split(",");
                ps.println("Valores del atributo " + comboBoxWTL.getSelectedItem());
                for(int i = 0; i < globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[18][Integer.parseInt(IndexAttr[gNum[18]])].getValue(0,i));
                }

            }
        });
        saveCurrentDataButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long datatimeE = System.currentTimeMillis();
                Timestamp timeE = new Timestamp(datatimeE);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream("WriteUnavailables_" + comboBoxWU.getSelectedItem() + "_Data_" + timeE + ".txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                PrintStream ps = new PrintStream(os);
                String[] IndexAttr = globales.attr[19].split(",");
                ps.println("Valores del atributo " + comboBoxWU.getSelectedItem());
                for(int i = 0; i < globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])].getColumnCount(); i++) {
                    ps.println(globales.dcd[19][Integer.parseInt(IndexAttr[gNum[19]])].getValue(0,i));
                }

            }
        });

        //---------------------------------------------------------------------------------------------
        //----------------------LISTENERS DE LOS BOTONES DE SAVE ALL DATA------------------------------
        //---------------------------------------------------------------------------------------------
        saveAllDataButtonAMHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonKCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonKCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonKCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonKCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRCHR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRCM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonRCR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonTDSU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonWL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonWTO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonWTL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
        saveAllDataButtonWU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAllData();
            }
        });
    }

    public void actualitzaLabel(String val, int i) {
        switch (i) {

            //AllMemtablesHeapSize
            case 1:
                ValorActualAMHS.setText("Current Value: "+val);
                break;

            //CompletedTasks
            case 2:
                ValorActualCT.setText("Current Value: "+val);
                break;

            //Exceptions
            case 3:
                ValorActualE.setText("Current Value: "+val);
                break;

            //KeyCacheHitRate
            case 4:
                ValorActualKCHR.setText("Current Value: "+val);
                break;

            //KeyCacheHits
            case 5:
                ValorActualKCH.setText("Current Value: "+val);
                break;

            //KeyCacheMisses
            case 6:
                ValorActualKCM.setText("Current Value: "+val);
                break;

            //KeyCacheRequests
            case 7:
                ValorActualKCR.setText("Current Value: "+val);
                break;

            //ReadLatency
            case 8:
                ValorActualRL.setText("Current Value: "+val);
                break;

            //ReadTimeOuts
            case 9:
                ValorActualRTO.setText("Current Value: "+val);
                break;

            //ReadTotalLatency
            case 10:
                ValorActualRTL.setText("Current Value: "+val);
                break;

            //ReadUnavailables
            case 11:
                ValorActualRU.setText("Current Value: "+val);
                break;

            //RowCacheHitRate
            case 12:
                ValorActualRCHR.setText("Current Value: "+val);
                break;

            //RowCacheHits
            case 13:
                ValorActualRCH.setText("Current Value: "+val);
                break;

            //RowCacheMisses
            case 14:
                ValorActualRCM.setText("Current Value: "+val);
                break;

            //RowCacheRequests
            case 15:
                ValorActualRCR.setText("Current Value: "+val);
                break;

            //TotalDiskSpaceUsed
            case 16:
                ValorActualTDSU.setText("Current Value: "+val);
                break;

            //WriteLatency
            case 17:
                ValorActualWL.setText("Current Value: "+val);
                break;

            //WriteTimeOuts
            case 18:
                ValorActualWTO.setText("Current Value: "+val);
                break;

            //WriteTotalLatency
            case 19:
                ValorActualWTL.setText("Current Value: "+val);
                break;

            //WriteUnavailables
            case 20:
                ValorActualWU.setText("Current Value: "+val);
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

    //FALTA FER QUE EL NOM DE L'ARXIU SIGUI PARAMETRE+ATRIBUT+TIMESTAMP
    public void SaveAllCharts( JFreeChart[][] jchart) {
        for (int i = 0; i < jchart.length; i++) {
            int k = 0;
            for (int j = 0; j < jchart[i].length; j++) {
                    if (creada[i][j]) {
                        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                        File f = new File("Grafica_"+i+"_"+j+".png" );
                        k++;
                        try {
                            ChartUtilities.saveChartAsPNG(f, jchart[i][j], 400, 400, info);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
            }
        }

    }

    //funció que crea un arxiu txt i hi guarda tots els valors numèrics dels atributs que s'han consultat almenys un cop al llarg de l'execució
    //(només es crida quan s'apreta el botó SaveAllData)
    //l'arxiu resultant consta de separadors amb els noms dels paràmetres i atributs que representen els valors numèrics
    //el nom de l'arxiu txt consta també d'un timestamp del moment en que s'ha creat
    public void saveAllData() {
        Long datatimeE = System.currentTimeMillis();
        Timestamp timeE = new Timestamp(datatimeE);
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("AllData_" + timeE + ".txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        PrintStream ps = new PrintStream(os);
        for (int i = 0;  i < globales.dcd.length; i++) {
            if (Arrays.stream(creada[i]).anyMatch(k -> k == true)) {
                switch (i) {
                    case 0:
                        ps.println("-------------Parameter AllMemtableHeapSize---------------");
                        break;
                    case 1:
                        ps.println("-------------Parameter CompletedTasks--------------------");
                        break;
                    case 2:
                        ps.println("-------------Parameter Exceptions------------------------");
                        break;
                    case 3:
                        ps.println("-------------Parameter KeyCacheHitRate-------------------");
                        break;
                    case 4:
                        ps.println("-------------Parameter KeyChacheHits---------------------");
                        break;
                    case 5:
                        ps.println("-------------Parameter KeyCacheMisses--------------------");
                        break;
                    case 6:
                        ps.println("-------------Parameter KeyCacherequests------------------");
                        break;
                    case 7:
                        ps.println("-------------Parameter ReadLatency-----------------------");
                        break;
                    case 8:
                        ps.println("-------------Parameter ReadTimeOuts----------------------");
                        break;
                    case 9:
                        ps.println("-------------Parameter ReadTotalLatency------------------");
                        break;
                    case 10:
                        ps.println("-------------Parameter ReadUnavailables------------------");
                        break;
                    case 11:
                        ps.println("-------------Parameter RowCacheHitRate-------------------");
                        break;
                    case 12:
                        ps.println("-------------Parameter RowCacheHits----------------------");
                        break;
                    case 13:
                        ps.println("-------------Parameter RowCacheMisses--------------------");
                        break;
                    case 14:
                        ps.println("-------------Parameter RowCacheRequests------------------");
                        break;
                    case 15:
                        ps.println("-------------Parameter TotalDiskSpaceUsed----------------");
                        break;
                    case 16:
                        ps.println("-------------Parameter WriteLatency----------------------");
                        break;
                    case 17:
                        ps.println("-------------Parameter WriteTimeOuts---------------------");
                        break;
                    case 18:
                        ps.println("-------------Parameter WriteTotalLatency-----------------");
                        break;
                    case 19:
                        ps.println("-------------Parameter WriteUnavailables-----------------");
                        break;
                    default:
                        break;
                }

            }
            for (int j = 0; j < globales.dcd[i].length; j++) {
                if (creada[i][j]) {
                    ps.println("********************" + globales.dcd[i][j].getRowKey(0) + "**********************");
                    for (int k = 0; k < globales.dcd[i][j].getColumnCount(); k++) {
                        ps.println(globales.dcd[i][j].getValue(0,k));
                    }
                }
            }
        }

    }
}
