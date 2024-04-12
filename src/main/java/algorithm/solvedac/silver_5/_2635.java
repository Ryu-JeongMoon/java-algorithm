package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 수 이어가기
 */
public class _2635 {

  public static void main(String[] args) throws IOException {
    int input = nextInt(), start = input / 3 * 2 + 1, end = input / 2, max = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = start; i >= end; i--) {
      int previous = input, current = i, count = 1, temp;
      while (current >= 0) {
        temp = current;
        current = previous - current;
        previous = temp;
        ++count;
      }

      if (count <= max) {
        continue;
      }
      max = count;

      sb.setLength(0);
      sb.append(max).append('\n').append(input).append(' ');

      previous = input;
      current = i;
      while (current >= 0) {
        sb.append(current).append(' ');
        temp = current;
        current = previous - current;
        previous = temp;
      }
    }

    System.out.println(sb);
  }
}

/*
time complexity
O(N)

critical point
입력값의 2/3 지점부터 1/2 지점까지의 수열 생성
빠른 계산을 위해 count 값을 먼저 구한 후, max 값과 비교하여 클 때만 문자열 생성

reference
https://www.acmicpc.net/problem/2635
*/
