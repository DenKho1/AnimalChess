/**
 * This class represents the bag of animal pieces the player selects from before playing the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Bag
{
  
  /** 
  *This constructor initializes the AnimalPiece
  *array of the Bag object
  */
  public Bag()
  {
    pieces = new AnimalPiece[8];
    pieces[0] = new AnimalPiece("Mouse",1);
    pieces[1] = new AnimalPiece("Cat",2);;
    pieces[2] = new AnimalPiece("Wolf",3);;
    pieces[3] = new AnimalPiece("Dog",4);;
    pieces[4] = new AnimalPiece("Leopard",5);;
    pieces[5] = new AnimalPiece("Tiger",6);;
    pieces[6] = new AnimalPiece("Lion",7);;
    pieces[7] = new AnimalPiece("Elephant",8);;
  }
  /** 
  *This method shuffles the contents of the pieces array
  */
  public void shuffle()
  {
    int n = pieces.length;
    int i,r;
    AnimalPiece temp;
    for (i = 0;i<n;i++)
    {
      r = (int)Math.floor(Math.random() * (i + 1));
      temp = pieces[r];
      pieces[r] = pieces[i];
      pieces[i] = temp;
    }
  }
  /** 
  *This method returns the AnimalPiece at index i
  */
  public AnimalPiece getPiece(int i)
  {
    return pieces[i-1];
  }
  /** 
  *This method prints out the contents of the pieces array
  */
  public String toString()
  {
    int i;
    String s = "contents: ";
    System.out.println("The bag contains pieces in this order\n");
    for (i=0;i<pieces.length;i++)
    {
      System.out.print("Piece at pocket " + i + ":");
      System.out.println(pieces[i].getName() + " piece\n");
      s += ("Piece at pocket " + i + ":" + pieces[i].getName() + "piece\n");
    }
    return s;
  }
  
  private AnimalPiece[] pieces;
}