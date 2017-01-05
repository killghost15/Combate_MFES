package gui;

import java.awt.image.ByteLookupTable;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.AreaOp.CAGOp;

import combate.generated.*;
import combate.generated.quotes.BLUEQuote;
import combate.generated.quotes.BOMBQuote;
import combate.generated.quotes.CAPTAINQuote;
import combate.generated.quotes.COLONELQuote;
import combate.generated.quotes.FLAGQuote;
import combate.generated.quotes.GENERALQuote;
import combate.generated.quotes.LIEUTENANTQuote;
import combate.generated.quotes.MAJORQuote;
import combate.generated.quotes.MARSHALLQuote;
import combate.generated.quotes.MINERQuote;
import combate.generated.quotes.REDQuote;
import combate.generated.quotes.SCOUTQuote;
import combate.generated.quotes.SERGEANTQuote;
import combate.generated.quotes.SPYQuote;

public class GamePlay {
	public Board board;
	public ArrayList<Piece> cpPieces, playerPieces;
	public Player cp, player;
	public Combate c;
	
	public Piece flagCP, flagPlayer, bombCP1, bombCP2, bombCP3, bombCP4, bombCP5, bombCP6, 
	bombPlayer1, bombPlayer2, bombPlayer3, bombPlayer4, bombPlayer5, bombPlayer6,
	spyCP, spyPlayer, scoutCP1, scoutCP2, scoutCP3, scoutCP4, scoutCP5, scoutCP6, scoutCP7, scoutCP8,
	scoutPlayer1, scoutPlayer2, scoutPlayer3, scoutPlayer4, scoutPlayer5, scoutPlayer6, scoutPlayer7, scoutPlayer8,
	minerCP1, minerCP2, minerCP3, minerCP4, minerCP5,
	minerPlayer1, minerPlayer2, minerPlayer3, minerPlayer4, minerPlayer5,
	sergeantCP1, sergeantCP2, sergeantCP3, sergeantCP4,
	sergeantPlayer1, sergeantPlayer2, sergeantPlayer3, sergeantPlayer4,
	lieutenantCP1, lieutenantCP2, lieutenantCP3, lieutenantCP4,
	lieutenantPlayer1, lieutenantPlayer2, lieutenantPlayer3, lieutenantPlayer4,
	captainCP1, captainCP2, captainCP3, captainCP4,
	captainPlayer1, captainPlayer2, captainPlayer3, captainPlayer4,
	majorCP1, majorCP2, majorCP3,
	majorPlayer1, majorPlayer2, majorPlayer3,
	colonelCP1, colonelCP2,
	colonelPlayer1, colonelPlayer2,
	generalCP, generalPlayer,
	marshallCP, marshallPlayer;
	
	

	
	public GamePlay(){
		c = new Combate();
		//board = new Board();
		cpPieces = new ArrayList<Piece>();
		playerPieces = new ArrayList<Piece>();
		cp = new Player();
		player = new Player();
		initializePieces();


	}
	
	public void initializePieces(){
		
		BLUEQuote blue = new BLUEQuote();
		REDQuote red = new REDQuote();
		
		FLAGQuote flag = new FLAGQuote();
		SPYQuote spy = new SPYQuote();
		BOMBQuote bomb = new BOMBQuote();
		SCOUTQuote scout = new SCOUTQuote();
		MINERQuote miner = new MINERQuote();
		SERGEANTQuote sergeant = new SERGEANTQuote();
		LIEUTENANTQuote lieutenant = new LIEUTENANTQuote();
		CAPTAINQuote captain = new CAPTAINQuote();
		MAJORQuote major = new MAJORQuote();
		COLONELQuote colonel = new COLONELQuote();
		GENERALQuote general = new GENERALQuote();
		MARSHALLQuote marshall = new MARSHALLQuote();
		
		
		
	flagCP = new Piece(flag, blue);
	flagPlayer = new Piece(flag,red);
	spyCP = new Piece(spy, blue);
	spyPlayer = new Piece (spy, red);
	bombCP1 = new Piece(bomb, blue);
	bombCP2 = new Piece(bomb, blue);
	bombCP3 = new Piece(bomb, blue);
	bombCP4 = new Piece(bomb, blue);
	bombCP5 = new Piece(bomb, blue);
	bombCP6 = new Piece(bomb, blue);
	bombPlayer1 = new Piece(bomb, red);
	bombPlayer2 = new Piece(bomb, red);
	bombPlayer3 = new Piece(bomb, red);
	bombPlayer4 = new Piece(bomb, red);
	bombPlayer5 = new Piece(bomb, red);
	bombPlayer6 = new Piece(bomb, red);
	scoutCP1 = new Piece(scout, blue);
	scoutCP2 = new Piece(scout, blue);
	scoutCP3 = new Piece(scout, blue);
	scoutCP4 = new Piece(scout, blue);
	scoutCP5 = new Piece(scout, blue);
	scoutCP6 = new Piece(scout, blue);
	scoutCP7 = new Piece(scout, blue);
	scoutCP8 = new Piece(scout, blue);
	scoutPlayer1 = new Piece(scout, red);
	scoutPlayer2 = new Piece(scout, red);
	scoutPlayer3 = new Piece(scout, red);
	scoutPlayer4 = new Piece(scout, red);
	scoutPlayer5 = new Piece(scout, red);
	scoutPlayer6 = new Piece(scout, red);
	scoutPlayer7 = new Piece(scout, red);
	scoutPlayer8 = new Piece(scout, red);
	minerCP1 = new Piece(miner, blue);
	minerCP2 = new Piece(miner, blue);
	minerCP3 = new Piece(miner, blue);
	minerCP4 = new Piece(miner, blue);
	minerCP5 = new Piece(miner, blue);
	minerPlayer1 = new Piece(miner, red);
	minerPlayer2 = new Piece(miner, red);
	minerPlayer3 = new Piece(miner, red);
	minerPlayer4 = new Piece(miner, red);
	minerPlayer5 = new Piece(miner, red);
	sergeantCP1 = new Piece(sergeant, blue);
	sergeantCP2 = new Piece(sergeant, blue);
	sergeantCP3 = new Piece(sergeant, blue);
	sergeantCP4 = new Piece(sergeant, blue);
	sergeantPlayer1 = new Piece(sergeant, red);
	sergeantPlayer2 = new Piece(sergeant, red);
	sergeantPlayer3 = new Piece(sergeant, red);
	sergeantPlayer4 = new Piece(sergeant, red);
	lieutenantCP1 = new Piece(lieutenant, blue);
	lieutenantCP2 = new Piece(lieutenant, blue);
	lieutenantCP3 = new Piece(lieutenant, blue);
	lieutenantCP4 = new Piece(lieutenant, blue);
	lieutenantPlayer1 = new Piece(lieutenant, red);
	lieutenantPlayer2 = new Piece(lieutenant, red);
	lieutenantPlayer3 = new Piece(lieutenant, red);
	lieutenantPlayer4 = new Piece(lieutenant, red);
	captainCP1 = new Piece(captain, blue);
	captainCP2 = new Piece(captain, blue);
	captainCP3 = new Piece(captain, blue);
	captainCP4 = new Piece(captain, blue);
	captainPlayer1 = new Piece(captain, red);
	captainPlayer2 = new Piece(captain, red);
	captainPlayer3 = new Piece(captain, red);
	captainPlayer4 = new Piece(captain, red);
	majorCP1 = new Piece(major, blue);
	majorCP2 = new Piece(major, blue);
	majorCP3 = new Piece(major, blue);
	majorPlayer1 = new Piece(major, red);
	majorPlayer2 = new Piece(major, red);
	majorPlayer3 = new Piece(major, red);
	colonelCP1 = new Piece(colonel, blue);
	colonelCP2 = new Piece(colonel, blue);
	colonelPlayer1 = new Piece(colonel, red);
	colonelPlayer2 = new Piece(colonel, red);
	generalCP = new Piece(general, blue);
	generalPlayer = new Piece(general, red);
	marshallCP = new Piece(marshall, blue);
	marshallPlayer = new Piece(marshall, red);
	
	cpPieces.add(flagCP);
	cpPieces.add(spyCP);
	cpPieces.add(bombCP1);
	cpPieces.add(bombCP2);
	cpPieces.add(bombCP3);
	cpPieces.add(bombCP4);
	cpPieces.add(bombCP5);
	cpPieces.add(bombCP6);
	cpPieces.add(scoutCP1);
	cpPieces.add(scoutCP2);
	cpPieces.add(scoutCP3);
	cpPieces.add(scoutCP4);
	cpPieces.add(scoutCP5);
	cpPieces.add(scoutCP6);
	cpPieces.add(scoutCP7);
	cpPieces.add(scoutCP8);
	cpPieces.add(minerCP1);
	cpPieces.add(minerCP2);
	cpPieces.add(minerCP3);
	cpPieces.add(minerCP4);
	cpPieces.add(minerCP5);
	cpPieces.add(sergeantCP1);
	cpPieces.add(sergeantCP2);
	cpPieces.add(sergeantCP3);
	cpPieces.add(sergeantCP4);
	cpPieces.add(lieutenantCP1);
	cpPieces.add(lieutenantCP2);
	cpPieces.add(lieutenantCP3);
	cpPieces.add(lieutenantCP4);
	cpPieces.add(captainCP1);
	cpPieces.add(captainCP2);
	cpPieces.add(captainCP3);
	cpPieces.add(captainCP4);
	cpPieces.add(majorCP1);
	cpPieces.add(majorCP2);
	cpPieces.add(majorCP3);
	cpPieces.add(colonelCP1);
	cpPieces.add(colonelCP2);
	cpPieces.add(generalCP);
	cpPieces.add(marshallCP);

	playerPieces.add(flagPlayer);
	playerPieces.add(spyPlayer);
	playerPieces.add(bombPlayer1);
	playerPieces.add(bombPlayer2);
	playerPieces.add(bombPlayer3);
	playerPieces.add(bombPlayer4);
	playerPieces.add(bombPlayer5);
	playerPieces.add(bombPlayer6);
	playerPieces.add(scoutPlayer1);
	playerPieces.add(scoutPlayer2);
	playerPieces.add(scoutPlayer3);
	playerPieces.add(scoutPlayer4);
	playerPieces.add(scoutPlayer5);
	playerPieces.add(scoutPlayer6);
	playerPieces.add(scoutPlayer7);
	playerPieces.add(scoutPlayer8);
	playerPieces.add(minerPlayer1);
	playerPieces.add(minerPlayer2);
	playerPieces.add(minerPlayer3);
	playerPieces.add(minerPlayer4);
	playerPieces.add(minerPlayer5);
	playerPieces.add(sergeantPlayer1);
	playerPieces.add(sergeantPlayer2);
	playerPieces.add(sergeantPlayer3);
	playerPieces.add(sergeantPlayer4);
	playerPieces.add(lieutenantPlayer1);
	playerPieces.add(lieutenantPlayer2);
	playerPieces.add(lieutenantPlayer3);
	playerPieces.add(lieutenantPlayer4);
	playerPieces.add(captainPlayer1);
	playerPieces.add(captainPlayer2);
	playerPieces.add(captainPlayer3);
	playerPieces.add(captainPlayer4);
	playerPieces.add(majorPlayer1);
	playerPieces.add(majorPlayer2);
	playerPieces.add(majorPlayer3);
	playerPieces.add(colonelPlayer1);
	playerPieces.add(colonelPlayer2);
	playerPieces.add(generalPlayer);
	playerPieces.add(marshallPlayer);

	}
}
