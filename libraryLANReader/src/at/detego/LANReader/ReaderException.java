package at.detego.LANReader;

@SuppressWarnings("serial")
public class ReaderException extends Exception
{
  private String msg;

  public ReaderException()
  {
    this.msg = "Error!!";
  }

  public ReaderException( String msg )
  {
    this.msg = "Error: " + msg;
  }

//  public String getErrorMsg()
  public String toString()
  {
    return msg;
  }
}
