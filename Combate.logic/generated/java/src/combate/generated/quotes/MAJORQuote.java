package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MAJORQuote {
  private static int hc = 0;
  private static MAJORQuote instance = null;

  public MAJORQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MAJORQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MAJORQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MAJORQuote;
  }

  public String toString() {

    return "<MAJOR>";
  }
}
