package at.LANReader;

import java.awt.EventQueue;

import at.LANReader.gui.gui;

public class MainClass
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("This is the Testprogram for RFID-LAN-Reader!");

    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        gui window = new gui();
        window.frame.setVisible(true);
      }
    });
  }
}
