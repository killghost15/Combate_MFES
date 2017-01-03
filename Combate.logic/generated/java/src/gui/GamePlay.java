package gui;

import java.util.ArrayList;
import java.util.List;

import combate.generated.*;

public class GamePlay {
	public Board board;
	public ArrayList<Piece> cpPieces, playerPieces;
	public Player cp, player;
	
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
		board = new Board();
		cpPieces = new ArrayList<Piece>();
		cp = new Player();
		player = new Player();
		initializePieces();


	}
	
	public void initializePieces(){
	flagCP = new Piece("FLAG", "BLUE");
	flagPlayer = new Piece("FLAG","RED");
	bombCP1 = new Piece("BOMB", "BLUE");
	bombCP2 = new Piece("BOMB", "BLUE");
	bombCP3 = new Piece("BOMB", "BLUE");
	bombCP4 = new Piece("BOMB", "BLUE");
	bombCP5 = new Piece("BOMB", "BLUE");
	bombCP6 = new Piece("BOMB", "BLUE");
	bombPlayer1 = new Piece("BOMB", "RED");
	bombPlayer2 = new Piece("BOMB", "RED");
	bombPlayer3 = new Piece("BOMB", "RED");
	bombPlayer4 = new Piece("BOMB", "RED");
	bombPlayer5 = new Piece("BOMB", "RED");
	bombPlayer6 = new Piece("BOMB", "RED");
	scoutCP1 = new Piece("SCOUT", "BLUE");
	scoutCP2 = new Piece("SCOUT", "BLUE");
	scoutCP3 = new Piece("SCOUT", "BLUE");
	scoutCP4 = new Piece("SCOUT", "BLUE");
	scoutCP5 = new Piece("SCOUT", "BLUE");
	scoutCP6 = new Piece("SCOUT", "BLUE");
	scoutCP7 = new Piece("SCOUT", "BLUE");
	scoutCP8 = new Piece("SCOUT", "BLUE");
	scoutPlayer1 = new Piece("SCOUT", "RED");
	scoutPlayer2 = new Piece("SCOUT", "RED");
	scoutPlayer3 = new Piece("SCOUT", "RED");
	scoutPlayer4 = new Piece("SCOUT", "RED");
	scoutPlayer5 = new Piece("SCOUT", "RED");
	scoutPlayer6 = new Piece("SCOUT", "RED");
	scoutPlayer7 = new Piece("SCOUT", "RED");
	scoutPlayer8 = new Piece("SCOUT", "RED");
	minerCP1 = new Piece("MINER", "BLUE");
	minerCP2 = new Piece("MINER", "BLUE");
	minerCP3 = new Piece("MINER", "BLUE");
	minerCP4 = new Piece("MINER", "BLUE");
	minerCP5 = new Piece("MINER", "BLUE");
	minerPlayer1 = new Piece("MINER", "RED");
	minerPlayer2 = new Piece("MINER", "RED");
	minerPlayer3 = new Piece("MINER", "RED");
	minerPlayer4 = new Piece("MINER", "RED");
	minerPlayer5 = new Piece("MINER", "RED");
	sergeantCP1 = new Piece("SERGEANT", "BLUE");
	sergeantCP2 = new Piece("SERGEANT", "BLUE");
	sergeantCP3 = new Piece("SERGEANT", "BLUE");
	sergeantCP4 = new Piece("SERGEANT", "BLUE");
	sergeantPlayer1 = new Piece("SERGEANT", "RED");
	sergeantPlayer2 = new Piece("SERGEANT", "RED");
	sergeantPlayer3 = new Piece("SERGEANT", "RED");
	sergeantPlayer4 = new Piece("SERGEANT", "RED");
	lieutenantCP1 = new Piece("LIEUTENANT", "BLUE");
	lieutenantCP2 = new Piece("LIEUTENANT", "BLUE");
	lieutenantCP3 = new Piece("LIEUTENANT", "BLUE");
	lieutenantCP4 = new Piece("LIEUTENANT", "BLUE");
	lieutenantPlayer1 = new Piece("LIEUTENANT", "RED");
	lieutenantPlayer2 = new Piece("LIEUTENANT", "RED");
	lieutenantPlayer3 = new Piece("LIEUTENANT", "RED");
	lieutenantPlayer4 = new Piece("LIEUTENANT", "RED");
	captainCP1 = new Piece("CAPTAIN", "BLUE");
	captainCP2 = new Piece("CAPTAIN", "BLUE");
	captainCP3 = new Piece("CAPTAIN", "BLUE");
	captainCP4 = new Piece("CAPTAIN", "BLUE");
	captainPlayer1 = new Piece("CAPTAIN", "RED");
	captainPlayer2 = new Piece("CAPTAIN", "RED");
	captainPlayer3 = new Piece("CAPTAIN", "RED");
	captainPlayer4 = new Piece("CAPTAIN", "RED");
	majorCP1 = new Piece("MAJOR", "BLUE");
	majorCP2 = new Piece("MAJOR", "BLUE");
	majorCP3 = new Piece("MAJOR", "BLUE");
	majorPlayer1 = new Piece("MAJOR", "RED");
	majorPlayer2 = new Piece("MAJOR", "RED");
	majorPlayer3 = new Piece("MAJOR", "RED");
	colonelCP1 = new Piece("COLONEL", "BLUE");
	colonelCP2 = new Piece("COLONEL", "BLUE");
	colonelPlayer1 = new Piece("COLONEL", "RED");
	colonelPlayer2 = new Piece("COLONEL", "RED");
	generalCP = new Piece("GENERAL", "BLUE");
	generalPlayer = new Piece("GENERAL", "RED");
	marshallCP = new Piece("MARSHALL", "BLUE");
	marshallPlayer = new Piece("MARSHALL", "RED");
	
	}
}
