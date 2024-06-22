package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비트 우정지수
 */
public class _12782 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      String[] words = br.readLine().split(" ");
      int positionDiff = 0, countOfFirst = 0, countOfSecond = 0;
      for (int j = 0; j < words[0].length(); j++) {
        char first = words[0].charAt(j), second = words[1].charAt(j);
        if (first == '1') {
          ++countOfFirst;
        }
        if (second == '1') {
          ++countOfSecond;
        }
        if (first != second) {
          ++positionDiff;
        }
      }
      sb.append((Math.abs(countOfFirst - countOfSecond) + positionDiff) / 2).append('\n');
    }

    br.close();
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
(위치 차이 + 1의 개수 차이) / 2
1 개수 차이가 나는 경우 반드시 위치 차이도 발생

reference
https://www.acmicpc.net/problem/12782
*/
