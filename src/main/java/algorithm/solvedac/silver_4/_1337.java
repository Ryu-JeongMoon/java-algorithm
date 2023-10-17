package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 올바른 배열
 */
public class _1337 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(nextInt());
    }

    int max = 0;
    for (int i : set) {
      int start = Math.max(0, i - 4);
      for (int j = start; j <= i; j++) {
        int currentMax = 0;
        for (int k = j; k < j + 5; k++) {
          if (set.contains(k)) {
            ++currentMax;
          }
        }
        max = Math.max(max, currentMax);
      }
    }
    System.out.println(5 - max);
  }
}

/*
time complexity
O(n)

critical point
rolling window size 5
if set contains 5, check 1 ~ 9 (5-4 ~ 5+4)
1 2 3 4 5 6 7 8 9
1 2 3 4 5
  2 3 4 5 6
    3 4 5 6 7
      4 5 6 7 8
        5 6 7 8 9

reference
https://www.acmicpc.net/problem/1337
*/
