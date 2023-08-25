package algorithm.util;

public class PrimeUtils {

  private PrimeUtils() {
  }

  // even numbers don't need to be checked, so start from 3 and increase by 2
  // zero and one are not prime numbers, so check it is greater than 1
  public static boolean isPrime(int n) {
    for (int i = 3; i < (int) (Math.sqrt(n) + 1); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return n > 1;
  }
}
