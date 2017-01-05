package combate.logic;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  private Number player = 0L;
  private Object color;

  public void cg_init_Player_1(final Number pl, final Object color1) {

    player = pl;
    color = color1;
  }

  public Player(final Number pl, final Object color1) {

    cg_init_Player_1(pl, color1);
  }

  public Player() {}

  public String toString() {

    return "Player{"
        + "player := "
        + Utils.toString(player)
        + ", color := "
        + Utils.toString(color)
        + "}";
  }
}
