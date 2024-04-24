package algorithm.solvedac.silver_4;

import static algorithm.util.MathUtils.unorderedGcd;
import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 가로수
 */
public class _2485 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), minInterval = Integer.MAX_VALUE;
    int[] numbers = new int[n];
    int initial = numbers[0] = nextInt();
    for (int i = 1; i < n; i++) {
      numbers[i] = nextInt();
      minInterval = Math.min(minInterval, numbers[i] - numbers[i - 1]);
    }
    for (int i = 0; i < n - 1; i++) {
      minInterval = Math.min(minInterval, unorderedGcd(minInterval, numbers[i + 1] - initial));
    }
    System.out.println((numbers[n - 1] - numbers[0]) / minInterval - n + 1);
  }
}

/*
time complexity
O(N)

critical point
간격 간 최소공배수 찾기

reference
https://www.acmicpc.net/problem/2485
*/
