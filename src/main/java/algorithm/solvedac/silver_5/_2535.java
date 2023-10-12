package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 아시아 정보올림피아드
 */
public class _2535 {

  public static void main(String[] args) throws IOException {
    Student[] students = new Student[nextInt()];
    for (int i = 0; i < students.length; i++) {
      students[i] = new Student(nextInt(), nextInt(), nextInt());
    }
    Arrays.sort(students, (o1, o2) -> o2.score - o1.score);

    int[] counts = new int[students.length];
    for (int i = 0, won = 0; i < students.length && won < 3; i++, won++) {
      Student student = students[i];
      if (counts[student.country - 1] > 1) {
        --won;
        continue;
      }
      ++counts[student.country - 1];
      System.out.printf("%d %d\n", student.country, student.sequence);
    }
  }

  private static class Student {

    int country;
    int sequence;
    int score;

    public Student(int country, int sequence, int score) {
      this.country = country;
      this.sequence = sequence;
      this.score = score;
    }
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/2535
*/
