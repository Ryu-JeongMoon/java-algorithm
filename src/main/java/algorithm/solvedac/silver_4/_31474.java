package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 양갈래 짝 맞추기
 */
public class _31474 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    long count = 1;
    for (int i = 0; i < n / 2; i++) {
      count *= (2 * i) + 1;
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
overflow 주의

reference
https://www.acmicpc.net/problem/31474
*/
