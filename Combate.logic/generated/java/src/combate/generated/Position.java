package combate.generated;

import java.util.*;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Position {
  public Number x;
  public Number y;

  public void cg_init_Position_1(final Number i, final Number j) {

    x = i;
    y = j;
  }

  public Position(final Number i, final Number j) {

    cg_init_Position_1(i, j);
  }

  public Number getX() {

    return x;
  }

  public Number getY() {

    return y;
  }

  public Position() {}

  @Override
  public boolean equals(Object other){
	  if(other instanceof Position && this.x==((Position)other).x && this.y== ((Position)other).y)
    	  return true;
	  
	  else return false;
      
      
    
  }
  
  public String toString() {

    return "Position{" + "x := " + Utils.toString(x) + ", y := " + Utils.toString(y) + "}";
  }
}
