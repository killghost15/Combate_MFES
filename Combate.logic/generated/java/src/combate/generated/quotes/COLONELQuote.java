package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class COLONELQuote {
  private static int hc = 0;
  private static COLONELQuote instance = null;

  public COLONELQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static COLONELQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new COLONELQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof COLONELQuote;
  }

  public String toString() {

    return "<COLONEL>";
  }
}
