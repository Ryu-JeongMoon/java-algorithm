package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 타임머신
 */
public class _1440 {

  public static void main(String[] args) throws IOException {
    String[] times = new BufferedReader(new InputStreamReader(System.in)).readLine().split(":");
    int time1 = Integer.parseInt(times[0]);
    int time2 = Integer.parseInt(times[1]);
    int time3 = Integer.parseInt(times[2]);
    if (!isMinuteOrSecond(time1) || !isMinuteOrSecond(time2) || !isMinuteOrSecond(time3)) {
      System.out.println(0);
      return;
    }

    int count = 0;
    if (isHour(time1)) count += 2;
    if (isHour(time2)) count += 2;
    if (isHour(time3)) count += 2;
    System.out.println(count);
  }

  private static boolean isHour(int time) {
    return time > 0 && time < 13;
  }

  private static boolean isMinuteOrSecond(int time) {
    return time >= 0 && time < 60;
  }
}

/*
time complexity
O(1)

critical point
시간은 01-12
시간 표현이 가능할 때마다 읽을 수 있는 경우의 수는 2씩 증가

01:01:00
1 - 시 분 초
2 - 시 초 분
3 - 분 시 초
4 - 초 시 분

reference
https://www.acmicpc.net/problem/1440
 */
