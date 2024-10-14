package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 진법 변환 2
 */
public class _11005 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), b = nextInt();
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int remainder = n % b;
      if (remainder >= 10) {
        remainder += 'A' - 10;
      } else {
        remainder += '0';
      }
      sb.append((char) remainder);
      n /= b;
    }
    System.out.println(sb.reverse());
  }
}

/*
time complexity
O(logN)

critical poi

reference
https://www.acmicpc.net/problem/11005
*/
