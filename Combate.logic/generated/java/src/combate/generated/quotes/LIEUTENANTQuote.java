package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LIEUTENANTQuote {
  private static int hc = 0;
  private static LIEUTENANTQuote instance = null;

  public LIEUTENANTQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LIEUTENANTQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LIEUTENANTQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LIEUTENANTQuote;
  }

  public String toString() {

    return "<LIEUTENANT>";
  }
}
