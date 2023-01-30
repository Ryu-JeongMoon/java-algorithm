package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 평균은 넘겠지
 */
public class _4344 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < c; i++) {
      String[] line = br.readLine().split(" ");
      int theNumberOfStudent = Integer.parseInt(line[0]);
      int[] scores = new int[theNumberOfStudent];

      int sum = 0;
      for (int j = 0; j < theNumberOfStudent; j++) {
        int score = Integer.parseInt(line[j + 1]);
        scores[j] = score;
        sum += score;
      }

      int theNumberOfStudentAboveAverage = 0;
      int average = sum / theNumberOfStudent;
      for (int j = 0; j < theNumberOfStudent; j++) {
        if (scores[j] > average)
          theNumberOfStudentAboveAverage++;
      }

      sb.append(String.format("%.3f", (theNumberOfStudentAboveAverage * 100 / (float) theNumberOfStudent))).append("%\n");
    }

    System.out.println(sb);
  }
}
