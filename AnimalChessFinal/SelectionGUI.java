import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class represents the view and the controller for the selection screen
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class SelectionGUI extends JFrame implements ActionListener
{
    //instance variables
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;
    JButton btn6;
    JButton btn7;
    JButton btn8;
    JButton btnNext;
    JLabel lInfo;
    AnimalPiece choice;
    Bag b;
    int curChoosing;
    ColorSelectionGUI cGUI;
    /**This constructor initializes the Bag, Frame, GUI components (via initScreen()) and shuffles the bag*/
    public SelectionGUI() 
    {
     super("Animal Chess");
     curChoosing = 1;
     b = new Bag();
     b.shuffle();
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new GridBagLayout());
     initScreen();
     setSize(500,500);
     setVisible(true);
    }
    /**This method initializes the GUI Components*/
    public void initScreen()
    {
        JPanel Buttons = new JPanel();
        Buttons.setLayout(new GridLayout());
        lInfo = new JLabel("waiting for choice");
        btnNext = new JButton("Next");
        btnNext.addActionListener(this);
        //label
        JLabel label = new JLabel("Pick a Piece");
        //Buttons
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        
        btn1.addActionListener (this);
        btn2.addActionListener (this);
        btn3.addActionListener (this);
        btn4.addActionListener (this);
        btn5.addActionListener (this);
        btn6.addActionListener (this);
        btn7.addActionListener (this);
        btn8.addActionListener (this);
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);
        Buttons.add(btn1);        
        Buttons.add(btn2);
        Buttons.add(btn3);
        Buttons.add(btn4);
        Buttons.add(btn5);
        Buttons.add(btn6);
        Buttons.add(btn7);
        Buttons.add(btn8);
        add(Buttons, gbc);
        add(lInfo, gbc); 
        add(btnNext,gbc);
    }
    @Override
    /** 
    *This method takes the actions performed in the GUI and executes accordingly
    @param e ActionEvent that was performed
    */
    public void actionPerformed (ActionEvent e)
    {
        JButton btn;
        if (e.getActionCommand ().equals ("Next"))
        {
            dispose();
            cGUI = new ColorSelectionGUI(); 
        }
        if (e.getActionCommand ().equals ("1"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(1);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("2"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(2);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("3"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(3);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("4"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(4);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("5"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(5);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("6"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(6);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("7"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(7);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
        else if (e.getActionCommand ().equals ("8"))
        {
            btn = (JButton) e.getSource ();
            choice = b.getPiece(8);
            if (curChoosing == 1)
            {
                lInfo.setText(choice.toString() + ", next player please pick");
                curChoosing++;
            }
            else
            lInfo.setText(choice.toString() + ", please click next");
            btn.setEnabled(false);
        }
    }
}
