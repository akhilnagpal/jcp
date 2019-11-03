package jcp.chapter3;

import java.math.BigInteger;
import java.util.Arrays;
import net.jcip.annotations.Immutable;

@Immutable
public final class OneValueCache {
  private final BigInteger lastNumber;
  private final BigInteger[] lastFactors;

  public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
    super();
    this.lastNumber = lastNumber;
    this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
  }

  public BigInteger[] getLastFactors(BigInteger number) {
    if (number == null || !number.equals(lastNumber)) {
      return null;
    }
    return Arrays.copyOf(lastFactors, lastFactors.length);
  }
}
