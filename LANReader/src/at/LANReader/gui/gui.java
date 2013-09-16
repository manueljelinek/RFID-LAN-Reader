package at.LANReader.gui;

import at.LANReader.LANReader;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;

public class gui
{
  public JFrame frame;
  private LANReader lanreader;

  /**
   * Create the application.
   */
  public gui()
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
    frame.setBounds(100, 100, 700, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnConnect = new JButton("Connect");
    btnConnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        lanreader.onConnect();
      }
    });
    btnConnect.setBounds(567, 437, 117, 25);
    frame.getContentPane().add(btnConnect);
    
    JButton btnDisconnect = new JButton("Disconnect");
    btnDisconnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        lanreader.onDisconnect();
      }
    });
    btnDisconnect.setBounds(444, 437, 117, 25);
    frame.getContentPane().add(btnDisconnect);
    
    
    final JSpinner spinner = new JSpinner();
    spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
    spinner.setBounds(12, 405, 62, 20);
    frame.getContentPane().add(spinner);
    
    final JList list = new JList();
    list.setBounds(12, 12, 672, 381);
    frame.getContentPane().add(list);

    JButton btnTests = new JButton("tests");
    btnTests.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Integer choosen = (Integer)spinner.getValue();
        Vector<String> output;
        output = lanreader.testFunctions(choosen);
        list.setListData(output);
//        lblOutputstrings.setText(output);
      }
    });
    btnTests.setBounds(12, 437, 117, 25);
    frame.getContentPane().add(btnTests);
  }
}
