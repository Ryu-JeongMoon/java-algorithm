package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 슬라임 합치기
 */
public class _14241 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), current = 0, sum = 0;
    for (int i = 0; i < n; i++) {
      int input = nextInt();
      sum += (current * input);
      current += input;
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(n)

critical point
어떤 순서로 합쳐도 동일한 결과

reference
https://www.acmicpc.net/problem/14241
*/
