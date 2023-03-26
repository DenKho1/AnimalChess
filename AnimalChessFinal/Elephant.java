/**
 * This class represents the Elephant animal piece used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Elephant extends AnimalPiece
{
  /** 
  This constructor initializes the color, x position and y position of the Elephant based on the given parameters. 
  @param x the x position of the Elephant
  @param y the y position of the Elephant
  @param c the color of the Elephant
  */
  public Elephant(int x, int y, String c) 
  {
    super("Elephant",c,8,x,y);
  }
}