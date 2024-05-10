package algorithm.solvedac.bronze_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 첨탑 밀어서 부수기
 */
public class _28014 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), count = 0;
    for (int i = 0, previous = 0; i < n; i++) {
      int current = nextInt();
      if (current >= previous) {
        ++count;
      }
      previous = current;
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
바로 앞의 값보다 크거나 같은 경우만 카운트

reference
https://www.acmicpc.net/problem/28014
*/
