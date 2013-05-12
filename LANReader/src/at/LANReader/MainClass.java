package at.LANReader;

import java.awt.EventQueue;

import at.LANReader.gui.GUI_martin;
//import at.detego.LANReader.Request;

public class MainClass
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
          GUI_martin window = new GUI_martin();
          window.frame.setVisible(true);
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
}
