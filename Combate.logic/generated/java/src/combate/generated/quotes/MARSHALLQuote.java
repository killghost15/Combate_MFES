package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MARSHALLQuote {
  private static int hc = 0;
  private static MARSHALLQuote instance = null;

  public MARSHALLQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MARSHALLQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MARSHALLQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MARSHALLQuote;
  }

  public String toString() {

    return "<MARSHALL>";
  }
}
