package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 부호
 */
public class _1247 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = 3;
    while (t-- > 0) {
      BigInteger sum = BigInteger.ZERO;
      int n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        long value = Long.parseLong(br.readLine());
        sum = sum.add(BigInteger.valueOf(value));
      }
      int i = sum.compareTo(BigInteger.ZERO);
      if (i == 0) {
        sb.append("0").append("\n");
      } else if (i > 0) {
        sb.append("+").append("\n");
      } else {
        sb.append("-").append("\n");
      }
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(n)

critical point
Long.MAX_VALUE -> 9223372036854775807 범위 주의
범위 초과 가능성이 있으므로 BigInteger 사용, 성능 처참
 */
