package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 초콜릿 자르기
 */
public class _2163 {

  public static void main(String[] args) throws IOException {
    System.out.println(nextInt() * nextInt() - 1);
  }
}

/*
time complexity
O(1)

critical point
최종적으로 1x1 초콜릿만 남아야 하므로 연결되어있는 초콜릿 조각을 모두 쪼개야함

reference
https://www.acmicpc.net/problem/2163
*/
