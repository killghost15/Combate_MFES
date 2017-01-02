package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  public static final Number TOTAL_PIECES = 40L;
  private Number player = 0L;
  private Number totalPieces = Player.TOTAL_PIECES;
  private Number unplayedPieces = Player.TOTAL_PIECES;
  private VDMSeq pieces = SeqUtil.seq();

  public void cg_init_Player_1(final Number pl) {

    player = pl;
  }

  public Player(final Number pl) {

    cg_init_Player_1(pl);
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
