package gui; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.*;

import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import combate.generated.Piece;
import combate.generated.Board;
import combate.generated.Board.Position;
import combate.generated.Cell;

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
        setInitialPieces();
        
        for(int ii=0; ii<10; ii++){
        	for(int jj=0; jj<10; jj++){
        		iconInterpreter(boardSquares[jj][ii]);
        	}
        }
        
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
        		boardSquares[jj][ii].setCell(game.board.getByCoord(ii, jj));
        		//System.out.println(boardSquares[ii][jj].getCell());
        	}
    	}
    }
    
    public void setInitialPieces(){
    	Piece p = new Piece();
    	Piece p1 = new Piece("null","null");
    	
    	Collections.shuffle(game.cpPieces);
    	Collections.shuffle(game.playerPieces);

    	for(int ii=0; ii<10; ii++){
        	for(int jj=0; jj<10; jj++){
        		if(ii<4){
        			//System.out.println(game.cpPieces.size());
        		p = game.cpPieces.get(ii*10+jj);
        		boardSquares[jj][ii].getCell().setPiece(p);
        		}
        		if(ii>5){
            	p = game.playerPieces.get((ii-6)*10+jj);
        		boardSquares[jj][ii].getCell().setPiece(p);
        		}
        		if(ii == 4 || ii == 5){
        			boardSquares[jj][ii].getCell().setPiece(p1);
        			boardSquares[jj][ii].getCell().setOcuppied(false);
                    if ((jj == 2 || jj == 3 || jj == 6 || jj == 7) && (ii == 4|| ii == 5))
            			boardSquares[jj][ii].getCell().setWater(true);     			
        		}

        			
        	}
    	}
    }
    

    public void ingameMapping(){
    	for(int ii=0; ii<10; ii++){
        	for(int jj=0; jj<10; jj++){
        		Piece p = boardSquares[jj][ii].getCell().getPiece();
        		if(p == null)
        		game.board.getByCoord(jj, ii).setPiece(p);
        	}
        }
    }
    
    public void iconInterpreter(MyButton b){
    	
    	String type = b.getCell().getPiece().getType().toString();
    	
		ImageIcon flag = new ImageIcon("resources\\flag.png");
		ImageIcon bomb = new ImageIcon("resources\\bomb.png");
		ImageIcon spy = new ImageIcon("resources\\spy.png");
		ImageIcon scout = new ImageIcon("resources\\scout.png");
		ImageIcon miner = new ImageIcon("resources\\miner.png");
		ImageIcon sergeant = new ImageIcon("resources\\sergeant.png");
		ImageIcon liutenant = new ImageIcon("resources\\lieutenant.png");
		ImageIcon captain = new ImageIcon("resources\\captain.png");
		ImageIcon major = new ImageIcon("resources\\major.png");
		ImageIcon colonel = new ImageIcon("resources\\colonel.png");
		ImageIcon general = new ImageIcon("resources\\general.png");
		ImageIcon marshall = new ImageIcon("resources\\marshall.png");
    	
		
    	if(type == "<FLAG>")
    		b.setIcon(flag);
    	if(type == "<BOMB>")
    		b.setIcon(bomb);
    	if(type == "<SPY>")
    		b.setIcon(spy);
    	if(type == "<SCOUT>")
    		b.setIcon(scout);
    	if(type == "<MINER>")
    		b.setIcon(miner);
    	if(type == "<SERGEANT>")
    		b.setIcon(sergeant);
    	if(type == "<LIEUTENANT>")
    		b.setIcon(liutenant);
    	if(type == "<CAPTAIN>")
    		b.setIcon(captain);
    	if(type == "<MAJOR>")
    		b.setIcon(major);
    	if(type == "<COLONEL>")
    		b.setIcon(colonel);
    	if(type == "<GENERAL>")
    		b.setIcon(general);
    	if(type == "<MARSHALL>")
    		b.setIcon(marshall);
    	if(type == "null")
    		b.setIcon(null);
    	
    }
    
    public boolean isAdjacent(Cell c1, Cell c2){
    	
    	long x1 = (long) c1.getPosition().x;
    	long y1 = (long) c1.getPosition().y;
    	long x2 = (long) c2.getPosition().x;
    	long y2 = (long) c2.getPosition().y;
    	    	
    	if(x1==x2){
    		if(y1==y2-1||y1==y2+1)
    			return true;
    	}
    	if(y1==y2){
    		if(x1==x2-1||x1==x2+1)
    			return true;
    	}

    	return false;
    }
    
    public boolean getInteraction(Piece p1, Piece p2){
  //  	if()
    	
    	return false;
    }
    
    
    public boolean makeMove(MyButton b1, MyButton b2){
    	Cell c1 = b1.getCell();
    	Cell c2 = b2.getCell();
    	if(!isAdjacent(c1, c2) && !c1.getPiece().hasUnlimitedRange())
    		return false;
    	if(c1.getWater() || c2.getWater())
    		return false;
    	
    	if(!c2.isOccupied()){
    		if(game.board.getInteraction(c1.getPiece(),c2.getPiece())){
    			b1.getCell().setPiece(null);
    			b2.setCell(c1);
    			return true;
    		}
    		else{
    			b1.getCell().setPiece(null);
    			return true;
    		}
    				
    	}
    	return false;
    		
    }
    
    

    public final JComponent getcombateBoard() {
        return combateBoard;
    }

    public final JComponent getGui() {
        return gui;
    }

    @Override
	public void actionPerformed(ActionEvent arg0) {

		if(changeable == null){
			changeable = (MyButton) arg0.getSource();

		}
		else{

			if(changeable == (MyButton) arg0.getSource())
				return;
			
			
			MyButton nowButton = (MyButton) arg0.getSource();
			MyButton preButton = changeable;
			
			Cell nowCell = nowButton.getCell();
			Cell preCell = preButton.getCell();

			Piece nowPiece = nowButton.getCell().getPiece();
			Piece prePiece = preButton.getCell().getPiece();
			
						
			if(nowButton.getCell().getPiece().getColor() == preButton.getCell()
					.getPiece().getColor())
				return;
			
			/*System.out.println(preCell.getPosition().x);
			System.out.println(preCell.getPosition().y);
			System.out.println(nowCell.getPosition().x);
			System.out.println(nowCell.getPosition().y);
			System.out.println(preCell.getPiece().hasUnlimitedRange());
			System.out.println(game.board.getByCoord(1, 1));*/
			 
			/*if(!makeMove(preButton, nowButton))
				return;
			*/
			System.out.println("MOVE");

			
			nowCell.setPiece(prePiece);
			nowButton.setCell(nowCell);
			
			preCell.setPiece(nowPiece);
			preButton.setCell(preCell);
			
			changeable.setCell(preCell);
			((MyButton) arg0.getSource()).setCell(nowCell);
			
			iconInterpreter(changeable);
			iconInterpreter((MyButton) arg0.getSource());

			ingameMapping();
			

			changeable = null;			
			
		//	System.out.println(game.board.getByCoord(preCell.getPosition().x, preCell.getPosition().y).isOccupied());
		//	System.out.println(game.board.getByCoord(nowCell.getPosition().x, nowCell.getPosition().y).isOccupied());
			
		}


	}
   
    
}