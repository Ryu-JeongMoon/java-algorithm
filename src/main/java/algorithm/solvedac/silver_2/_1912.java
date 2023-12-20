package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 연속합
 */
public class _1912 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative(), sum = 0, max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int current = nextIntWithNegative();
      sum = Math.max(sum + current, current);
      max = Math.max(max, sum);
    }
    System.out.println(max);
  }
}

/*
time complexity
O(n)

critical point
현재 값이 이전 값들의 합보다 큰 경우, 이전 값들의 합을 버림
테스트 케이스가 아래와 같을 때 3은 1 + -2 + 3 보다 크므로
이전 값들의 합은 어떠한 경우에도 현재 값부터 시작해 더해나가는 값보다 커질 수 없다
5
1  -2  3  -4  5
-> -> -> ...
      -> ...

수열의 값 중 단건이 최댓값인 경우 혹은 현재 값을 포함하지 않는 값을 위해 max 사용
아래의 경우 첫번째 값이 최댓값이며 sum, current 비교로는 최댓값을 구할 수 없음
5
10 -7 0 -6 3

아래의 경우 두번째, 세번째 값의 합이 최댓값
5
-3 2 10 -5 -8

reference
https://www.acmicpc.net/problem/1912
*/
