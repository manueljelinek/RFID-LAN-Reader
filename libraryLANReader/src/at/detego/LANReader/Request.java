package at.detego.LANReader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import at.detego.LANReader.ReaderException;

public class Request
{
  private boolean connected = false;
  private Socket clientsocket;
  private BufferedReader input;
  private DataOutputStream output;


  private static final String CR_LF = "\r\n";
  private static final String TAG_UID      = "uid=";
  private static final String REQUEST_STR  = "request=";
  private static final String REQUEST_NAME = "name=";
  private static final String GET_VERSION  = "version;";

  // -------------------- Parameters for Config --------------------
  private static final String GET_CONFIG     = "config.get;";
  private static final String RESTORE_CONFIG = "config.restore;";

  private static final String CONFIG_NAME = "name;";
  // ---------------------------------------------------------------

  // ------------------- Parameters for ISO TAGs -------------------
  private static final String ISO_INVENTORY = "iso.inventory;";
  private static final String ISO_SELECT    = "iso.select;";
  private static final String ISO_READ      = "iso.read;";

  private static final String ISO_COUNT = "count=";
  // ---------------------------------------------------------------

  // ------------------- Parameters for ISO TAGs -------------------
  private static final String MIFARE_IDENTIFY = "mifare.identify;";
  private static final String MIFARE_READ     = "mifare.read;";

  // ---------------------------------------------------------------
  private static final String ADDRESS = "address=";


  public void connect( String ipaddress, int... port ) throws IOException, ReaderException
  {
    if( connected )
      return;

    if( port.length > 1 )
      throw new ReaderException("Too many parameters!!");

    if( port.length == 0)
    {
      port = new int[1];
      port[0] = 7348;       // 7348 is standard port of reader
    }

    clientsocket = new Socket(ipaddress, port[0]);
    connected = true;
    System.out.println( "Connection Established!!" );
    output = new DataOutputStream( clientsocket.getOutputStream() );
    input  = new BufferedReader( new InputStreamReader(clientsocket.getInputStream()) );
    System.out.println(input.readLine());
  }

  public void disconnect() throws IOException
  {
    if( !connected )
      return;

    clientsocket.close();
    connected = false;
    System.out.println( "Connection Terminated!!" );
  }

  public String getVersion() throws IOException
  {
    String version;
    output.writeBytes( REQUEST_STR + GET_VERSION + CR_LF );
    version = input.readLine();
    return version;
  }


  // ------------------- (begin) Config Methods -------------------
  public String getConfigName() throws IOException
  {
    String name;
    output.writeBytes( REQUEST_STR + GET_CONFIG + REQUEST_NAME + CONFIG_NAME + CR_LF );
    name = input.readLine();
    return name;
  }

  public String restoreConfig() throws IOException
  {
    String version;
    output.writeBytes( REQUEST_STR + RESTORE_CONFIG + CR_LF );
    version = input.readLine();
    return version;
  }
  // -------------------- (end) Config Methods --------------------


  // ------------------- (begin) ISO Methods -------------------
  public String isoInventory() throws IOException
  {
    String taglist;
    output.writeBytes( REQUEST_STR + ISO_INVENTORY + CR_LF );
    taglist = input.readLine();
    return taglist;
  }

  public String isoSelect(String tag_uid) throws IOException
  {
    String error;
    output.writeBytes( REQUEST_STR + ISO_SELECT + TAG_UID + tag_uid + ";" + CR_LF );
    error = input.readLine();
    return error;
  }

  public String isoRead() throws IOException
  {
    String error;
    output.writeBytes( REQUEST_STR + ISO_READ + ADDRESS + "0;" + ISO_COUNT + "8;" + CR_LF );
    error = input.readLine();
    return error;
  }
  // -------------------- (end) ISO Methods --------------------


  // ----------------- (begin) MIFARE Methods ------------------
  public String mifareIdentify() throws IOException
  {
    String taglist;
    output.writeBytes( REQUEST_STR + MIFARE_IDENTIFY + CR_LF );
    taglist = input.readLine();
    return taglist;
  }
  
  public String mifareStoreKey() throws IOException
  {
	String ret;
//	output.writeBytes( "request=mifare.storekey;id=1;key=a0a1a2a3a4a5;" + CR_LF );
	output.writeBytes( "request=mifare.storekey;id=1;key=ffffffffffff;" + CR_LF );
	ret = input.readLine();
	return ret;
  }

  public String mifareLogin() throws IOException
  {
	String ret;
	output.writeBytes( "request=mifare.login;keyid=1;uid=3CA18EE8;block=5;keytype=A;" + CR_LF );
	ret = input.readLine();
	return ret;
  }

  public String mifareRead(int block) throws IOException
  {
    String taglist;
    output.writeBytes( REQUEST_STR + MIFARE_READ + ADDRESS + block + ";" + CR_LF );
    taglist = input.readLine();
    return taglist;
  }
  // ------------------- (end) MIFARE Methods ------------------
}

//----------------------TIMER CODE---------------------------
//-----------------------Für Oberfläche-----------------------
//javax.swing.Timer t = new javax.swing.Timer( 1000, new ActionListener() {
//  public void actionPerformed( ActionEvent e ) {
//    Calendar calender = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        sdf.applyPattern( "EEEE', 'dd. MMMM yyyy");
//        /* EEEE steht für Tag der Woche lang*/
//        /* E steht für Tag der Woche kurz z.B.: Mi */
//        SimpleDateFormat sdfzeit = new SimpleDateFormat();
//        sdfzeit.applyPattern( "HH:mm:ss" );
//        label.this.setTitle(sdf.format(calender.getTime()) + "        " +   
//                                 sdfzeit.format(calender.getTime()));
//        }
//  }
//); 
//t.start();




