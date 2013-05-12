package at.LANReader.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import at.LANReader.LANReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnConnect = new JButton("Connect");
    btnConnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
      }
    });
    btnConnect.setBounds(317, 237, 117, 25);
    frame.getContentPane().add(btnConnect);
  }

}
