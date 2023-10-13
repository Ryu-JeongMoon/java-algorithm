package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 수 이어 쓰기 1
 */
public class _1748 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), digitCount = 1, sum = 0;
    while (n > Math.pow(10, digitCount) - Math.pow(10, digitCount - 1)) {
      int diff = (int) (Math.pow(10, digitCount) - Math.pow(10, digitCount - 1));
      n -= diff;
      sum += (digitCount++ * diff);
    }
    System.out.println(sum + n * digitCount);
  }
}

/*
time complexity
O(logN)

critical point
N의 분해 과정
120
1-9     > 9
10-99   > 90
100-120 > 21

reference
https://www.acmicpc.net/problem/1748
*/
