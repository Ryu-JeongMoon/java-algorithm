package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 필터
 */
public class _1895 {

  private static final int FILTER_SIZE = 3;
  private static final int[] ARRAY = new int[FILTER_SIZE * FILTER_SIZE];

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    int[][] image = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        image[i][j] = nextInt();
      }
    }

    int t = nextInt(), count = 0;
    for (int i = 0; i <= n - FILTER_SIZE; i++) {
      for (int j = 0; j <= m - FILTER_SIZE; j++) {
        if (t <= findMedian(image, i, j)) {
          ++count;
        }
      }
    }
    System.out.println(count);
  }

  private static int findMedian(int[][] image, int height, int width) {
    ARRAY[0] = image[height][width];
    ARRAY[1] = image[height][width + 1];
    ARRAY[2] = image[height][width + 2];
    ARRAY[3] = image[height + 1][width];
    ARRAY[4] = image[height + 1][width + 1];
    ARRAY[5] = image[height + 1][width + 2];
    ARRAY[6] = image[height + 2][width];
    ARRAY[7] = image[height + 2][width + 1];
    ARRAY[8] = image[height + 2][width + 2];
    Arrays.sort(ARRAY);
    return ARRAY[4];
  }
}

/*
time complexity
O(N^2)

critical point
입력 오류 문제는 BufferedReader 사용 해야 함
입력 시 공백이 딸려 오는 듯

reference
https://www.acmicpc.net/problem/1895
*/
