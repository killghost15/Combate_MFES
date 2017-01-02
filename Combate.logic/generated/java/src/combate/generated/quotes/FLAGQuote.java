package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FLAGQuote {
  private static int hc = 0;
  private static FLAGQuote instance = null;

  public FLAGQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FLAGQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FLAGQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FLAGQuote;
  }

  public String toString() {

    return "<FLAG>";
  }
}
