package algorithm.util;

public class MathUtils {

  public static int gcd(int bigger, int smaller) {
    return smaller == 0 ? bigger : gcd(smaller, bigger % smaller);
  }

  public static int unorderedGcd(int a, int b) {
    return gcd(Math.max(a, b), Math.min(a, b));
  }
}
