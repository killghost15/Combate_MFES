package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Combate {
  public static final VDMSeq PIECES_PER_PLAYER =
      SeqUtil.seq(6L, 1L, 1L, 2L, 3L, 4L, 4L, 4L, 5L, 8L, 1L, 1L);
  public static final VDMSeq TYPES_OF_PIECES =
      SeqUtil.seq(
          combate.generated.quotes.BOMBQuote.getInstance(),
          combate.generated.quotes.MARSHALLQuote.getInstance(),
          combate.generated.quotes.GENERALQuote.getInstance(),
          combate.generated.quotes.COLONELQuote.getInstance(),
          combate.generated.quotes.MAJORQuote.getInstance(),
          combate.generated.quotes.CAPTAINQuote.getInstance(),
          combate.generated.quotes.LIEUTENANTQuote.getInstance(),
          combate.generated.quotes.SERGEANTQuote.getInstance(),
          combate.generated.quotes.MINERQuote.getInstance(),
          combate.generated.quotes.SCOUTQuote.getInstance(),
          combate.generated.quotes.SPYQuote.getInstance(),
          combate.generated.quotes.FLAGQuote.getInstance());
  private Board board;
  private Number turn = 0L;

  public void cg_init_Combate_1() {

    board = new Board();
  }

  public Combate() {

    cg_init_Combate_1();
  }

  public Number getTurn() {

    return turn;
  }

  public void changeTurn() {

    if (Utils.equals(turn, 0L)) {
      turn = 1L;
    } else {
      turn = 0L;
    }
  }

  public Boolean validTurn() {

    Boolean orResult_9 = false;

    if (Utils.equals(turn, 0L)) {
      orResult_9 = true;
    } else {
      orResult_9 = Utils.equals(turn, 1L);
    }

    return orResult_9;
  }

  public String toString() {

    return "Combate{"
        + "PIECES_PER_PLAYER = "
        + Utils.toString(PIECES_PER_PLAYER)
        + ", TYPES_OF_PIECES = "
        + Utils.toString(TYPES_OF_PIECES)
        + ", board := "
        + Utils.toString(board)
        + ", turn := "
        + Utils.toString(turn)
        + "}";
  }
}
