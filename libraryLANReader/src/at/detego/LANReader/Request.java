package at.detego.LANReader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Request
{
  private Socket clientsocket;
  private BufferedReader input;
  private DataOutputStream output;


  private static final String CR_LF = "\r\n";
  private static final String TAG_UID     = "uid=";
  private static final String REQUEST_STR = "request=";
  private static final String GET_VERSION = "version;";

  // -------------------- Parameters for Config --------------------
  private static final String GET_CONFIG     = "config.get;";
  private static final String RESTORE_CONFIG = "config.restore;";

  private static final String CONFIG_NAME = "name;";
  // ---------------------------------------------------------------

  // ------------------- Parameters for ISO TAGs -------------------
  private static final String ISO_INVENTORY = "iso.inventory;";
  private static final String ISO_SELECT    = "iso.select;";
  private static final String ISO_READ      = "iso.read;";

  private static final String ISO_ADDRESS = "address=";
  private static final String ISO_COUNT   = "count=";
  // ---------------------------------------------------------------


  public void connect( String ipaddress, int... port ) throws Exception
  {
    if( port.length > 1 )
      throw new Exception("Too much parameters!");

    if( port.length == 0)
    {
      port = new int[1];
      port[0] = 7348;       // 7348 is standard port of reader
    }

    clientsocket = new Socket(ipaddress, port[0]);
    System.out.println( "Connection Established!!" );
    output = new DataOutputStream( clientsocket.getOutputStream() );
    input  = new BufferedReader( new InputStreamReader(clientsocket.getInputStream()) );
    System.out.println(input.readLine());
  }

  public void disconnect() throws IOException
  {
    clientsocket.close();
    System.out.println( "Connection Terminated!!" );
  }

  public String getVersion() throws IOException, InterruptedException
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
    output.writeBytes( REQUEST_STR + GET_CONFIG + CONFIG_NAME + CR_LF );
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
    output.writeBytes( REQUEST_STR + ISO_READ + ISO_ADDRESS + "0;" + ISO_COUNT + "8;" + CR_LF );
    error = input.readLine();
    return error;
  }
  // -------------------- (end) ISO Methods --------------------


}
