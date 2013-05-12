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

public class GUI_martin
{
  public JFrame frame;
  private LANReader lanreader;
  private JTextField txtConnect;
  private JTextField txtselected;

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
  private void initialize()
  {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JTabbedPane Tab1 = new JTabbedPane(JTabbedPane.TOP);
    Tab1.setBounds(0, 0, 448, 275);
    frame.getContentPane().add(Tab1);
    
    JPanel PanelConnection = new JPanel();
    Tab1.addTab("Connection", null, PanelConnection, null);
    PanelConnection.setLayout(null);
    
    JButton btnDisconnect = new JButton("Disconnect");
    btnDisconnect.setBounds(195, 194, 112, 25);
    PanelConnection.add(btnDisconnect);
    
    JButton btnConnect = new JButton("Connect");
    btnConnect.setBounds(319, 194, 92, 25);
    PanelConnection.add(btnConnect);
    
    txtConnect = new JTextField();
    txtConnect.setBounds(12, 12, 114, 19);
    PanelConnection.add(txtConnect);
    txtConnect.setColumns(10);
    
    JPanel PannelRead = new JPanel();
    Tab1.addTab("Read", null, PannelRead, null);
    PannelRead.setLayout(null);
    
    final JList listRead = new JList();
    listRead.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        txtselected.setText((String) listRead.getSelectedValue());
      }
    });
    listRead.setBounds(12, 12, 200, 224);
    PannelRead.add(listRead);
    
    JButton btnRead = new JButton("Read");
    btnRead.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Vector<String> ret_string = new Vector<String>();
        ret_string = lanreader.onRead();
        listRead.setListData(ret_string);
      }
    });
    btnRead.setBounds(314, 211, 117, 25);
    PannelRead.add(btnRead);
    
    txtselected = new JTextField();
    txtselected.setBounds(317, 11, 114, 19);
    PannelRead.add(txtselected);
    txtselected.setColumns(10);

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

    btnDisconnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String ret_string;
        ret_string = lanreader.onDisconnect();
        txtConnect.setText(ret_string);
      }
    });  
  }
}
