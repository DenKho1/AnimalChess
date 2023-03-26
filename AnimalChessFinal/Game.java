import java.util.Scanner;
/**
 * This class represents the game model
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Game
{
  /** 
  This constructor initializes the Game object   
  @param c1 color of player 1
  @param c2 color of player 2
  */
  public Game(String c1, String c2)
  {
    //we initialize the board once we get our player colors
    winner = 0; // no one has won yet
    color1 = c1;
    color2 = c2;
    players = new Player[2];
    players[0] = new Player(c1,1);
    players[1] = new Player(c2,2);
    gameboard = new Board(c1,c2);
  }

  /**This method returns all the tiles that are on the gameboard
  @return the complete array of tiles on the gameboard
  */
  public Tile[][] getTiles()
  {
      return gameboard.getTiles();
  }

  /**This method returns the gameboard
  @return the entire gameboard
  */
  public Board getBoard()
  {
      return gameboard;
  }
  /**This method returns the color of player 1
   @return the String that describes the color of player 1
  */
  public String getC1()
  {
      return color1;
  }
    /**This method returns the color of player 2
    @return the String that describes the color of player 2
  */
  public String getC2()
  {
      return color2;
  }
  //instance variables
  private String color1,color2;/**color1 is the color of player 1 and color 2 is the color of player 2*/
  private int winner; /**the winner of the game with 0 being the neutral, 1 being player 1's win and 2 being player 2's win*/
  private Player[] players; /**the player's of the game*/
  private Board gameboard; /**The board that the game is played on*/
}