/**
 * This class represents the Den tiles of the board used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Den extends Tile
{

 /** 
  This constructor initializes the color, x position, y position and player number of the Den based on the given parameters.    
  @param c color of Player
  @param x x position
  @param y y position
  @param p player number 
  */
 public Den(String c, int x, int y, int p)
  {
    super(x,y);
    COLOR = c;
    PLAYER = p;
  }
  
  /**This method returns the assigned color of the Den
  @return the String the describes the color of the Den
  */
 public String getColor()
  {
  return COLOR;
}
/**This method returns the assigned player of the Den
@return the number of the player who owns the Den
  */
public int getPlayer()
{
  return PLAYER;
}

 //instance variables
 private final String COLOR;/**This attribute is a color of the den which will allow the player to later know if the piece can move there or not*/
 private final int PLAYER; /**This attribute is the player that is associated to the den*/
}