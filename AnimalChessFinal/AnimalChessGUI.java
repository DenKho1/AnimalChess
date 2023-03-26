import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 * This class is for the GUI and Controller of the game
 *
 * @author John Paul Pangan and Denise Kho
 * @version 1.0
 */
public class AnimalChessGUI extends JFrame implements ActionListener
{
    /** This constructor initializes the GUI Components, the frame, the TileGUI array and the Game object. The game object is based on the parameter
    @param g Game Model
    */
    public AnimalChessGUI(Game g)
    {
        super("Animal Chess");
        this.g = g;
        n = 1; //player 1 always goes first
        animal = 1; //initial choice
        direction = 'U'; //initial choice
        //images
        ImageIcon iBoard = new ImageIcon("Board.png");
        tiles = new TileGUI[9][7];
        //background is gray
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.GRAY);
        
        label1.setIcon(iBoard);
        label1.setBounds(90,0,360,280);//xpos ypos x size y size
        //board Panel
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,550,280);
        //info Labels
        lTurn = new JLabel("it is "+ g.getC1() + " player's turn");
        lError = new JLabel();
        lLastTurn = new JLabel();
        lTurn.setBounds(90,300,360,20);//xpos ypos x size y size
        lError.setBounds(90,320,360,20);
        lLastTurn.setBounds(90,340,360,20);
        lTurn.setOpaque(true);
        lError.setOpaque(true);
        lLastTurn.setOpaque(true);
        lTurn.setBackground(Color.WHITE);
        lError.setBackground(Color.WHITE);
        lLastTurn.setBackground(Color.WHITE);
        //controls
        String[] directions = {"Up","Down","Left","Right"};
        String[] animals = {"1-Mouse","2-Cat","3-Wolf","4-Dog","5-Leopard","6-Tiger","7-Lion","8-Elephant"};
        directionChoice = new JComboBox (directions);
        directionChoice.setBounds(220,400,100,30);//xpos ypos x size y size
        animalChoice = new JComboBox (animals);
        animalChoice.setBounds(220,440,100,30);//xpos ypos x size y size
        JButton btnMove = new JButton("Make Move");
        btnMove.setBounds(220,480,100,30);//xpos ypos x size y size
        //listener adding
        directionChoice.addActionListener(this);
        animalChoice.addActionListener(this);
        btnMove.addActionListener(this);
        //construct board
        initTiles(layeredPane);
        layeredPane.add(label1);
        //construct panels
        JPanel gPanel = new JPanel();
        gPanel.setLayout(null);
        gPanel.setBounds(0,0,550,700);
        gPanel.setBackground(Color.GRAY);
        gPanel.add(layeredPane);
        gPanel.add(lTurn);
        gPanel.add(lError);
        gPanel.add(lLastTurn);
        gPanel.add(animalChoice);
        gPanel.add(directionChoice);
        gPanel.add(btnMove);
        
        //construct frame
        add(gPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(550,700));
        setLayout(null);
        setVisible(true);
        updateBoard();
    }
    /** 
  *This method initializes and adds the TileGUI objects to the layeredPane given in the parameter
  *@param l LayeredPane that will be given the tiles
  */
    public void initTiles(JLayeredPane l) // this initializes the tiles
    {
        int x,y;
        //making a tile
        for (y=0;y<7;y++)
        {
            for(x=0;x<9;x++)
            {
                tiles[x][y]=new TileGUI(x,y); //making the tile
                l.add(tiles[x][y]);//adding the tile to the layeredPane
            }
        }
    }
    /** 
    *This method updates the TileGUI array to reflect the board Tile array
    */
    public void updateBoard()
    {
        int y,x;
        Tile[][] rTiles = g.getTiles(); 
        AnimalPiece Temp;
        for(y=0;y<7;y++)
        {
            for(x=0;x<9;x++)
            {
                if(rTiles[y][x].contentCheck() == null)
                 tiles[x][y].setIcon(null);
                else
                {
                    Temp = rTiles[y][x].contentCheck();
                    switch(Temp.getColor())
                    {
                        case "red": tiles[x][y].updateIcon(0,Temp.getRank()-1);break;
                        case "blue": tiles[x][y].updateIcon(1,Temp.getRank()-1);break;
                    }
                }
            }
        }
        if (n==1)//if its player 1
        lTurn.setText("it is "+ g.getC1() + " player's turn");
        else
        lTurn.setText("it is "+ g.getC2() + " player's turn");
        
        lError.setText(g.getBoard().getError());
        lLastTurn.setText(g.getBoard().getLastTurn());
    }
    @Override
    /** 
    *This method takes the actions performed in the GUI and executes accordingly
    @param e ActionEvent that was performed
    */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource()==animalChoice)
        {
            animal = animalChoice.getSelectedIndex() +1;
        }
        if (e.getSource()==directionChoice)
        {
            switch(directionChoice.getSelectedIndex())
            {
                case 0: direction = 'U';break; //UP
                case 1: direction = 'D';break; //Down
                case 2: direction = 'L';break; //Left
                case 3: direction = 'R';break; //Right
            }
        }
        if (e.getActionCommand ().equals ("Make Move"))
        {
            int z=g.getBoard().updateBoard(n,animal, direction); //do the move you selected
            if(z!=0)
            {
                if(n==1) //player 1 made a move
                    n=2; //change to player 2
                else     //player 2 made a move
                    n=1; //change to player 1
            }
            updateBoard(); //update graphics
            if(g.getBoard().getWin()!=0) //it checks if someone won
            {
                if(g.getBoard().getWin()==1)
                {
                    dispose(); //close 
                    WinGUI win = new WinGUI(1); //player 1 wins
                }
                else
                {
                    dispose();
                    WinGUI win = new WinGUI(2); //player 2 wins
                }
            }
        }
    }
    //instance variables
    Game g;
    private TileGUI[][] tiles;
    private JLabel lTurn;
    private JLabel lError;
    private JLabel lLastTurn;
    private JComboBox directionChoice;
    private JComboBox animalChoice;
    private JButton btnMove;
    int n; //player number
    int animal;//player animal choice
    char direction; //player direction choice
}

