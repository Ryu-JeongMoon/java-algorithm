package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 불사조
 */
public class _31780 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() * (nextInt() + 1));
  }
}

/*
time complexity
O(1)

critical point
count 만큼 x가 반복

reference
https://www.acmicpc.net/problem/31780
*/
