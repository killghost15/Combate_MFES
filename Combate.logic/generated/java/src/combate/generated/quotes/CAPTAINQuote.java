package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CAPTAINQuote {
  private static int hc = 0;
  private static CAPTAINQuote instance = null;

  public CAPTAINQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CAPTAINQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CAPTAINQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CAPTAINQuote;
  }

  public String toString() {

    return "<CAPTAIN>";
  }
}
