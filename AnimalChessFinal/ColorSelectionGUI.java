import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents the ColorSelection GUI
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class ColorSelectionGUI extends JFrame implements ActionListener
{
    JButton btnRed;
    JButton btnBlue;
    Game g;
    AnimalChessGUI acg;
    /** This constructor initializes the GUI Components (via initScreen()) and the Frame
    *
    */
    public ColorSelectionGUI() 
    {
     super("Animal Chess");
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new GridBagLayout());
     initScreen();
     setSize(400,200);
     setVisible(true);
    }
    /** 
  *This method initializes the GUI Components and adds it to the frame
  *
  */
    public void initScreen()
    {
        JPanel Buttons = new JPanel();
        Buttons.setLayout(new GridLayout());
        //label
        JLabel label = new JLabel("Player with the higher ranked piece, You are player 1, pick a color");
        //Buttons
        btnRed = new JButton("Red");
        btnRed.addActionListener(this);
        btnBlue = new JButton("Blue");
        btnBlue.addActionListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);
        Buttons.add(btnRed);
        Buttons.add(btnBlue);
        add(Buttons, gbc);
    }
    @Override
    /** 
    *This method takes the actions performed in the GUI and executes accordingly
    @param e ActionEvent that was performed
    */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand ().equals ("Red"))
        {
            dispose();
            g = new Game("red","blue");
            acg = new AnimalChessGUI(g);
        }
        else if (e.getActionCommand ().equals ("Blue"))
        {
            dispose();
            g = new Game("blue","red");
            acg = new AnimalChessGUI(g);
        }
    }
}
