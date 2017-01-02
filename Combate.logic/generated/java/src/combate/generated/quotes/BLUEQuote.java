package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BLUEQuote {
  private static int hc = 0;
  private static BLUEQuote instance = null;

  public BLUEQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BLUEQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BLUEQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BLUEQuote;
  }

  public String toString() {

    return "<BLUE>";
  }
}
