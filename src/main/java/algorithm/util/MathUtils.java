package algorithm.util;

public class MathUtils {

  public static int gcd(int bigger, int smaller) {
    return smaller == 0 ? bigger : gcd(smaller, bigger % smaller);
  }
}
