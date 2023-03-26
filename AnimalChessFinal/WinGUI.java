import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * This class represents the view and the controller for the Win screen
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class WinGUI extends JFrame implements ActionListener
{
    //instance variables
    JButton btnBack;
    /**This Constructor initializes the frame and GUI Components (via initScreen(Win)) based on the parameter
    @param Win the player number of the winner*/
    public WinGUI(int Win) 
    {
     super("Animal Chess");
     initScreen(Win);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(400,200);
     setVisible(true);
    }
    /**This Constructor initializes the GUI Components based on the parameter
    @param Win the player number of the winner*/
    public void initScreen(int Win)
    {
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        //label
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        if (Win == 1)
        {
            label.setText("Player 1 Wins!");
        }
        else
        {
            label.setText("Player 2 Wins!");
        }
        //Buttons
        btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        //gridbag
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        
        menu.add(label, gbc);
        menu.add(btnBack, gbc);
        add(menu);
    }
    @Override
    /** 
    *This method takes the actions performed in the GUI and executes accordingly
    @param e ActionEvent that was performed
    */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand ().equals ("Back"))
        {
            dispose();
            MainMenuGUI menu = new MainMenuGUI();
            MainMenuController mc = new MainMenuController(menu);
        }
        }
    }

