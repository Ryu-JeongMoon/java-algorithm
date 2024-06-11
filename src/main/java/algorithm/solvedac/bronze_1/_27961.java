package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextLong;

import java.io.IOException;

/**
 * 고양이는 많을수록 좋다
 */
public class _27961 {

  public static void main(String[] args) throws IOException {
    long input = nextLong(), count = 0;
    while (input > 1) {
      boolean even = input % 2 == 0;
      input = even ? input / 2 : input / 2 + 1;
      ++count;
    }
    System.out.println(input == 0 ? count : count + 1);
  }
}

/*
time complexity
O(logN)

critical point
0 -> 0
~ 2^0 -> 1
~ 2^1 -> 2
~ 2^2 -> 3
~ 2^3 -> 4
...

reference
https://www.acmicpc.net/problem/27961
*/
