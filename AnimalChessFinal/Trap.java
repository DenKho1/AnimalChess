/**
 * This class represents the trap tiles of the board used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Trap extends Tile
{


  /**The construtor that assigns the x and y position, the color, and the player assigned to the Trap
  @param c the color of the trap
  @param x the horizontal position of the trap
  @param y the vertical position of the trap
  @param p the player assigned to the trap
  */
  public Trap(String c, int x, int y, int p)
  {
    super(x,y);

    COLOR=c;
    PLAYER=p;
  }

  /**This method returns the color of the Trap
  @return the color of the Trap
  */
  public String getColor()
  {
    return COLOR;
  }
  /**This method returns the Player of the Trap
  @return the player assigned to the Trap
  */
  public int getPlayer()
  {
  return PLAYER;
  }

  private final String COLOR;/**Color String assigned to the Trap*/
  private final int PLAYER; /**Player number assigned to the Trap */

}