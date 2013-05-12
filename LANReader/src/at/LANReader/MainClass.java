package at.LANReader;

import java.awt.EventQueue;

import at.LANReader.gui.GUI_martin;
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
        GUI_martin window = new GUI_martin();
//        gui window = new gui();
        window.frame.setVisible(true);
      }
    });
  }
}
