package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 국영수
 */
public class _10825 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    Student[] students = new Student[io.nextInt()];
    for (int i = 0; i < students.length; i++) {
      students[i] = new Student(io.readString(), io.nextInt(), io.nextInt(), io.nextInt());
    }
    Arrays.sort(students);
    for (Student student : students) {
      io.writeln(student.name);
    }
    io.flushAndClose();
  }

  private static class Student implements Comparable<Student> {

    private final String name;
    private final int korean;
    private final int english;
    private final int math;

    private Student(String name, int korean, int english, int math) {
      this.name = name;
      this.korean = korean;
      this.english = english;
      this.math = math;
    }

    @Override
    public int compareTo(Student o) {
      return this.korean != o.korean ? o.korean - this.korean
        : this.english != o.english ? this.english - o.english
        : this.math != o.math ? o.math - this.math
        : this.name.compareTo(o.name);
    }
  }
}

/*
time complexity
O(NlogN)

critical point
정렬 조건

reference
https://www.acmicpc.net/problem/10825
*/
