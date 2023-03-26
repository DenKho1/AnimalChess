/**
 * This class represents the tiles of the board used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Tile
{
  /**This constructor initializes the x and y position and assign no Animal Piece to it with the following parameters
  @param x the horizontal position of the Tile
  @param y the vertical position of the Tile
  */
  public Tile(int x, int y)
  {
    XPOS=x;
    YPOS=y;
    has=null;
  }
  /**This constructor initializes the x and y position and assign the Animal Piece to it with the following parameters
  @param x the horizontal position of the Tile
  @param y the vertical position of the Tile
  @param a the Animal Piece on the Tile
  */
  public Tile(int x, int y, AnimalPiece a)
  {
    XPOS=x;
    YPOS=y;
    has=a;
  }


  /**This method attaches a new animal Piece to the tile with the following parameters
  @param a the Animal Piece on the Tile
  */
  public void updatePiece(AnimalPiece a)
  {
    has=a;
  }

  /**This method returns the Animal Piece currently on the tile
  @return the Piece residing in the Tile
  */
  public AnimalPiece contentCheck()
  {
    return has;
  }

  /**This method returns the assigned x position of the tile
  @return the horizontal position of the Tile
  */
  public int getX()
  {
    return XPOS;
  }

  /**This method returns the assign y position of the tile
  @return the vertical position of the Tile
  */
 public int getY()
  {
    return YPOS;
  }

  public final int XPOS;/**The final integer that is the tile's x position*/
  public final int YPOS;/**The final integer that is the tile's y position*/
  public AnimalPiece has;/**The Animal Piece currently residing on the tile*/
}