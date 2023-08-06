package algorithm.solvedac.bronze_2;

import java.io.IOException;

/**
 * 막대기
 */
public class _17608 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] heights = new int[n];
    for (int i = 0; i < heights.length; i++) {
      heights[i] = nextInt();
    }
    int max = heights[n - 1], count = 1;
    for (int i = heights.length - 2; i >= 0; i--) {
      if (heights[i] > max) {
        max = heights[i];
        ++count;
      }
    }
    System.out.println(count);
  }

  private static int nextInt() throws IOException {
    int sum = 0;
    while (true) {
      int input = System.in.read();
      if (input == '\n' || input == ' ') {
        return sum;
      } else {
        sum = (sum * 10) + input - '0';
      }
    }
  }
}

/*
time complexity
O(N)

critical point
기존 최대 높이 보다 높아야 보이니 역순 조회

reference
https://www.acmicpc.net/problem/17608
*/
