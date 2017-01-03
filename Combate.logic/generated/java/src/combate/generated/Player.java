package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  public static final Number TOTAL_PIECES = 40L;
  private Number player = 0L;
  private Number totalPieces = Player.TOTAL_PIECES;
  private Number unplayedPieces = Player.TOTAL_PIECES;

  private VDMSet pieces = SetUtil.set();

  public void cg_init_Player_1(final Number pl) {

    player = pl;
  }

  public Player(final Number pl) {

    cg_init_Player_1(pl);
  }


  public void addPiece(final Piece p) {

    pieces = SetUtil.union(SetUtil.set(p), Utils.copy(pieces));
  }

  public VDMSet getPieces() {

    return Utils.copy(pieces);
  }

  public void eliminatePiece(final Piece p) {

    pieces = SetUtil.diff(Utils.copy(pieces), SetUtil.set(p));
  }

  public Player() {}

  public String toString() {

    return "Player{"
        + "TOTAL_PIECES = "
        + Utils.toString(TOTAL_PIECES)
        + ", player := "
        + Utils.toString(player)
        + ", totalPieces := "
        + Utils.toString(totalPieces)
        + ", unplayedPieces := "
        + Utils.toString(unplayedPieces)
        + ", pieces := "
        + Utils.toString(pieces)
        + "}";
  }
}
