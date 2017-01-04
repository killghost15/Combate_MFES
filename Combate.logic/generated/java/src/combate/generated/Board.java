package combate.generated;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Board {
  private static final Number max_coord = 9L;
  private VDMMap board = MapUtil.map();

  public void cg_init_Board_1() {

    long toVar_2 = Board.max_coord.longValue();
    long byVar_2 = 1L;
    for (Long i = 0L; byVar_2 < 0 ? i >= toVar_2 : i <= toVar_2; i += byVar_2) {
      long toVar_1 = Board.max_coord.longValue();
      long byVar_1 = 1L;
      for (Long j = 0L; byVar_1 < 0 ? j >= toVar_1 : j <= toVar_1; j += byVar_1) {
        board =
            MapUtil.override(
                Utils.copy(board), MapUtil.map(new Maplet(new Position(i, j), new Cell(i, j))));
      }
    }
  }

  public Board() {

    cg_init_Board_1();
  }

  public Boolean validCoords(final Position position) {

    Boolean andResult_1 = false;

    if (position.x.longValue() <= Board.max_coord.longValue()) {
      if (position.y.longValue() <= Board.max_coord.longValue()) {
        andResult_1 = true;
      }
    }

    return andResult_1;
  }

  public Boolean freeSpace(final Position position) {

    return !(((Cell) Utils.get(board, position)).isOccupied());
  }

  public Boolean hasPiece(final Position position) {

    return !(Utils.equals(((Cell) Utils.get(board, position)).getPiece(), null));
  }

  public void placePiece(final Number i, final Number j, final Object type, final Object color) {

    Piece piece = new Piece(((Object) type), ((Object) color));
    ((Cell) Utils.get(board, new Position(i, j))).setPiece(piece);
  }

  public Boolean makeMove(final Position origin, final Position destination, final Object color) {

    Piece pieceOrigin = ((Cell) Utils.get(board, origin)).getPiece();
    Piece pieceDestination = ((Cell) Utils.get(board, destination)).getPiece();
    if (movePossible(
        Utils.copy(origin), Utils.copy(destination), pieceOrigin.hasUnlimitedRange())) {
      if (Utils.equals(pieceDestination, null)) {
        ((Cell) Utils.get(board, origin)).removePiece();
        ((Cell) Utils.get(board, destination)).setPiece(pieceOrigin);
        return true;

      } else {
        if (Utils.equals(pieceOrigin.getColor(), pieceDestination.getColor())) {
          return false;

        } else {
          if (Utils.equals(pieceOrigin.getType(), pieceDestination.getType())) {
            ((Cell) Utils.get(board, origin)).removePiece();
            ((Cell) Utils.get(board, destination)).removePiece();
            return true;

          } else {
            if (getInteraction(pieceOrigin, pieceDestination)) {
              ((Cell) Utils.get(board, origin)).removePiece();
              ((Cell) Utils.get(board, destination)).setPiece(pieceOrigin);
              return true;

            } else {
              ((Cell) Utils.get(board, origin)).removePiece();
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  public Boolean getInteraction(final Piece origin, final Piece destination) {

    Object originType = origin.getType();
    Object destinationType = destination.getType();
    Object quotePattern_1 = originType;
    Boolean success_1 =
        Utils.equals(quotePattern_1, combate.generated.quotes.MINERQuote.getInstance());

    if (!(success_1)) {
      Object quotePattern_2 = originType;
      success_1 = Utils.equals(quotePattern_2, combate.generated.quotes.SPYQuote.getInstance());

      if (success_1) {
        return Utils.equals(destinationType, combate.generated.quotes.MARSHALLQuote.getInstance());

      } else {
        return strongerPiece(((Object) originType), ((Object) destinationType));
      }

    } else {
      return Utils.equals(destinationType, combate.generated.quotes.BOMBQuote.getInstance());
    }
  }

  public Boolean limitPieces(final Object type, final Object color) {

    Number pieces = 0L;
    Number index = getIndex(((Object) type));
    for (Iterator iterator_2 = MapUtil.rng(Utils.copy(board)).iterator(); iterator_2.hasNext(); ) {
      Cell cell = (Cell) iterator_2.next();
      if (!(Utils.equals(cell.getPiece(), null))) {
        Boolean andResult_8 = false;

        if (Utils.equals(cell.getPiece().getType(), type)) {
          if (Utils.equals(cell.getPiece().getColor(), color)) {
            andResult_8 = true;
          }
        }

        if (andResult_8) {
          pieces = pieces.longValue() + 1L;
        }
      }
    }
    return pieces.longValue() < ((Number) Utils.get(Combate.PIECES_PER_PLAYER, index)).longValue();
  }

  public Boolean movePossible(
      final Position origin, final Position destination, final Boolean range) {

    if (range) {
      return isFreeLane(Utils.copy(origin), Utils.copy(destination));

    } else {
      if (Utils.equals(origin.x, destination.x)) {
        return Utils.equals(Utils.abs(origin.y.longValue() - destination.y.longValue()), 1L);

      } else {
        return Utils.equals(Utils.abs(origin.x.longValue() - destination.x.longValue()), 1L);
      }
    }
  }

  public Boolean isFreeLane(final Position origin, final Position destination) {

    if (Utils.equals(origin.x, destination.x)) {
      Number ternaryIfExp_1 = null;

      if (origin.y.longValue() >= destination.y.longValue()) {
        ternaryIfExp_1 = -1L;
      } else {
        ternaryIfExp_1 = 1L;
      }

      long toVar_3 = destination.y.longValue();
      long byVar_3 = ternaryIfExp_1.longValue();
      for (Long i = origin.y.longValue(); byVar_3 < 0 ? i >= toVar_3 : i <= toVar_3; i += byVar_3) {
        Boolean andResult_9 = false;

        if (!(Utils.equals(i, destination.y))) {
          if (!(Utils.equals(i, origin.y))) {
            andResult_9 = true;
          }
        }

        if (andResult_9) {
          if (((Cell) Utils.get(board, new Position(destination.x, i))).isOccupied()) {
            return false;
          }
        }
      }

    } else {
      Number ternaryIfExp_2 = null;

      if (origin.x.longValue() >= destination.x.longValue()) {
        ternaryIfExp_2 = -1L;
      } else {
        ternaryIfExp_2 = 1L;
      }

      long toVar_4 = destination.x.longValue();
      long byVar_4 = ternaryIfExp_2.longValue();
      for (Long i = origin.x.longValue(); byVar_4 < 0 ? i >= toVar_4 : i <= toVar_4; i += byVar_4) {
        Boolean andResult_10 = false;

        if (!(Utils.equals(i, destination.x))) {
          if (!(Utils.equals(i, origin.x))) {
            andResult_10 = true;
          }
        }

        if (andResult_10) {
          if (((Cell) Utils.get(board, new Position(i, destination.y))).isOccupied()) {
            return false;
          }
        }
      }
    }

    return true;
  }

  public Cell getByCoord(final Number i, final Number j) {

    return ((Cell) Utils.get(board, new Position(i, j)));
  }

  public static Number getIndex(final Object type) {

    VDMSeq seqCompResult_1 = SeqUtil.seq();
    VDMSet set_1 = SeqUtil.inds(Combate.TYPES_OF_PIECES);
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
      Number i = ((Number) iterator_1.next());
      if (Utils.equals(Utils.get(Combate.TYPES_OF_PIECES, i), type)) {
        seqCompResult_1.add(i);
      }
    }
    return ((Number) Utils.get(seqCompResult_1, 1L));
  }

  public static Boolean strongerPiece(final Object originType, final Object destinationType) {

    return getIndex(((Object) originType)).longValue()
        > getIndex(((Object) destinationType)).longValue();
  }

  public static Boolean colorRegion(final Position position, final Object color) {

    if (Utils.equals(color, combate.generated.quotes.BLUEQuote.getInstance())) {
      return position.y.longValue() < 4L;

    } else {
      return position.y.longValue() > 5L;
    }
  }

  public String toString() {

    return "Board{"
        + "max_coord = "
        + Utils.toString(max_coord)
        + ", board := "
        + Utils.toString(board)
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

      return "mk_Board`Position" + Utils.formatFields(x, y);
    }
  }
}
