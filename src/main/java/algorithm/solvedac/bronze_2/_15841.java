package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Virus Outbreak
 */
public class _15841 {

  private static final BigInteger[] MEMOIZATION = new BigInteger[491];

  private static final String FORMAT = "Hour %d: %d cow(s) affected";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    while (!(line = br.readLine()).equals("-1")) {
      int n = Integer.parseInt(line);
      sb.append(String.format(FORMAT, n, fibonacci(n))).append("\n");
    }
    System.out.println(sb);
  }

  private static BigInteger fibonacci(int n) {
    if (n == 0 || n == 1) {
      return BigInteger.valueOf(n);
    }

    if (MEMOIZATION[n] != null) {
      return MEMOIZATION[n];
    }

    return MEMOIZATION[n] = fibonacci(n - 1).add(fibonacci(n - 2));
  }
}

/*
time complexity
O(N)

critical point
최대 490번째 피보나치 수를 구해야 하므로 BigInteger 사용

reference
https://www.acmicpc.net/problem/15841
*/
