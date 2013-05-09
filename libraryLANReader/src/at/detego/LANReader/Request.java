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


  private static final String REQUEST_STR = "request=";
  private static final String GET_VERSION = "version";


  public void connect(String ipaddress, int port) throws Exception
  {
    clientsocket = new Socket(ipaddress, port);
    output = new DataOutputStream( clientsocket.getOutputStream() );
    input  = new BufferedReader( new InputStreamReader(clientsocket.getInputStream()) );
  }

  public void disconnect() throws IOException
  {
    clientsocket.close();
  }

  public String getVersion() throws IOException
  {
    String version;
    output.writeUTF( REQUEST_STR + GET_VERSION );
    version = input.readLine();
    return version;
  }

}
