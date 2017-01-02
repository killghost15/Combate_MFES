package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SCOUTQuote {
  private static int hc = 0;
  private static SCOUTQuote instance = null;

  public SCOUTQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SCOUTQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SCOUTQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SCOUTQuote;
  }

  public String toString() {

    return "<SCOUT>";
  }
}
