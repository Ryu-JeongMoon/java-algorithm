package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 게임을 만든 동준이
 */
public class _2847 {

  public static void main(String[] args) throws IOException {
    int[] level = new int[nextInt()];
    for (int i = 0; i < level.length; i++) {
      level[i] = nextInt();
    }
    int count = 0;
    for (int i = level.length - 1; i > 0; i--) {
      while (level[i] <= level[i - 1]) {
        --level[i - 1];
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
오름차순 정렬을 위해 역순 순회

reference
https://www.acmicpc.net/problem/2847
*/
