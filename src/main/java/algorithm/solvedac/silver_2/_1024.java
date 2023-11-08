package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 수열의 합
 */
public class _1024 {

  public static void main(String[] args) throws IOException {
    int sum = nextInt(), length = nextInt(), max = Math.max(length, 100);
    StringBuilder sb = new StringBuilder();
    for (int i = length; i <= max; i++) {
      boolean isEvenLength = i % 2 == 0;
      int tempSum = isEvenLength ? (sum / i * 2 + 1) * i / 2 : sum / i * i;
      if (tempSum == sum) {
        int start = isEvenLength ? sum / i - i / 2 + 1 : sum / i - i / 2;
        if (start < 0) {
          break;
        }

        int end = sum / i + i / 2;
        for (int j = start; j <= end; j++) {
          sb.append(j).append(" ");
        }
        break;
      }
    }
    System.out.println(sb.isEmpty() ? -1 : sb);
  }
}

/*
time complexity
O(N)

critical point
median 구한 후, median 기준 좌우 합 구하기
홀수 vs 짝수 경우의 수 나눠야 함
홀수 -> median * length == sum
짝수 -> (median + (median + 1)) * length / 2 == sum

18 / 3 = 6
5 6 7

18 / 4 = 4
3 4 5 6

reference
https://www.acmicpc.net/problem/1024
*/
