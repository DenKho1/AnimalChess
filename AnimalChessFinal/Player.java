/**
 * This class represents the Player
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Player
{

  /** 
  This constructor initializes the color and number of the Player based on the given parameters.    
  @param c color of Player
  @param i number of player 
  */
  public Player(String c, int i)
  {
    color = c; number = i;
  }
  /**
     * This method gets an AnimalPiece from a specified bag
     *
     * @param  i  int, this specifies the pocket the player chose
     * @param  b  Bag, this is the bag that the player is choosing from
     * @return    the AnimalPiece the player chose
     */
  public AnimalPiece Pick(int i, Bag b)
  {
    return b.getPiece(i);
  }
  /**
     * This method moves the players animalPiece
     * @param b  Board, this specifies the board the player is moving on
     * @param  a  AnimalPiece, this specifies the animal the player chose
     * @param  d  char, this is the direction the player wants to go
     * @return    void
     */
  public void MovePiece(Board b, int a, char d)
  {
    b.updateBoard(number,a,d);
  }
  /**
     * This method returns the color attribute of the player
     *
     * @return   the color of the player
     */
  public String getColor()
  {
    return color;
  }
  /**
     * This method returns the number attribute of the player
     *
     * @return   the number of the player
     */
  public int getNumber()
  {
    return number;
  }
  /**
     * This method updates the color attribute of the player
     * 
     * @param  c String, a color 
     * @return   void
     */
  public void setColor(String c)
  {
    color = c;
  }
  /**
     * This method updates the number attribute of the player
     * 
     * @param  i int, a number
     * @return   void
     */
  public void setNumber(int i)
  {
    number = i;
  }

  private String color; /** the color of the player*/
  private int number;  /** the number of the player*/
}