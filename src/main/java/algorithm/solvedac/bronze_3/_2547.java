package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 사탕 선생 고창영
 */
public class _2547 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    while (--n >= 0) {
      br.readLine();
      BigInteger sum = BigInteger.ZERO;
      int t = Integer.parseInt(br.readLine());
      for (int j = 0; j < t; j++) {
        sum = sum.add(new BigInteger(br.readLine()));
      }
      BigInteger[] value = sum.divideAndRemainder(new BigInteger(String.valueOf(t)));
      if (value[1].equals(BigInteger.ZERO))
        sb.append("YES\n");
      else
        sb.append("NO\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
개별 사탕 개수는 10^18보다 작거나 같다, 사탕 개수의 합은 10^18을 넘어갈 수 있다

reference
https://www.acmicpc.net/problem/2547
 */
