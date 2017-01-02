package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SPYQuote {
  private static int hc = 0;
  private static SPYQuote instance = null;

  public SPYQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SPYQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SPYQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SPYQuote;
  }

  public String toString() {

    return "<SPY>";
  }
}
