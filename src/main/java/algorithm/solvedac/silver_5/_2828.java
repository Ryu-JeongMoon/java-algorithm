package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사과 담기 게임
 */
public class _2828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine().split(" ")[1]);
    int total = Integer.parseInt(br.readLine());
    int left = 1, right = left + (m - 1), distance = 0;
    for (int i = 0; i < total; i++) {
      int next = Integer.parseInt(br.readLine());
      if (next < left) {
        distance += (left - next);
        left = next;
        right = left + (m - 1);
      } else if (next > right) {
        distance += (next - right);
        right = next;
        left = right - (m - 1);
      }
    }
    System.out.println(distance);
  }
}

/*
time complexity
O(n)

critical point
바구니의 범위를 선언

reference
https://www.acmicpc.net/problem/2828
*/
