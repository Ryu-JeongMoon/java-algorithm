package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 카잉 달력
 */
public class _6064 {

  public static void main(String[] args) throws IOException {
    int t = nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int m = nextInt(), n = nextInt(), x = nextInt(), y = nextInt();
      int initial = m > n ? x : y, maxUnit = Math.max(m, n);
      x = x == m ? 0 : x;
      y = y == n ? 0 : y;
      boolean valid = false;
      for (int j = initial; j <= m * n; j += maxUnit) {
        if (j % m == x && j % n == y) {
          sb.append(j).append("\n");
          valid = true;
          break;
        }
      }
      if (!valid) {
        sb.append(-1).append("\n");
      }
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
m, n 중 더 큰 값으로 단위 값을 고정 후
m일 때 x, n일 때 y 를 초기값으로 하여 단위값만큼 증가시키며 조건에 맞는 x, y 존재하는지 확인

reference
https://www.acmicpc.net/problem/6064
*/
