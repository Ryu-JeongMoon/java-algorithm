package algorithm.solvedac.silver_3;

import static algorithm.util.PrimeUtils.isPrime;
import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 소수 구하기
 */
public class _1929 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    StringBuilder sb = new StringBuilder();
    if (n < 3) {
      sb.append(2).append('\n');
    }

    n = n % 2 == 0 ? n + 1 : n;
    for (int i = n; i < m + 1; i += 2) {
      if (isPrime(i)) {
        sb.append(i).append('\n');
      }
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(m * sqrt(n))

critical point
매번 소수 판별을 해야 하므로 비효율적
n이 2인 경우를 별도 처리하지 않고 포함시켜 처리할 수 없을지?

reference
https://www.acmicpc.net/problem/1929
*/
