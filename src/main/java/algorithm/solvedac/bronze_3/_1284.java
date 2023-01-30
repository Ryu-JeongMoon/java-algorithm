package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 집 주소
 */
public class _1284 {

  private static final int[] INTERVAL = { 4, 2, 3 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      int sum = 0;
      char[] chars = br.readLine().toCharArray();
      if (chars.length == 1 && chars[0] == '0') {
        break;
      }

      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == '0') {
          sum += INTERVAL[0];
        } else if (chars[i] == '1') {
          sum += INTERVAL[1];
        } else {
          sum += INTERVAL[2];
        }

        if (i != chars.length - 1) {
          sum += 1;
        }
      }

      sb.append(sum + 2).append("\n");
    }

    System.out.print(sb);
  }
}

/*
time complexity
입력값 마다 for-loop 돌려야 하므로 O(n)

critical point
0, 1과 나머지 숫자들의 여백이 다름, 양 옆으로 1씩 간격 더해줘야 함

각 숫자 사이 -> 1cm, 1은 2cm, 0은 4cm, 나머지 숫자 3cm, 양 옆으로 1cm

120 -> 13
5611 -> 15
100 -> 14
0 -> X
 */
