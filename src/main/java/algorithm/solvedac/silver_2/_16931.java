package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 겉넓이 구하기
 */
public class _16931 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), sum = n * m * 2;
    int[][] map = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      int max = map[i][0], hiddenParts = 0;
      for (int j = 1; j < m; j++) {
        if (map[i][j - 1] < map[i][j]) {
          hiddenParts += (Math.min(map[i][j], max) - map[i][j - 1]);
        }
        max = Math.max(map[i][j], max);
      }
      sum += (max + hiddenParts) * 2;
    }

    for (int i = 0; i < m; i++) {
      int max = map[0][i], hiddenParts = 0;
      for (int j = 1; j < n; j++) {
        if (map[j - 1][i] < map[j][i]) {
          hiddenParts += (Math.min(map[j][i], max) - map[j - 1][i]);
        }
        max = Math.max(map[j][i], max);
      }
      sum += (max + hiddenParts) * 2;
    }

    System.out.println(sum);
  }
}

/*
time complexity
O(NM)

critical point
숨겨진 면 계산
이전 높이와 비교하여 (최댓값, 현재값) 중 작은 값에서 이전 높이를 뺀 값을 계속 더해줌
최댓값은 이전 높이, 현재 높이 차이 계산 후 갱신하므로
높이 차이를 구할 땐 (최댓값, 현재값) 중 작은 값으로 계산해줘야 함

reference
https://www.acmicpc.net/problem/16931
*/
