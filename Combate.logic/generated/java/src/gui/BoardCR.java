package gui; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.border.*;

import org.omg.CORBA.MARSHAL;

import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import combate.generated.Piece;
import combate.generated.quotes.BOMBQuote;
import combate.generated.quotes.CAPTAINQuote;
import combate.generated.quotes.COLONELQuote;
import combate.generated.quotes.GENERALQuote;
import combate.generated.quotes.LIEUTENANTQuote;
import combate.generated.quotes.MAJORQuote;
import combate.generated.quotes.MARSHALLQuote;
import combate.generated.quotes.MINERQuote;
import combate.generated.quotes.SCOUTQuote;
import combate.generated.quotes.SERGEANTQuote;
import combate.generated.quotes.SPYQuote;
import combate.generated.Board;
import combate.generated.Board.Position;
import combate.generated.Cell;

public class BoardCR implements ActionListener{
	private boolean gamestate= false;
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
        		boardSquares[jj][ii].setCell(game.c.board.getByCoord(ii, jj));
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
        		if ((jj == 2 || jj == 3 || jj == 6 || jj == 7) && (ii == 4|| ii == 5))
         			boardSquares[jj][ii].getCell().setWater(true);     		
        		if(ii<4){
        			//System.out.println(game.cpPieces.size());
        		p = game.cpPieces.get(ii*10+jj);
        		boardSquares[jj][ii].getCell().setPiece(p);
     			boardSquares[jj][ii].getCell().setWater(false);     
    			boardSquares[jj][ii].getCell().setOcuppied(true);
        		}
        		if(ii>5){
            	p = game.playerPieces.get((ii-6)*10+jj);
        		boardSquares[jj][ii].getCell().setPiece(p);
     			boardSquares[jj][ii].getCell().setWater(false);
    			boardSquares[jj][ii].getCell().setOcuppied(true);

        		}
        		if(ii == 4 || ii == 5){
        			boardSquares[jj][ii].getCell().setPiece(p1);
        			boardSquares[jj][ii].getCell().setOcuppied(false);
        		}

        			
        	}
    	}
    }
    

    public void ingameMapping(){
    	for(int ii=0; ii<10; ii++){
        	for(int jj=0; jj<10; jj++){
        		Piece p = boardSquares[jj][ii].getCell().getPiece();
        		if(p == null)
        		game.c.board.getByCoord(jj, ii).setPiece(p);
        	}
        }
    }
    
    public void iconInterpreter(MyButton b){
    	
    	if(b.getCell().getPiece() == null){
    		b.setIcon(null);
    		return;
    	}
    	
    	
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
    	
    	System.out.println("IS ADJACENT?");
    	long x1 = (long) c1.getPosition().x;
    	long y1 = (long) c1.getPosition().y;
    	long x2 = (long) c2.getPosition().x;
    	long y2 = (long) c2.getPosition().y;
    	    	
    	if(x1==x2){
    		if(y1==y2-1||y1==y2+1){
    	    	System.out.println("ADJACENT!");
    			return true;
    			}
    	}
    	if(y1==y2){
    		if(x1==x2-1||x1==x2+1){
    	    	System.out.println("ADJACENT!");
    			return true;
    		}
    	}
    	System.out.println("NOT ADJACENT!");

    	return false;
    }
    
    public int getInteraction(Piece p1, Piece p2){
    	int st1 = 0,st2 = 0;
    	
    	
    	if(p1.getType().toString() == "<BOMB>")
    		st1=11;
    	if(p1.getType().toString() == "<SPY>")
    		st1=1;
    	if(p1.getType().toString() == "<SCOUT>")
    		st1=2;
    	if(p1.getType().toString() == "<MINER>")
    		st1=3;
    	if(p1.getType().toString() == "<SERGEANT>")
    		st1=4;
    	if(p1.getType().toString() == "<LIEUTENANT>")
    		st1=5;
    	if(p1.getType().toString() == "<CAPTAIN>")
    		st1=6;
    	if(p1.getType().toString() == "<MAJOR>")
    		st1=7;
    	if(p1.getType().toString() == "<COLONEL>")
    		st1=8;
    	if(p1.getType().toString() == "<GENERAL>")
    		st1=9;
    	if(p1.getType().toString() == "<MARSHALL>")
    		st1=10;
    	
    	if(p2.getType().toString() == "<BOMB>")
    		st2=11;
    	if(p2.getType().toString() == "<SPY>")
    		st2=1;
    	if(p2.getType().toString() == "<SCOUT>")
    		st2=2;
    	if(p2.getType().toString() == "<MINER>")
    		st2=3;
    	if(p2.getType().toString() == "<SERGEANT>")
    		st2=4;
    	if(p2.getType().toString() == "<LIEUTENANT>")
    		st2=5;
    	if(p2.getType().toString() == "<CAPTAIN>")
    		st2=6;
    	if(p2.getType().toString() == "<MAJOR>")
    		st2=7;
    	if(p2.getType().toString() == "<COLONEL>")
    		st2=8;
    	if(p2.getType().toString() == "<GENERAL>")
    		st2=9;
    	if(p2.getType().toString() == "<MARSHALL>")
    		st2=10;
    		
    	if(st2==11 && st1 != 3){
    		System.out.println("GET_INT: LOST");
    		return -1;
    	}
    	if(st1==1 && st2 == 10){
    		System.out.println("GET_INT: WON");

    		return 1;
    	}
    	if(st2==1 && st1==10){
    		System.out.println("GET_INT: LOST");

    		return -1;
    	}
    	
    	if(st1 == st2){
    		System.out.println("GET_INT: DRAW");
    		return 0;
    	}
    	if(st1>st2){
    		System.out.println("GET_INT: WON");
    		return 1;
    	}
    	if(st2>st1){
    		System.out.println("GET_INT: LOST");
    		return -1;
    	}
    	
		System.out.println("GET_INT: ERROR");
	
   	return 2;
    	
    	
        }
    
    
    public boolean makeMove(MyButton b1, MyButton b2){
    	Cell c1 = b1.getCell();
    	Cell c2 = b2.getCell();
    	Piece p = new Piece("null", "null");
    
    	if(c1.getPiece().getType().toString()=="<FLAG>" || c1.getPiece().getType().toString()=="<BOMB>")
    		return false;
    	
    	if(c2.getPiece().getType().toString()=="<FLAG>"){
    		gamestate = true;
    		return true;
    	}
    	
    	if(!c1.isOccupied())
    		return false;
    	
    	if(!isAdjacent(c1, c2) && !c1.getPiece().hasUnlimitedRange()){
			System.out.println("CANT MOVE");
    		return false;
    		}
    	
    	if(c1.getWater() || c2.getWater()){
			System.out.println("WATER");
    		return false;
    	}
    	
    	if(!c2.isOccupied()){
    		if(c1.getPiece().hasUnlimitedRange()){
    			System.out.println("FREE LANE?");
    			System.out.println(!game.c.board.isFreeLane(new Position(c1.getPosition().x, c1.getPosition().y), new Position(c2.getPosition().x, c2.getPosition().y)));
    			if(!game.c.board.isFreeLane(new Position(c1.getPosition().x, c1.getPosition().y), new Position(c2.getPosition().x, c2.getPosition().y)))
    				return false;
    		}
			b2.getCell().setPiece(c1.getPiece());
			b1.getCell().setPiece(p);
			iconInterpreter(b1);
			iconInterpreter(b2);

			System.out.println("FREE");
    	}
    	else{
    		if(getInteraction(c1.getPiece(), c2.getPiece()) == 1){
    			b2.getCell().setPiece(c1.getPiece());
    			b1.getCell().setPiece(p);
    			iconInterpreter(b1);
    			iconInterpreter(b2);
    			System.out.println("WON");

    			return true;
    		}
    		if(getInteraction(c1.getPiece(), c2.getPiece()) == -1){
    			b1.getCell().setPiece(p);
    			iconInterpreter(b1);
    			System.out.println("LOST");
    			

    			return true;
    		}
    		if(getInteraction(c1.getPiece(), c2.getPiece())==0){
    			b1.getCell().setPiece(p);
    			b2.getCell().setPiece(p);
    			iconInterpreter(b1);
    			iconInterpreter(b2);
    			System.out.println("DRAW");

    			return true;
    		}
    		if(getInteraction(c1.getPiece(), c2.getPiece())==2){
    			System.out.println("ERRO");
    			return false;
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
			/*if(!changeable.getCell().isOccupied())
				changeable = null;*/
		}
		else{

			if(changeable == (MyButton) arg0.getSource())
				return;
			
			
			MyButton nowButton = (MyButton) arg0.getSource();
			MyButton preButton = changeable;

			
						
			if(nowButton.getCell().getPiece().getColor() == preButton.getCell()
					.getPiece().getColor())
				return;
				
			
			 
			makeMove(changeable, (MyButton) arg0.getSource());
			if(gamestate)
				System.out.println("GANHOUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
			

			ingameMapping();
			

			changeable = null;			
			
		//	System.out.println(game.c.board.getByCoord(preCell.getPosition().x, preCell.getPosition().y).isOccupied());
		//	System.out.println(game.c.board.getByCoord(nowCell.getPosition().x, nowCell.getPosition().y).isOccupied());
			
		}


	}
   
    
}