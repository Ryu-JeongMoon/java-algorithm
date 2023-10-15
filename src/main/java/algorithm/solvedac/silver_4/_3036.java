package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;
import algorithm.util.MathUtils;

/**
 * 링
 */
public class _3036 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), standard = io.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int current = io.nextInt();
      int gcd = MathUtils.gcd(Math.max(standard, current), Math.min(standard, current));
      io.writeInt(standard / gcd);
      io.writeBuffer((byte) '/');
      io.writelnInt(current / gcd);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
Greatest common divisor

reference
https://www.acmicpc.net/problem/3036
*/
