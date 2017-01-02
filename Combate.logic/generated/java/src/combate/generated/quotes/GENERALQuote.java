package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GENERALQuote {
  private static int hc = 0;
  private static GENERALQuote instance = null;

  public GENERALQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GENERALQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GENERALQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GENERALQuote;
  }

  public String toString() {

    return "<GENERAL>";
  }
}
