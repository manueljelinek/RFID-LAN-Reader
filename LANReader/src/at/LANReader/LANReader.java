package at.LANReader;

import java.io.IOException;
import java.util.Vector;

import at.detego.LANReader.*;

public class LANReader
{
  private Request request;

  public LANReader()
  {
    request = new Request();
  }
  
  public String onConnect() throws Exception
  {
    String ret = "connected";
    request.connect("192.168.1.234");
    return ret; 
  }

  public String onDisconnect() throws IOException
  {
    String ret = "disconnected";
    request.disconnect();
    return ret; 
  }

  public Vector<String> onRead() throws IOException
  {
    Vector<String> ret_vec = new Vector<String>();
    String ret =request.isoInventory();
    String word = "taglist=";
    int start_index = ret.lastIndexOf(word)+word.length()-1;
    for (int i = start_index; (i = ret.indexOf(",", i + 1)) != -1; ) {
      ret_vec.addElement(ret.substring(start_index+1, i));
      start_index = i;
  }
    ret_vec.addElement(ret.substring(start_index+1, ret.length()));
    return ret_vec;
  }

//    request.connect("192.168.1.234");

    // Karten UID: 1: E0054000001F694D  2: E0054000001FA14D  3: E0054000001F6520
    // NFC-Tag UID:   04BD3E2ABD2B80

//    System.out.println(request.getVersion());
//    System.out.println(request.getConfigName());

//    System.out.println(request.isoInventory());
//    System.out.println(request.isoSelect("E0054000001F694D"));
//    System.out.println(request.isoRead());

//    System.out.println(request.mifareIdentify());
//    System.out.println(request.mifareRead());


//    request.disconnect();

}




