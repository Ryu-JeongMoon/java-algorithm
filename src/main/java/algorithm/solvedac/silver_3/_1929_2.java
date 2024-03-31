package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

public class _1929_2 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();

    boolean[] compositeNumbers = new boolean[m + 1];
    compositeNumbers[1] = true;

    for (int i = 4; i < m + 1; i += 2) {
      compositeNumbers[i] = true;
    }

    int end = (int) Math.sqrt(m + 1) + 1;
    for (int i = 3; i < end; i += 2) {
      if (!compositeNumbers[i]) {
        int interval = 2 * i;
        for (int j = i * i; j < m + 1; j += interval) {
          if (!compositeNumbers[j]) {
            compositeNumbers[j] = true;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = n; i <= m; i++) {
      if (!compositeNumbers[i]) {
        sb.append(i).append('\n');
      }
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(m * log(log(m)))

critical point
범위 내 배수들을 미리 계산하여 소수 판별

reference
https://www.acmicpc.net/problem/1929
*/
