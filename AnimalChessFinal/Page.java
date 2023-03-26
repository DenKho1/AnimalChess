/**
 * This class represents the Pages of a Manual
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Page
{
  //instance variables
    private String content;
    private int pageno;

  /**This constructor initializes the pageno variable*/
    public Page (int pageno)
    {
        this.pageno = pageno;
    }
    /**This method returns the content String
  @return content*/
    public String getContent ()
    {
        return content;
    }
    /**This method returns pageno
  @return pageno*/
    public int getPageNo ()
    {
        return pageno;
    }
    /**This method sets the content String to the given parameter
  @param content to be set*/
    public void setContent (String content)
    {
        this.content = content;
    }
    
    @Override
  /**This method returns a String that describes the page number and its content
  @return content at page number*/
    public String toString ()
    {
        return pageno + " : " + content;
    }
}
