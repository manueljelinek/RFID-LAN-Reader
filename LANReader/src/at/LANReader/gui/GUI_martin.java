package at.LANReader.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import at.LANReader.LANReader;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUI_martin
{
  public JFrame frame;
  private LANReader lanreader;
  private JTextField txtConnect;
  private JTextField txtselected;
  private JTable table;
  private Object[][] data;
  /**
   * Create the application.
   */
  public GUI_martin()
  {
    lanreader = new LANReader();
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  @SuppressWarnings("serial")
  private void initialize()
  {
    

    
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));
    
    JTabbedPane Tab1 = new JTabbedPane(JTabbedPane.TOP);
    frame.getContentPane().add(Tab1);
    
    JPanel PanelConnection = new JPanel();
    Tab1.addTab("Connection", null, PanelConnection, null);
    PanelConnection.setLayout(new BorderLayout(0, 0));
    
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(10, 25, 10, 25));
    PanelConnection.add(panel, BorderLayout.SOUTH);
    GridBagLayout gbl_panel = new GridBagLayout();
    gbl_panel.columnWidths = new int[] {127, 127, 127};
    gbl_panel.rowHeights = new int[]{25, 0};
    gbl_panel.columnWeights = new double[]{0.5, 0.25, 0.25};
    gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
    panel.setLayout(gbl_panel);
    
    JPanel panel_1 = new JPanel();
    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
    gbc_panel_1.fill = GridBagConstraints.BOTH;
    gbc_panel_1.insets = new Insets(0, 0, 0, 5);
    gbc_panel_1.gridx = 0;
    gbc_panel_1.gridy = 0;
    panel.add(panel_1, gbc_panel_1);
    
    JButton btnConnect = new JButton("Connect");
    GridBagConstraints gbc_btnConnect = new GridBagConstraints();
    gbc_btnConnect.fill = GridBagConstraints.BOTH;
    gbc_btnConnect.insets = new Insets(0, 0, 0, 5);
    gbc_btnConnect.gridx = 1;
    gbc_btnConnect.gridy = 0;
    panel.add(btnConnect, gbc_btnConnect);
    
        btnConnect.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            String ret_string;
            try
            {
              ret_string = lanreader.onConnect();
              
            } catch (Exception e1)
            {
              ret_string = "Error occured!!";
              e1.printStackTrace();
            }
            txtConnect.setText(ret_string);
          }
        });
    
    JButton btnDisconnect = new JButton("Disconnect");
    GridBagConstraints gbc_btnDisconnect = new GridBagConstraints();
    gbc_btnDisconnect.fill = GridBagConstraints.BOTH;
    gbc_btnDisconnect.gridx = 2;
    gbc_btnDisconnect.gridy = 0;
    panel.add(btnDisconnect, gbc_btnDisconnect);
    
    JPanel panel_2 = new JPanel();
    PanelConnection.add(panel_2, BorderLayout.WEST);
    
    txtConnect = new JTextField();
    panel_2.add(txtConnect);
    txtConnect.setColumns(10);
    
        btnDisconnect.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String ret_string;
            ret_string = lanreader.onDisconnect();
            txtConnect.setText(ret_string);
          }
        });  
    
    JPanel PannelRead = new JPanel();
    Tab1.addTab("Read", null, PannelRead, null);
    PannelRead.setLayout(new BorderLayout(0, 0));
    
    JPanel panel_3 = new JPanel();
    panel_3.setBorder(new EmptyBorder(10, 25, 10, 25));
    PannelRead.add(panel_3, BorderLayout.SOUTH);
    GridBagLayout gbl_panel_3 = new GridBagLayout();
    gbl_panel_3.columnWidths = new int[] {127, 127, 127};
    gbl_panel_3.rowHeights = new int[]{25, 0};
    gbl_panel_3.columnWeights = new double[]{0.25,0.50, 0.25};
    gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
    panel_3.setLayout(gbl_panel_3);
    
    txtselected = new JTextField();
    GridBagConstraints gbc_txtselected = new GridBagConstraints();
    gbc_txtselected.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtselected.insets = new Insets(0, 0, 0, 5);
    gbc_txtselected.gridx = 0;
    gbc_txtselected.gridy = 0;
    panel_3.add(txtselected, gbc_txtselected);
    txtselected.setColumns(10);
    
    JPanel panel_6 = new JPanel();
    GridBagConstraints gbc_panel_6 = new GridBagConstraints();
    gbc_panel_6.insets = new Insets(0, 0, 0, 5);
    gbc_panel_6.fill = GridBagConstraints.BOTH;
    gbc_panel_6.gridx = 1;
    gbc_panel_6.gridy = 0;
    panel_3.add(panel_6, gbc_panel_6);
    
    JButton btnRead = new JButton("Read");
    GridBagConstraints gbc_btnRead = new GridBagConstraints();
    gbc_btnRead.insets = new Insets(0, 0, 0, 5);
    gbc_btnRead.fill = GridBagConstraints.HORIZONTAL;
    gbc_btnRead.anchor = GridBagConstraints.NORTH;
    gbc_btnRead.gridx = 2;
    gbc_btnRead.gridy = 0;
    panel_3.add(btnRead, gbc_btnRead);
    
    JPanel panel_4 = new JPanel();
    panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
    PannelRead.add(panel_4, BorderLayout.CENTER);
    panel_4.setLayout(new GridLayout(0, 1, 0, 0));
    
    JScrollPane scrollPane = new JScrollPane();
    panel_4.add(scrollPane);
    
    table = new JTable();
    table.setCellSelectionEnabled(true);
    
    table.setModel(new DefaultTableModel(
      data = new Object[][] {
        {null, null, null},
      },
      new String[] {
        "UID", "TimeStamp", "Test"
      }
    ) {
      @SuppressWarnings("rawtypes")
      Class[] columnTypes = new Class[] {
        Integer.class, String.class, Boolean.class
      };
      @SuppressWarnings({ "unchecked", "rawtypes" })
      public Class getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
      }
    });
    scrollPane.setViewportView(table);
    
    JPanel panel_7 = new JPanel();
    Tab1.addTab("New tab", null, panel_7, null);
    
    final JList<String> listRead = new JList<String>();
    //final JList listRead = new JList();
    panel_7.add(listRead);
    listRead.setVisibleRowCount(-1);
    listRead.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        txtselected.setText((String) listRead.getSelectedValue());
      }
    });
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Vector<String> ret_string = new Vector<String>();
        //ret_string = lanreader.onRead();
        ret_string.addElement("1 zeile");
        ret_string.addElement("2 zeile");
        ret_string.addElement("3 zeile");
        ret_string.addElement("4 zeile");
        ret_string.addElement("5 zeile");
        ret_string.addElement("6 zeile");
        ret_string.addElement("7 zeile");
        ret_string.addElement("8 zeile");
        ret_string.addElement("9 zeile");
        ret_string.addElement("10 zeile");
        ret_string.addElement("12 zeile");
        ret_string.addElement("13 zeile");
        ret_string.addElement("14 zeile");
        ret_string.addElement("15 zeile");
        ret_string.addElement("16 zeile");
        ret_string.addElement("17 zeile");
        ret_string.addElement("18 zeile");
        ret_string.addElement("19 zeile");
        listRead.setListData(ret_string);
        data[0][0] = 20; 
        
        //table.add((80,"hallo",true);, 2)
        }
    });
  }
}
