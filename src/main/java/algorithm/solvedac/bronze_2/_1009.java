package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분산처리
 */
public class _1009 {

  private static final int[][] VALUES = {
    { 10 },
    { 1 },
    { 2, 4, 8, 6 },
    { 3, 9, 7, 1 },
    { 4, 6, 4, 6 },
    { 5 },
    { 6 },
    { 7, 9, 3, 1 },
    { 8, 4, 2, 6 },
    { 9, 1, 9, 1 }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int numberOfCase = Integer.parseInt(br.readLine());
    while (numberOfCase-- > 0) {
      String[] numbers = br.readLine().split(" ");
      int remains = Integer.parseInt(numbers[0]) % 10;
      if (remains == 1 || remains == 5 || remains == 6 || remains == 0) {
        sb.append(VALUES[remains][0]).append("\n");
        continue;
      }

      int b = Integer.parseInt(numbers[1]);
      sb.append(VALUES[remains][(b - 1) % 4]).append("\n");
    }
    System.out.println(sb);
  }
}

/*
1 -> 1
2 -> 2, 4, 8, 6
3 -> 3, 9, 7, 1
4 -> 4, 6
5 -> 5
6 -> 6
7 -> 7, 9, 3, 1
8 -> 8, 4, 2, 6
9 -> 9, 1
10 -> 0

6
1 6
3 7
6 2
7 100
9 635
10 500
 */