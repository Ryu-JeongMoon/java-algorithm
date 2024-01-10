package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 영식이의 손가락
 */
public class _1614 {

  public static void main(String[] args) throws IOException {
    int broken = nextInt(), limit = nextInt();
    long value, unit = 4;
    if (broken == 1) {
      value = 2 * limit * unit;
    } else if (broken == 5) {
      value = 2 * limit * unit + unit;
    } else {
      value = limit * unit;
      value += limit % 2 != 0 ? 5 - broken : broken - 1;
    }
    System.out.println(value);
  }
}

/*
time complexity
O(1)

critical point
범위 계산 주의...

reference
https://www.acmicpc.net/problem/1614
*/
