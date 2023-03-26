import java.awt.event.*;
import javax.swing.event.*;
/**
 *This class represents the controller for MainMenuGUI
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class MainMenuController implements ActionListener
{
    /** This constructor initializes the MainMenuGUI based on the given parameters
    @param gui Main menu GUI
    */
    public MainMenuController (MainMenuGUI gui)
    {
        this.gui = gui;
        gui.setListener(this);
    }
    @Override
    /** 
    *This method takes the actions performed in the GUI and executes accordingly
    @param e Actionevent
    */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getActionCommand ().equals ("Play"))
        {
            gui.dispose();
            sGUI = new SelectionGUI();
        }
        else if (e.getActionCommand ().equals ("How to Play"))
        {
            gui.dispose();
            ManualGUI mGUI = new ManualGUI ();
            Notebook nbk = new Notebook();
            ManualController cont = new ManualController (mGUI, nbk);
        }
    }
    //instance variables
    private MainMenuGUI gui;
    private ManualGUI mGUI;
    private Notebook nbk;
    private ManualController cont;
    private SelectionGUI sGUI;
}
