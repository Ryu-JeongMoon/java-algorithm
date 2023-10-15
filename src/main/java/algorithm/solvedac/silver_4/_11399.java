package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * ATM
 */
public class _11399 {

  public static void main(String[] args) throws IOException {
    int[] times = new int[nextInt()];
    for (int i = 0; i < times.length; i++) {
      times[i] = nextInt();
    }
    Arrays.sort(times);
    int cache = 0, min = 0;
    for (int time : times) {
      cache += time;
      min += cache;
    }
    System.out.println(min);
  }
}

/*
time complexity
O(NlogN)

critical point
누적 합의 누적 합

reference
https://www.acmicpc.net/problem/11399
*/
