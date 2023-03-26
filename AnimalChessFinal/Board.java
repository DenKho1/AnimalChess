/**
 * This class represents the board used in the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Board
{
  /** This constructor initializes attributes of the board(Tiles and Pieces)based on the   given parameters.    
  @param c1 color of player 1
  @param c2 color of player 2
  */
  public Board(String c1,String c2)
  {
    Piece = new AnimalPiece[2][8];//initializes the animal piece array
    onTile= new Tile[7][9];
    int x,y;
    Win=0; //no one has won
    if(c1=="blue") //if player 1's color is blue
    {
      Piece[0][0]= new Mouse(6,0,c1);
      Piece[0][1]= new AnimalPiece("Cat",c1,2,7,5);
      Piece[0][2]= new AnimalPiece("Wolf",c1,3,6,4);
      Piece[0][3]= new AnimalPiece("Dog",c1,4,7,1);
      Piece[0][4]= new AnimalPiece("Leopard",c1,5,6,2);
      Piece[0][5]= new Leaper("Tiger",c1,6,8,6);
      Piece[0][6]= new Leaper("Lion",c1,7,8,0);
      Piece[0][7]= new Elephant(6,6,c1);

      Piece[1][0]= new Mouse(2,6,c2);
      Piece[1][1]= new AnimalPiece("Cat",c2,2,1,1);
      Piece[1][2]= new AnimalPiece("Wolf",c2,3,2,2);
      Piece[1][3]= new AnimalPiece("Dog",c2,4,1,5);
      Piece[1][4]= new AnimalPiece("Leopard",c2,5,2,4);
      Piece[1][5]= new Leaper("Tiger",c2,6,0,0);
      Piece[1][6]= new Leaper("Lion",c2,7,0,6);
      Piece[1][7]= new Elephant(2,0,c2);
    
      onTile[2][8]= new Trap(c1,8,2,1);
      onTile[4][8]= new Trap(c1,8,4,1);
      onTile[3][7]= new Trap(c1,7,3,1);
      onTile[3][8]=new Den(c1,8,3,1);

      onTile[2][0]= new Trap(c2,0,2,2);
      onTile[4][0]= new Trap(c2,0,4,2);
      onTile[3][1]= new Trap(c2,1,3,2);
      onTile[3][0]=new Den(c2,0,3,2);
    }
    else //player 1's color is red
    {
       Piece[0][0]= new Mouse(2,6,c1);
       Piece[0][1]= new AnimalPiece("Cat",c1,2,1,1);
       Piece[0][2]= new AnimalPiece("Wolf",c1,3,2,2);
       Piece[0][3]= new AnimalPiece("Dog",c1,4,1,5);
       Piece[0][4]= new AnimalPiece("Leopard",c1,5,2,4);
       Piece[0][5]= new Leaper("Tiger",c1,6,0,0);
       Piece[0][6]= new Leaper("Lion",c1,7,0,6);
       Piece[0][7]= new Elephant(2,0,c1);

       Piece[1][0]= new Mouse(6,0,c2);
       Piece[1][1]= new AnimalPiece("Cat",c2,2,7,5);
       Piece[1][2]= new AnimalPiece("Wolf",c2,3,6,4);
       Piece[1][3]= new AnimalPiece("Dog",c2,4,7,1);
       Piece[1][4]= new AnimalPiece("Leopard",c2,5,6,2);
       Piece[1][5]= new Leaper("Tiger",c2,6,8,6);
       Piece[1][6]= new Leaper("Lion",c2,7,8,0);
       Piece[1][7]= new Elephant(6,6,c2);

      onTile[2][0]= new Trap(c1,0,2,1);
      onTile[4][0]= new Trap(c1,0,4,1);
      onTile[3][1]= new Trap(c1,1,3,1);
      onTile[3][0]= new Den(c1,0,3,1);

      onTile[2][8]= new Trap(c2,8,2,2);
      onTile[4][8]= new Trap(c2,8,4,2);
      onTile[3][7]= new Trap(c2,7,3,2);
      onTile[3][8]= new Den(c2,8,3,2);
    } 
    for(x=0;x<2;x++)
    {
      for(y=0;y<8;y++)
      {
        onTile[Piece[x][y].getY()][Piece[x][y].getX()]=new Tile(Piece[x][y].getX(),Piece[x][y].getY(),Piece[x][y]);
      }
    }

    for(y=0;y<7;y++)
    {
      for(x=0;x<9;x++)
      {
        if(onTile[y][x]==null)
        {
          if(x>=3 && x<=5 && (y==1 || y==2 || y==4 ||y==5))
          {
            onTile[y][x]= new Water(x,y);
          }

          else
          {
            onTile[y][x]=new Tile(x,y);
          }
        }
      }
    }
  }

  /**This method controls how a piece is allowed to move to another Tile and capture an opponent's Piece based on the given parameters and set rules of the game.
  @param p number of the player
  @param r rank of the piece
  @param m movement of the piece
  @return the number of steps taken by the Piece
  */
  public int updateBoard(int p,int r,char m)/*p=player, r=rank and m=move*/
  {
    error = "";
    lastTurn = "";
    int a=r-1;
    int b=p-1;
    int x=Piece[b][a].getX();/*current x position*/
    int y=Piece[b][a].getY();//current y position
    int x2=0;/*Move*/
    int y2=0;

    if(m=='U') //going up
    {
      y--;
      y2=-1;
    }

    else if(m=='D') //going down
    {
      y++;
      y2=1;
    }

    else if(m=='L') //going left
    {
      x--;
      x2=-1;
    }

    else if(m=='R') //going right
    {
      x++;
      x2=1;
    }

    if(Piece[b][a].getRank()!=0 && x>=0 && x<=8 && y>=0 &&y<=6) //checks if the piece exists and is moving to a spot that is not out of bounds
    {
      if(onTile[y][x] instanceof Water && Piece[b][a] instanceof Leaper) //water and leaper scenario
      {
          boolean flag=true;
          int z;
        
          if(y2==-1) //mouse check up
          {
            
            for(z=Piece[b][a].getY()-1;z>Piece[b][a].getY()-3;z--)
            {
              if(onTile[z][x].contentCheck()!=null)
              {
                flag=false;
              }
            }
          }

          else if(y2==1)  //mouse check down 
          {
            for(z=Piece[b][a].getY()+1;z<Piece[b][a].getY()+3;z++)
            {
              if((AnimalPiece)onTile[z][x].contentCheck()!=null)
              {
                flag=false;
              }
            }
          }

          else if(x2==-1) //mouse check left
          {
            for(z=Piece[b][a].getX()-1;z>Piece[b][a].getX()-4;z--)
            {
              if(onTile[y][z].contentCheck()!=null)
              {
                flag=false;
              }
            }
          }

          else if(x2==1) //mouse check right
          {
            for(z=Piece[b][a].getX()+1;z<Piece[b][a].getX()+4;z++)
            {
              if(onTile[y][z].contentCheck()!=null)
              {
                flag=false;
              }
            }
          }
        

          if(x2==1 && flag) //updating the pieces attributes
          {
            x+=3;
            x2=4;
          }

          else if(x2==-1 && flag) //updating the pieces attributes
          {
            x-=3;
            x2=-4;
          }

          else if(y2==-1 && flag) //updating the pieces attributes
          {
            y-=2;
            y2=-3;
          }

          else if(y2==1 && flag) //updating the pieces attributes
          {
            y+=2;
            y2=3;
          }

          if(flag==false) //if a mouse was in the path of the leaper
          {
            error = "Mouse Detected!!! Piece cannot move there!";
          }
      }
      else if(onTile[y][x] instanceof Water && !(Piece[b][a] instanceof Leaper || Piece[b][a] instanceof Mouse))
      error = Piece[b][a].getColor() + " "+ Piece[b][a].getName()+ " cannot swim/leap";

      if(!(onTile[y][x] instanceof Water) && onTile[y][x].contentCheck()==null) //if the tile is not water and the contents is empty
      {
        if(!(onTile[y][x] instanceof Den)) //if the tile to be moved to is not a den
        {
           movePiece(x,y,x2,y2,b,a); //moving of the piece
           if(x2!=0) //checking o and by how much
           return x2;

           else
           return y2;
        }

        if(onTile[y][x] instanceof Den && ((Den) onTile[y][x]).getColor()!=Piece[b][a].getColor())
        //animal in opponents den scenario
        {
          movePiece(x,y,x2,y2,b,a);
          Win=b+1; //updating the win value
          
          if(x2!=0)
           return x2;

           else
           return y2;
        }

        else //animal plans to move to owner's den scenario
        {
          error = "You cannot move to your own den!";
          return 0;
        }
      }

      else if(!(onTile[y][x] instanceof Water) && onTile[y][x].contentCheck()!=null)/*on Land and has an enemy*/
      {
        if(Piece[b][a] instanceof Mouse) //if the piece to be moved is a mouse
        {
          if(onTile[Piece[b][a].getY()][Piece[b][a].getX()] instanceof Water)/*Land to water with opponent*/
          {
            error = "Opponent cannot be reached";
            return 0;
          }

          else if((onTile[y][x].contentCheck() instanceof Mouse || onTile[y][x].contentCheck() instanceof Elephant) && !(onTile[Piece[b][a].getY()][Piece[b][a].getX()] instanceof Water) && Piece[b][a].getColor()!=onTile[y][x].contentCheck().getColor()) //kill scenario: 
          {
            killPiece(x,y,x2,y2,b,a,onTile[y][x].contentCheck().getRank()-1);
            
          if(x2!=0)
           return x2;

           else
           return y2;
          }

        }


        else if(((Piece[b][a].getRank()>=onTile[y][x].contentCheck().getRank() || ( onTile[y][x] instanceof Trap 
        && ((Trap)onTile[y][x]).getColor()!=onTile[y][x].contentCheck().getColor())) && Piece[b][a].getColor()
        !=onTile[y][x].contentCheck().getColor() )&& !(Piece[b][a] instanceof Elephant 
        && onTile[y][x].contentCheck() instanceof Mouse))/*(if the rank is <= or on trap of opposite team )and avoid if moving piece is elephant and target is mouse and moving piece is not a mouse*/
        {
          killPiece(x,y,x2,y2,b,a,onTile[y][x].contentCheck().getRank()-1);
          if(x2!=0)
           return x2;

           else
           return y2;
        }

        else if(Piece[b][a] instanceof Elephant && onTile[y][x].contentCheck() instanceof Mouse && onTile[y][x] instanceof Trap
        && ((Trap)onTile[y][x]).contentCheck().getColor()!=onTile[y][x].contentCheck().getColor()
        && Piece[b][a].getColor()!=onTile[y][x].contentCheck().getColor())
        {
          killPiece(x,y,x2,y2,b,a,onTile[y][x].contentCheck().getRank()-1);
          if(x2!=0)
           return x2;

           else
           return y2;
        }
        //Elephant tries to kill mouse
        else if (Piece[b][a] instanceof Elephant && onTile[y][x].contentCheck() instanceof Mouse && Piece[b][a].getColor()!=onTile[y][x].contentCheck().getColor())
        {
            error = "Elephant cannot capture the tiny mouse";
        }
      }
      else if(onTile[y][x] instanceof Water && Piece[b][a] instanceof Mouse)
      {
        if(onTile[y][x].contentCheck()==null)
        {
          movePiece(x,y,x2,y2,b,a);
          if(x2!=0)
           return x2;

           else if (y2!=0)
           return y2;
        }

        else if(onTile[y][x].contentCheck()!=null && onTile[Piece[b][a].getY()][Piece[b][a].getX()] instanceof Water && Piece[b][a].getColor()!=onTile[y][x].contentCheck().getColor())
        {
          killPiece(x,y,x2,y2,b,a,onTile[y][x].contentCheck().getRank()-1);
          if(x2!=0)
           return x2;

           else
           return y2;
        }

        else
        {
          error = "Piece cannot move there";
          return 0;
        }
      }
      if (Piece[b][a].getColor() ==onTile[y][x].contentCheck().getColor() )
        error = "You cannot capture your own piece";
    }
    else if (Piece[b][a].getRank() == 0)
    error = "That piece has been captured and cannot move";
    else if (x == -1 || x == 9 || y == -1 || y == 7)
    error = "Piece cannot move outside the board";
    return 0;
    
  }

    /** This method allows removes a Piece from its previous tile, updates the Piece's location and adds that piece to the next tile through the following parameters
    @param x the predicted horizontal placement for the next Tile
    @param y the predicted vertical placement for the next Tile
    @param x2 the number of horizontal steps the Piece is taking
    @param y2 the number of vertical steps the Piece is taking
    @param p the player in control at the moment
    @param r the rank of the animal that the player is controlling
    */

    public void movePiece(int x, int y, int x2, int y2, int p, int r)
    {
      error = "";
      lastTurn = "";
      onTile[Piece[p][r].getY()][Piece[p][r].getX()].updatePiece(null);
      Piece[p][r].move(x2,y2);
      onTile[y][x].updatePiece(Piece[p][r]);
      lastTurn = Piece[p][r].getColor() + " " + Piece[p][r].getName();
      if (x2 == 1 || x2 == -1 || y2 == 1 || y2 == -1)
      lastTurn += " moved";
      else if ( x2 > 1 || x2 < -1 || y2 > 1 || y2 < -1) 
      lastTurn += " leaped";
      if (y2 < 0)
      lastTurn += " Up";
      else if (y2 > 0)
      lastTurn += " Down";
      if (x2 < 0)
      lastTurn += " Left";
      else if (x2 > 0)
      lastTurn += " Right";
    }

    /** This method kills the This method allows removes a Piece from its previous tile, updates the Piece's location, kills the Opponent's piece that is on the next tile, and
    adds that piece to the next tile through the following parameters
    @param x the predicted horizontal placement for the next Tile
    @param y the predicted vertical placement for the next Tile
    @param x2 the number of horizontal steps the Piece is taking
    @param y2 the number of vertical steps the Piece is taking
    @param p the player in control at the moment
    @param r the rank of the Piece that the player is controlling
    @param Op the rank of the opponent's piece that will be captured

    */
    public void killPiece(int x, int y, int x2, int y2, int p, int r, int Op)
    {
      error = "";
      lastTurn = "";
      int o;
      if(p==1)
      o=0;
      
      else
      o=1;
      lastTurn =  Piece[o][Op].getColor() + " " + Piece[o][Op].getName() +" was killed by "+ Piece[p][r].getColor() +" " +Piece[p][r].getName();
      Piece[o][Op].hasDied();
      onTile[Piece[p][r].getY()][Piece[p][r].getX()].updatePiece(null);
      Piece[p][r].move(x2,y2);
      onTile[y][x].updatePiece(Piece[p][r]);
    }

  /**This method returns the winner by checking the Win attribute and if all the pieces of each player are still alive
  @return the integer value of the current winner. If it returns 0, no one has won. If it returns a 1, player 1 has won. If it returns a 2, player 2 has won. 
  */
    public int getWin()
    {

      int p1=0, p2=0;
      for(int a=0;a<=7;a++)
      {
        if(Piece[0][a].getRank()>0)
        p1++;

        if(Piece[1][a].getRank()>0)
        p2++;
      }

      if(Win==0 && p1==0)
      {
        Win=2;
      }

      else if(Win==0 && p2==0)
      {
        Win=1;
      }

      return Win;
    }
    /**This method returns the error message String  
    @return the String that describes what kind of error has happened
    */
    public String getError()
    {
        return error;
    }
    /**This method returns the lastTurn message String
    @return the String of the last action taken by a player
    */
    public String getLastTurn()
    {
        return lastTurn;
    }
    /**This method returns the entire array of tiles on the Board
    @return the entire array of tiles on the Board
    */
    public Tile[][] getTiles()
    {
        return onTile;
    }

    

  public Tile[][] onTile; /**The array of spaces that the Pieces can traverse */
  public AnimalPiece[][] Piece;//**The Pieces that the player can move*/
  private String lastTurn;/**The String describing the action made by the player*/
  private String error;/**The error message that is empty when no error is found*/
  private int Win;/**the current winner of the game. If Win is 0 then no one has won.It will turn to 1 if player 1 wins the game and 2 if player 2 wins the game*/
}