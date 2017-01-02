package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BOMBQuote {
  private static int hc = 0;
  private static BOMBQuote instance = null;

  public BOMBQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BOMBQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BOMBQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BOMBQuote;
  }

  public String toString() {

    return "<BOMB>";
  }
}
