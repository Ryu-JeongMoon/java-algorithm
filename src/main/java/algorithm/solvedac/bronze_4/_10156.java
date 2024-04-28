package algorithm.solvedac.bronze_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 과자
 */
public class _10156 {

  public static void main(String[] args) throws IOException {
    int total = nextInt() * nextInt(), current = nextInt();
    System.out.println(current >= total ? 0 : total - current);
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/10156
*/
