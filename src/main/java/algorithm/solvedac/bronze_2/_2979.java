package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 트럭 주차
 */
public class _2979 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    byte minTime = Byte.MAX_VALUE, maxTime = Byte.MIN_VALUE;
    byte[] times = new byte[101];
    for (byte i = 0; i < 3; i++) {
      String[] s1 = br.readLine().split(" ");
      byte start = Byte.parseByte(s1[0]), end = Byte.parseByte(s1[1]);
      for (byte j = start; j < end; j++) {
        ++times[j];
      }
      minTime = minTime > start ? start : minTime;
      maxTime = maxTime < end ? end : maxTime;
    }

    short cost = 0;
    byte a = Byte.parseByte(s[0]), b = Byte.parseByte(s[1]), c = Byte.parseByte(s[2]);
    for (byte i = minTime; i < maxTime; i++) {
      if (times[i] == 3) {
        cost += (3 * c);
      } else if (times[i] == 2) {
        cost += (2 * b);
      } else if (times[i] == 1) {
        cost += a;
      }
    }
    System.out.println(cost);
  }
}

/*
time complexity
O(n)

critical point
else if (times[i] == 1)
시간 범위가 안 겹치는 경우도 있음
아래와 같은 상황에서 위 조건이 아닌 else 를 사용하면 50-70 범위도 계산에 포함되어 오답

10 8 6
15 30
25 50
70 80

reference
https://www.acmicpc.net/problem/2979
 */
