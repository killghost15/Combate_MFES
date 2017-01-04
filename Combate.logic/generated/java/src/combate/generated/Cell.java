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

    pie.setPosition(position.x, position.y);
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

  public Position getPosition() {

    return Utils.copy(position);
  }

  public Boolean isOccupied() {

    Boolean orResult_2 = false;

    if (occupied) {
      orResult_2 = true;
    } else {
      orResult_2 = water;
    }

    return orResult_2;
  }

  public Piece getPiece() {

    return piece;
  }

  public Boolean isWater(final Position pos) {

    Boolean andResult_17 = false;

    Boolean orResult_3 = false;

    if (Utils.equals(pos.x, 2L)) {
      orResult_3 = true;
    } else {
      Boolean orResult_4 = false;

      if (Utils.equals(pos.x, 3L)) {
        orResult_4 = true;
      } else {
        Boolean orResult_5 = false;

        if (Utils.equals(pos.x, 6L)) {
          orResult_5 = true;
        } else {
          orResult_5 = Utils.equals(pos.x, 7L);
        }

        orResult_4 = orResult_5;
      }

      orResult_3 = orResult_4;
    }

    if (orResult_3) {
      Boolean orResult_6 = false;

      if (Utils.equals(pos.y, 4L)) {
        orResult_6 = true;
      } else {
        orResult_6 = Utils.equals(pos.y, 5L);
      }

      if (orResult_6) {
        andResult_17 = true;
      }
    }

    return andResult_17;
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
