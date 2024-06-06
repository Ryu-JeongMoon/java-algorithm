package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * A -> B
 */
public class _16953 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), count = 0;
    while (n < m) {
      if (m % 10 == 1) {
        m /= 10;
      } else if (m % 2 == 0) {
        m /= 2;
      } else {
        break;
      }
      ++count;
    }
    System.out.println(n == m ? count + 1 : -1);
  }
}

/*
time complexity
O(logN)

critical point
1로 나누어 떨어지지 않거나 2의 배수가 아닌 경우 무한 루프 주의

reference
https://www.acmicpc.net/problem/16953
*/
