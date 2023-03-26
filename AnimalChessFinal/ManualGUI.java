import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *This class represents the GUI for the Manual, reference: ccprog3 lectures
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class ManualGUI extends JFrame
{
    //instance Variables
    private JButton btnPrev;
    private JButton btnNext;
    private JButton btnBack;
    private JTextArea taContent;
    private JLabel lblPage;
    /** This constructor initializes the GUI Components   *(via init()) and the frame
    */
    public ManualGUI ()
    {
        super ("Animal Chess Rules");
        setLayout (new BorderLayout ());
        init ();
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (500, 800);
        setVisible (true);
    }
    /** This method initializes the GUI Components
    */
    private void init ()
    {
        // south
        JPanel panelSouth;

        panelSouth = new JPanel ();
        panelSouth.setLayout (new FlowLayout ());
        
        btnBack = new JButton ("Back");
        panelSouth.add (btnBack);
        add (panelSouth, BorderLayout.SOUTH);
        // north
        JPanel panelNorth = new JPanel ();
        panelNorth.setLayout (new FlowLayout ());

        btnPrev = new JButton ("<<");
        panelNorth.add (btnPrev);
        
        lblPage = new JLabel ("Page ");
        panelNorth.add (lblPage);
        
        btnNext = new JButton (">>");
        panelNorth.add (btnNext);

        add (panelNorth, BorderLayout.NORTH);
        
        // center
        JScrollPane scroll;
        taContent = new JTextArea ();
        scroll = new JScrollPane (taContent);
        
        add (scroll, BorderLayout.CENTER);
    }
    /** This method sets the ActionListeners
    @param listener ActionListener
    */
    public void setListener (ActionListener listener)
    {
        btnBack.addActionListener (listener);
        btnPrev.addActionListener (listener);
        btnNext.addActionListener (listener);
    }
    /** This method sets the DocumentListener
    @param listener DocumentListener
    */
    public void setDocumentListener (DocumentListener listener)
    {
        taContent.getDocument ().addDocumentListener (listener);
    }
    /** This method determines if the previous button is enabled or disabled based on the parameter
    @param bEnabled boolean for enabling/disabling button
    */
    public void setPrevEnabled (boolean bEnabled)
    {
        btnPrev.setEnabled (bEnabled);
    }
    /** This method determines if the previous button is enabled or disabled based on the parameter
    @param bEnabled boolean for enabling/disabling button
    */
    public void setNextEnabled (boolean bEnabled)
    {
        btnNext.setEnabled (bEnabled);
    }
    /** This method returns the content in the Text Area
    @return the content in the Text Area
    */
    public String getTextAreaContent ()
    {
        return taContent.getText ();
    }
    /** This method sets the content in the Text Area
    @param content the content to be set in the Text Area
    */
    public void setTextAreaContent (String content)
    {
        taContent.setText (content);
    }
    /** This method updates the GUI component lblPage based on the given parameters
    @param pageno current page number
    @param pages total number of pages
    */
    public void setPageInfo (int pageno, int pages)
    {
        lblPage.setText ("Page " + pageno + " of " + pages);
    }
    
}
