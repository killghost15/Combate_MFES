package combate.generated.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MINERQuote {
  private static int hc = 0;
  private static MINERQuote instance = null;

  public MINERQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MINERQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MINERQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MINERQuote;
  }

  public String toString() {

    return "<MINER>";
  }
}
