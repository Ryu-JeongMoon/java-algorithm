package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 커트라인
 */
public class _25305 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt();
    int[] scores = new int[n];
    for (int i = 0; i < n; i++) {
      scores[i] = nextInt();
    }
    Arrays.sort(scores);
    System.out.println(scores[n - k]);
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/25305
*/
