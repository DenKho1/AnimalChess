/**
 * This class represents the Mouse animal piece used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Mouse extends AnimalPiece
{
  /** This constructor initializes the name, color,rank, x position and y position of the Mouse based on the   given parameters.    
  @param c color of the Mouse     
  @param x initial x position 
  @param y initial y position 
  */
  public Mouse(int x, int y,String c)
  {
    super("Mouse",c,1,x,y);
  }
}