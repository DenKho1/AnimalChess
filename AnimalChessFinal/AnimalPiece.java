
/**
 * This class represents Animal pieces used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */public class AnimalPiece
{
  /** This constructor initializes the name, color,rank, x position and y position of the AnimalPiece based on the   given parameters.    @param n name of the AnimalPiece      
  @param c color of the AnimalPiece   
  @param r rank of the AnimalPiece 
  @param x initial x position
  @param y initial y position 
  */
  public AnimalPiece(String n,String c, int r,int x, int y)
  {
    name=n; //sets name to n
    color=c;//sets color to c
    rank=r; //sets rank to r
    xPos=x; //sets xPos to x
    yPos=y; //sets yPos to y
  }
  /** This constructor initializes the name and rank of the AnimalPiece based on the   given parameters. It also gives default values for color, x position and y position 
  @param n name of the AnimalPiece        
  @param r rank of the AnimalPiece 
  */
  public AnimalPiece(String n,int r)
  {
    name=n;//sets name to n
    rank=r;//sets rank to r
    color = "red"; 
    xPos = 10; 
    yPos = 10;
  }
  /**
     * The move function moves the animal piece
     *
     * @param  x  int, the amount of spaces being moved in the x axis
     * @param  y int, the amount of spaces being moved int the y axis
     * 
     */
  public void move(int x, int y)
  {  
      if (rank != 0)
      {
      xPos+=x; //increases x position by x
      yPos+=y; //increases y position by y
      }
  }

 /**
     * This method describes the AnimalPiece object in one String
     *
     * @return  a string that describes the AnimalPiece
     *
     */
  public String toString()
  {
      return "The animal piece you got is a " + name + ", and it has a rank of " + rank; //returns this string
  }
  /**
     * This method moves the AnimalPiece out of the board and makes it inaccessible to the player by updating its attributes
     *
     * 
     */
  public void hasDied()
  {
    rank=0; 
    xPos=10;
    yPos=10;
  }
  /**
     * This method returns the x position of the AnimalPiece
     *
     * @return  the x position of the AnimalPiece
     */
  public int getX()
  {
    return xPos; 
  }
  /**
     * This method returns the y position of the AnimalPiece
     *
     * @return  the y position of the AnimalPiece
     */
  public int getY()
  {
    return yPos;
  }
  /**
     * This method returns the rank of the AnimalPiece
     *
     * 
     * @return    the rank of the AnimalPiece
     */
  public int getRank()
  {
    return rank;
  }

/**
    *This method returns the color of the AnimalPiece
    *
    * 
    * @return    the color of the AnimalPiece
*/
  public String getColor()
  {
    return color;
  }

/**
    *This method returns the name of the AnimalPiece
    *
    * 
    * @return    the name of the AnimalPiece
*/
  public String getName()
  {
    return name;
  }

  //instance variables
  private String name;/**The assigned name of the Piece*/
  private String color;/**The assigned color of the Piece*/
  private int rank;/**The rank of the Piece If the rank is 0, then the piece has been captured*/
  private int xPos; /**The current horizontal position of the Piece*/
  private int yPos; /**The current vertical position of the Piece*/
}