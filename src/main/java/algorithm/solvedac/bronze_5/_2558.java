package algorithm.solvedac.bronze_5;

import java.io.IOException;

/**
 * A+B - 2
 */
public class _2558 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() + nextInt());
  }

  public static int nextInt() throws IOException {
    int sum = 0, input;
    while ((input = System.in.read()) >= '0') {
      sum = (sum * 10) + input - '0';
    }
    return sum;
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/2558
*/
