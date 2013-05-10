package at.LANReader;

import at.detego.LANReader.*;

public class LANReader
{

  /**
   * @param args
   * @throws Exception 
   */
  public static void main(String[] args) throws Exception
  {
    // TODO Auto-generated method stub
    Request request = new Request();
    System.out.println("This is the Testprogram for RFID-LAN-Reader!");

    request.connect("192.168.1.234");

    // Karten: 1: E0054000001F694D  2: E0054000001FA14D  3: E0054000001F6520

//    System.out.println(request.getVersion());
//    System.out.println(request.getConfigName());
//    System.out.println(request.isoInventory());
//    System.out.println(request.isoSelect("E0054000001F694D"));
    System.out.println(request.isoRead());

    request.disconnect();
  }

}
