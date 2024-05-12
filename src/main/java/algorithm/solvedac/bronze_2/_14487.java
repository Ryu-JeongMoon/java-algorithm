package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 욱제는 효도쟁이야!!
 */
public class _14487 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), sum = 0, max = 0;
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      sum += current;
      max = Math.max(max, current);
    }
    System.out.println(sum - max);
  }
}

/*
time complexity
O(N)

critical point
가장 비싼 경로 제외

reference
https://www.acmicpc.net/problem/14487
*/
