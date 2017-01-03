package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Cell {
  private Position position;
  private Piece piece = null;
  private Boolean water = false;
  private Boolean occupied = false;

  public void cg_init_Cell_1(final Number x, final Number y) {

    position = new Position(x, y);
    water = isWater(Utils.copy(position));
  }

  public Cell(final Number x, final Number y) {

    cg_init_Cell_1(x, y);
  }

  public void setPiece(final Piece pie) {

    Piece atomicTmp_1 = pie;
    Boolean atomicTmp_2 = true;
    {
        /* Start of atomic statement */
      piece = atomicTmp_1;
      occupied = atomicTmp_2;
    } /* End of atomic statement */
  }

  public void removePiece() {

    Piece atomicTmp_3 = null;
    Boolean atomicTmp_4 = false;
    {
        /* Start of atomic statement */
      piece = atomicTmp_3;
      occupied = atomicTmp_4;
    } /* End of atomic statement */
  }

  public Boolean isOccupied() {

    Boolean orResult_4 = false;

    if (occupied) {
      orResult_4 = true;
    } else {
      orResult_4 = water;
    }

    return orResult_4;
  }

  public Piece getPiece() {

    return piece;
  }

  public Boolean isWater(final Position pos) {

    Boolean andResult_18 = false;

    Boolean orResult_5 = false;

    if (Utils.equals(pos.x, 2L)) {
      orResult_5 = true;
    } else {
      Boolean orResult_6 = false;

      if (Utils.equals(pos.x, 3L)) {
        orResult_6 = true;
      } else {
        Boolean orResult_7 = false;

        if (Utils.equals(pos.x, 6L)) {
          orResult_7 = true;
        } else {
          orResult_7 = Utils.equals(pos.x, 7L);
        }

        orResult_6 = orResult_7;
      }

      orResult_5 = orResult_6;
    }

    if (orResult_5) {
      Boolean orResult_8 = false;

      if (Utils.equals(pos.y, 4L)) {
        orResult_8 = true;
      } else {
        orResult_8 = Utils.equals(pos.y, 5L);
      }

      if (orResult_8) {
        andResult_18 = true;
      }
    }

    return andResult_18;
  }

  public Boolean getWater() {

    return water;
  }

  public Cell() {}

  public String toString() {

    return "Cell{"
        + "position := "
        + Utils.toString(position)
        + ", piece := "
        + Utils.toString(piece)
        + ", water := "
        + Utils.toString(water)
        + ", occupied := "
        + Utils.toString(occupied)
        + "}";
  }

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

      return "mk_Cell`Position" + Utils.formatFields(x, y);
    }
  }
}
