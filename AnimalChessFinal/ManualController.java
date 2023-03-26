import java.awt.event.*;
import javax.swing.event.*;
/**
 *This class represents the controller for ManualGUI
 reference: ccprog3 lectures
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class ManualController implements ActionListener
{
    private ManualGUI gui;
    private Notebook nbk;
    /**
    * This constructor initializes the ManualGUI, Notebook and String array, it fills in teh content for the string array and writes it to the Notebook
    @param gui ManualGUI to be controlled
    @param nbk Notebook Model
    */ 
    public ManualController (ManualGUI gui, Notebook nbk)
    {
        int i;
        String[] rules = new String[5];//rules
        //initialziing the rules
        rules[0] = "Animal Chess is a game where you control 8 animals, the goal of the game is to get one\nof your animals into an opponent's den, or capture all of your opponents animals\n\n";
        rules[0] +="Each animal has a rank, an animal can only capture an opponent piece if their rank is\ngreater than or equal to it, with some exceptions\n\n";
        rules[0] +="An animal Can move in 4 directions, Up, Down, Left, or Right and some animals have\nspecial abilities\n\n";
        rules[1] = "there are 3 traps around a den, any animal caught in one, will lose all of its\npower and can be attacked\n\n";
        rules[1] +="Water is a tile that cannot be moved to with the only exception being the mouse";
        rules[2] = "The Lion and Tiger can leap over water blocks vertically and horizontally\n";
        rules[2] +="They cannot leap over however, if there is a mouse along the path, if an Ally animal\nor a higher ranked animal is at their destination\n\n";
        rules[2] +="The Mouse can swim on water it can also capture the elephant, the highest ranked\nanimal in the game\n";
        rules[2] +="However, a mouse can only capture an opposing mouse if they are on the same type of\ntile and cannot capture elephant if it's in the water\n\n";
        rules[2] +="The Elephant's special trait is that it cannot capture the mouse";
        rules[3] = "Rank\n1\tMouse\n2\tCat\n3\tWolf\n4\tDog\n5\tLeopard\n6\tTiger\n7\tLion\n8\tElephant\n";
        rules[4] = "Don't forget to have fun!\nThis game was made by John Paul Pangan and Denise Kho";
        this.gui = gui;
        this.nbk = nbk;
              
        for (i=0;i<5;i++)
        {
            nbk.writeOnPage (rules[i]); //writing the rules 
            nbk.nextPage();
        }
        for(i=0;i<5;i++)
        {
        nbk.prevPage(); //going back to page 1
        }
        updateView ();  //updating the view
        gui.setListener (this);        
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
            gui.dispose(); //close window
            //return to menu
            MainMenuGUI menu = new MainMenuGUI(); 
            MainMenuController mc = new MainMenuController(menu);
        }
        else if (e.getActionCommand ().equals (">>"))
        {// next page
            
            // update the model, to flip to next page
            nbk.nextPage ();
            updateView ();
            
        }
        else if (e.getActionCommand ().equals ("<<"))
        {// previous page
            
            // update the model, to flip to prev page
            nbk.prevPage ();
            updateView ();
            
        }
    }
    /** 
    *This method updates the view/GUI 
    */
    public void updateView ()
    {
        // update GUI
        gui.setPrevEnabled (true);
        gui.setNextEnabled (true);
        
        // update page info
        gui.setPageInfo (nbk.getCurrentPageNo (), nbk.getNumberOfPages ());
        // update page content
        gui.setTextAreaContent(nbk.retrieveContent ());
        
        // disable next page button if at last page
        if (nbk.isAtLastPage ())
            gui.setNextEnabled (false);
        // disable next page button if at first page
        if (nbk.isAtFirstPage ())
            gui.setPrevEnabled (false);
    }
    
}
