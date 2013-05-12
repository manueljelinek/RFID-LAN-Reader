package at.LANReader;

import java.awt.EventQueue;

import at.LANReader.gui.gui;
//import at.detego.LANReader.Request;

public class main
{

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception
  {
    System.out.println("This is the Testprogram for RFID-LAN-Reader!");

    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          gui window = new gui();
          window.frame.setVisible(true);
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
}
