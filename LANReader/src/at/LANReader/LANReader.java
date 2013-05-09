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
    System.out.println("Hallo Welt!");

    request.connect("192.168.1.234", 7348);

    System.out.println(request.getVersion());

    request.disconnect();
  }

}
