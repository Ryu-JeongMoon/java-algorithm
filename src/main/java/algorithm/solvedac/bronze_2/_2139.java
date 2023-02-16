package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 나는 너가 살아온 날을 알고 있다
 */
public class _2139 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    int[][] daysOfMonth = {
      { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
      { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
    };
    while (!(line = br.readLine()).equals("0 0 0")) {
      String[] s = line.split(" ");
      int d = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), y = Integer.parseInt(s[2]), days = 0;
      int isLeapYear = isLeapYear(y) ? 1 : 0;
      for (int i = 0; i < m - 1; i++) {
        days += daysOfMonth[isLeapYear][i];
      }
      bw.write(days + d + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static boolean isLeapYear(int year) {
    return (year & 3) == 0 && (year % 100) != 0 || (year % 400) == 0;
  }
}

/*
time complexity
O(n)

critical point
1. year % 4 == year & 3
2. 이전 달의 일수를 배열에서 찾아 더하고 현재 달의 일수 만큼 더해줌

reference
https://www.acmicpc.net/problem/2139
 */
