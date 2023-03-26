import javax.swing.*;

/**
 * The Gallery class contains all the pictures for the animal pieces and makes it easy to access
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class Gallery
{
    // instance variables
    private ImageIcon[][] icons;
    /** This constructor initializes the ImageIcon array and its contents
    *
    */
    public Gallery()
    {
        icons = new ImageIcon[2][8];
        //0 is red, 1 is blue
        //0 is mouse, 7 is elephant
        //red
        icons[0][0] =  new ImageIcon("1red.png");
        icons[0][1] =  new ImageIcon("2red.png");
        icons[0][2] =  new ImageIcon("3red.png");
        icons[0][3] =  new ImageIcon("4red.png");
        icons[0][4] =  new ImageIcon("5red.png");
        icons[0][5] =  new ImageIcon("6red.png");
        icons[0][6] =  new ImageIcon("7red.png");
        icons[0][7] =  new ImageIcon("8red.png");
        //blue
        icons[1][0] =  new ImageIcon("1blue.png");
        icons[1][1] =  new ImageIcon("2blue.png");
        icons[1][2] =  new ImageIcon("3blue.png");
        icons[1][3] =  new ImageIcon("4blue.png");
        icons[1][4] =  new ImageIcon("5blue.png");
        icons[1][5] =  new ImageIcon("6blue.png");
        icons[1][6] =  new ImageIcon("7blue.png");
        icons[1][7] =  new ImageIcon("8blue.png");
    }
    /**This method returns the corresponding ImageIcon based on the given parameters
    @param c color of the animal
    @param a rank of the animal
    @return Image of the colored animal*/
    public ImageIcon getIcon(int c, int a)
    {
        return icons[c][a];
    }
}
