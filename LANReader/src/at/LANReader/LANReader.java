package at.LANReader;

import java.io.IOException;

import java.util.Vector;

import at.detego.LANReader.Request;
import at.detego.LANReader.ReaderException;

public class LANReader
{
  private Request request;

  public LANReader()
  {
    request = new Request();
  }
  
  public String onConnect()
  {
    String ret;

    try
    {
      ret = "connected";
      request.connect("192.168.1.234");
    } catch (ReaderException e)
    {
      ret = e.toString();
      e.printStackTrace();
    } catch (IOException e)
    {
      ret = "Net-IO-Error!!";
      e.printStackTrace();
    }

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

  public void onDisconnect()
  {
    try
    {
      request.disconnect();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }


  public String testFunctions(Integer choosen)
  {
    // Karten UID: 1: E0054000001F694D  2: E0054000001FA14D  3: E0054000001F6520
    // NFC-Tag UID:   04BD3E2ABD2B80

    String message;

    try
    {
      switch( choosen.intValue() )
      {
      case 0:
        message = "Nothing to test on Null";
        break;
      case 1:
        message = request.getVersion();
        break;
      default:
        message = "Case not Implemented!!";
      }
    } catch (IOException e)
    {
      message = "IO-Error!!";
      e.printStackTrace();
    }

//    System.out.println(request.getVersion());
//    System.out.println(request.getConfigName());

//    System.out.println(request.isoInventory());
//    System.out.println(request.isoSelect("E0054000001F694D"));
//    System.out.println(request.isoRead());

//    System.out.println(request.mifareIdentify());
//    System.out.println(request.mifareRead());


    return message;
  }
}




