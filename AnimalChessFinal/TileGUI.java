import javax.swing.*;
import java.awt.*;
/**
 * This class represents the TileGUI JLabels
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class TileGUI extends JLabel
{
    private final int YPOS;
    private final int XPOS;
    private static Gallery g;
    /**This Constructor initializes the x and y positions, the JLabel and sets its bounds based on the given parameters
    @param x x position
    @param y y position*/
    public TileGUI(int x, int y)
    {
        super();
        XPOS = x;
        YPOS = y;
        setBounds(90 + (40*XPOS),0 + (40*YPOS),40,40);
        g = new Gallery();
    }
    /**this method sets the Icon based on the given parameters
    @param c color of the animal
    @param a the rank of the animal */
    public void updateIcon(int c, int a)
    {
        setIcon(g.getIcon(c,a));
    }
    
}
