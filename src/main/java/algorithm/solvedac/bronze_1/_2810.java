package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 컵홀더
 */
public class _2810 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), count = 1, index = 0;
    String seat = br.readLine();
    while (index < seat.length()) {
      if (seat.charAt(index++) == 'L') {
        ++index;
      }
      ++count;
    }
    System.out.println(Math.min(count, n));
  }
}

/*
time complexity
O(N)

critical point
기본적으로 index 1이 증가해야 하므로 비교 시 후위 연산으로 +1
L이 나오면 index 1이 추가 증가해야 하므로 전위 연산으로 +1

reference
https://www.acmicpc.net/problem/2810
 */
