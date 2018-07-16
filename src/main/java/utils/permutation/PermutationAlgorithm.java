package utils.permutation;

import java.math.BigInteger;

public interface PermutationAlgorithm {
  
  public int getMaxSupportedSize();
  
  public BigInteger getPermutationCount(int numberOfElements);
  
  public void fetchPermutation(Object[] elements, BigInteger ordinal);
}
