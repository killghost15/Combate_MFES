package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Piece {
  private Object PieceType;
  private Object PieceColor;
<<<<<<< HEAD
=======
  private Position position;
>>>>>>> d04c4861d7f32f4bbdecdba8d75066736c5d4379
  private Boolean onBoard = false;
  private Boolean cannotMove;
  private Boolean unlimitedRange;

  public void cg_init_Piece_1(final Object type, final Object color) {

    PieceType = type;
    PieceColor = color;
<<<<<<< HEAD
    Boolean orResult_2 = false;

    if (Utils.equals(PieceType, combate.generated.quotes.BOMBQuote.getInstance())) {
      orResult_2 = true;
    } else {
      orResult_2 = Utils.equals(PieceType, combate.generated.quotes.FLAGQuote.getInstance());
    }

    cannotMove = orResult_2;
=======
    position = new Position(-1L, -1L);
    Boolean orResult_8 = false;

    if (Utils.equals(PieceType, combate.generated.quotes.BOMBQuote.getInstance())) {
      orResult_8 = true;
    } else {
      orResult_8 = Utils.equals(PieceType, combate.generated.quotes.FLAGQuote.getInstance());
    }

    cannotMove = orResult_8;
>>>>>>> d04c4861d7f32f4bbdecdba8d75066736c5d4379

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
<<<<<<< HEAD
=======
        + ", position := "
        + Utils.toString(position)
>>>>>>> d04c4861d7f32f4bbdecdba8d75066736c5d4379
        + ", onBoard := "
        + Utils.toString(onBoard)
        + ", cannotMove := "
        + Utils.toString(cannotMove)
        + ", unlimitedRange := "
        + Utils.toString(unlimitedRange)
        + "}";
  }
<<<<<<< HEAD
=======

  public static class Position implements Record {
    public Number x;
    public Number y;

    public Position(final Number _x, final Number _y) {

      x = _x;
      y = _y;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Position)) {
        return false;
      }

      Position other = ((Position) obj);

      return (Utils.equals(x, other.x)) && (Utils.equals(y, other.y));
    }

    public int hashCode() {

      return Utils.hashCode(x, y);
    }

    public Position copy() {

      return new Position(x, y);
    }

    public String toString() {

      return "mk_Piece`Position" + Utils.formatFields(x, y);
    }
  }
>>>>>>> d04c4861d7f32f4bbdecdba8d75066736c5d4379
}
