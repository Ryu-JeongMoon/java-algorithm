package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 배열 복원하기
 */
public class _16967 {

  public static void main(String[] args) throws IOException {
    int h = nextInt(), w = nextInt(), x = nextInt(), y = nextInt();
    int[][] a = new int[h][w], b = new int[h + x][w + y];
    for (int i = 0; i < h + x; i++) {
      for (int j = 0; j < w + y; j++) {
        b[i][j] = nextInt();
      }
    }

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (i >= x && j >= y) {
          a[i][j] = b[i][j] - a[i - x][j - y];
        } else {
          a[i][j] = b[i][j];
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int[] ints : a) {
      for (int anInt : ints) {
        sb.append(anInt).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(h * w)

critical point
b
1 2    3    0
4 5(1) 6(2) 0(3)
7 8(4) 9(5) 0(6)
0 0(7) 0(8) 0(9)

a
1 2    3
4 5(1) 6(2)
7 8(4) 9(5)

5, 6, 8, 9에 위치한 값만 계산해 주면 됨

reference
https://www.acmicpc.net/problem/16967
*/
