package gui; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

public class BoardCR implements ActionListener{
	private MyButton changeable = null;
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private MyButton[][] boardSquares = new MyButton[10][10];

    private JPanel combateBoard;
    private final JLabel message = new JLabel(
            "Combate!");
    private static final String COLS = "ABCDEFGHIJ";
    private GamePlay  game = new GamePlay();
    

    public BoardCR() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.add(new JButton("Save")); // TODO - add functionality!
        tools.add(new JButton("Restore")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // TODO - add functionality!
        tools.addSeparator();
        tools.add(message);

                
        
        
        Insets buttonMargin = new Insets(0, 0, 0, 0);
       
        combateBoard = new JPanel(new GridLayout(0, 11));
        combateBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(combateBoard, BorderLayout.LINE_START);
        //gui.add(piecesBoardPanel);

        // create the board squares
        for (int ii = 0; ii < boardSquares.length; ii++) {
            for (int jj = 0; jj < boardSquares[ii].length; jj++) {
            	MyButton b = new MyButton();
                b.addActionListener(this);
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj == 2 || jj == 3 || jj == 6 || jj == 7) && (ii == 4|| ii == 5))
                         {
                    b.setBackground(Color.BLUE);
                } else {
                    b.setBackground(Color.GREEN);
                }
                boardSquares[jj][ii] = b;
            }
        }
        
        mapBoard();

        //fill the chess board
        combateBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 10; ii++) {
            combateBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 10; ii++) {
            for (int jj = 0; jj < 10; jj++) {
                switch (jj) {
                    case 0:
                        combateBoard.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                    default:
                        combateBoard.add(boardSquares[jj][ii]);
                }
            }
        }
    }
    
    public void mapBoard(){
    	for(int ii=0; ii<10; ii++){
        	for(int jj=0; jj<10; jj++){
        		boardSquares[ii][jj].setCell(game.board.getByCoord(ii, jj));
        		System.out.println(boardSquares[ii][jj].getCell());
        	}
    	}
    }

    public final JComponent getcombateBoard() {
        return combateBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    private void addCharacters(JButton[][] pieces, ArrayList<ImageIcon> images) {
    	
		for(int i = 0; i < pieces.length; i++){
			for(int j = 0; j < pieces[i].length; j++){
				pieces[i][j].setIcon(images.get(j));
			}
		}
	}
    
    public ArrayList<ImageIcon> fillIconArray(){
		ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
		ImageIcon flag = new ImageIcon("resources\\flag.png");
		images.add(flag);
		ImageIcon bomb = new ImageIcon("resources\\bomb.png");
		images.add(bomb);
		images.add(bomb);
		images.add(bomb);
		images.add(bomb);
		images.add(bomb);
		images.add(bomb);
		ImageIcon spy = new ImageIcon("resources\\spy.png");
		images.add(spy);
		ImageIcon scout = new ImageIcon("resources\\scout.png");
		images.add(scout);
		images.add(scout);
		images.add(scout);
		images.add(scout);
		images.add(scout);
		images.add(scout);
		images.add(scout);
		images.add(scout);
		ImageIcon miner = new ImageIcon("resources\\miner.png");
		images.add(miner);
		images.add(miner);
		images.add(miner);
		images.add(miner);
		images.add(miner);
		ImageIcon sergeant = new ImageIcon("resources\\sergeant.png");
		images.add(sergeant);
		images.add(sergeant);
		images.add(sergeant);
		images.add(sergeant);
		ImageIcon liutenant = new ImageIcon("resources\\lieutenant.png");
		images.add(liutenant);
		images.add(liutenant);
		images.add(liutenant);
		images.add(liutenant);
		ImageIcon captain = new ImageIcon("resources\\captain.png");
		images.add(captain);
		images.add(captain);
		images.add(captain);
		images.add(captain);
		ImageIcon major = new ImageIcon("resources\\major.png");
		images.add(major);
		images.add(major);
		images.add(major);
		ImageIcon colonel = new ImageIcon("resources\\colonel.png");
		images.add(colonel);
		images.add(colonel);
		ImageIcon general = new ImageIcon("resources\\general.png");
		images.add(general);
		ImageIcon marshall = new ImageIcon("resources\\marshall.png");
		images.add(marshall);
		return images;
	}

    @Override
	public void actionPerformed(ActionEvent arg0) {
		/*if(changeable == null){
			changeable = (MyButton) arg0.getSource();
		}
		else {
			ImageIcon i = (ImageIcon) changeable.getIcon();
			((JButton)arg0.getSource()).setIcon(i);
			changeable.setIcon(null);
			changeable = null;*/
    	changeable = (MyButton) arg0.getSource();
    	System.out.println(changeable.getCell());
		
	}
   
    
}