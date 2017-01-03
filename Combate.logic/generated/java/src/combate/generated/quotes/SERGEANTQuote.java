package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SERGEANTQuote {
  private static int hc = 0;
  private static SERGEANTQuote instance = null;

  public SERGEANTQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SERGEANTQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SERGEANTQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SERGEANTQuote;
  }

  public String toString() {

    return "<SERGEANT>";
  }
}
