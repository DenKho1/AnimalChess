import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *This class represents the GUI for the main menu
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class MainMenuGUI extends JFrame
{
    //buttons
    JButton btnPlay;
    JButton btnHTPlay;
    /** This constructor initializes the GUI Components   *(via initScreen()) and the frame
    */
    public MainMenuGUI() 
    {
     super("Animal Chess");
     initScreen();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400,200);
     setVisible(true);
    }
    /** this method initializes the GUI Components*/
    public void initScreen()
    {   
        //menu panel
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        //label
        JLabel label = new JLabel("Animal Chess");
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        //Buttons
        btnPlay = new JButton("Play");
        btnHTPlay =new JButton("How to Play");
        //gridbag
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        //constructing the GUI
        menu.add(label, gbc);
        menu.add(new JLabel("by John Paul Pangan and Denise Kho"), gbc);
        menu.add(btnPlay, gbc);
        menu.add(btnHTPlay, gbc);
        add(menu);
    }
    /** this method sets the ActionListeners
    *@param listener ActionListener*/
    public void setListener (ActionListener listener)
    {
        btnPlay.addActionListener (listener);
        btnHTPlay.addActionListener (listener);
    }
}