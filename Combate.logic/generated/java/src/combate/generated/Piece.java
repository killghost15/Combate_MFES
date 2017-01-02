package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Piece {
  private Object PieceType;
  private Object PieceColor;
  private Boolean onBoard = false;
  private Boolean cannotMove;
  private Boolean unlimitedRange;

  public void cg_init_Piece_1(final Object type, final Object color) {

    PieceType = type;
    PieceColor = color;
    Boolean orResult_2 = false;

    if (Utils.equals(PieceType, combate.generated.quotes.BOMBQuote.getInstance())) {
      orResult_2 = true;
    } else {
      orResult_2 = Utils.equals(PieceType, combate.generated.quotes.FLAGQuote.getInstance());
    }

    cannotMove = orResult_2;

    unlimitedRange = Utils.equals(PieceType, combate.generated.quotes.SCOUTQuote.getInstance());
    this.placePiece();
  }

  public Piece(final Object type, final Object color) {

    cg_init_Piece_1(type, color);
  }

  public void placePiece() {

    onBoard = true;
  }

  public Object getType() {

    return PieceType;
  }

  public Object getColor() {

    return PieceColor;
  }

  public Boolean canMove() {

    return !(cannotMove);
  }

  public Boolean hasUnlimitedRange() {

    return unlimitedRange;
  }

  public Piece() {}

  public String toString() {

    return "Piece{"
        + "PieceType := "
        + Utils.toString(PieceType)
        + ", PieceColor := "
        + Utils.toString(PieceColor)
        + ", onBoard := "
        + Utils.toString(onBoard)
        + ", cannotMove := "
        + Utils.toString(cannotMove)
        + ", unlimitedRange := "
        + Utils.toString(unlimitedRange)
        + "}";
  }
}
