package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 라디오
 */
public class _3135 {

  public static void main(String[] args) throws IOException {
    int a = nextInt(), b = nextInt(), manual = Math.abs(a - b), count = manual;
    int theNumberOfPredefined = nextInt();
    for (int i = 0; i < theNumberOfPredefined; i++) {
      count = Math.min(Math.abs(nextInt() - b), count);
    }
    System.out.println(count == manual ? count : count + 1);
  }
}

/*
time complexity
O(N)

critical point
1. A -> B 수동 이동
2. A -> 특정 주파수 -> B 이동

reference
https://www.acmicpc.net/problem/3135
*/
