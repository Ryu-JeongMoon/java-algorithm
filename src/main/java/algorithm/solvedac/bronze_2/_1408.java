package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 24
 */
public class _1408 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] current = br.readLine().split(":"), mission = br.readLine().split(":");
    int currentInSeconds = Integer.parseInt(current[0]) * 3600 + Integer.parseInt(current[1]) * 60 + Integer.parseInt(current[2]);
    int missionInSeconds = Integer.parseInt(mission[0]) * 3600 + Integer.parseInt(mission[1]) * 60 + Integer.parseInt(mission[2]);
    if (currentInSeconds > missionInSeconds) {
      missionInSeconds += 24 * 3600;
    }
    int result = Math.abs(currentInSeconds - missionInSeconds);
    int hour = result / 3600, minute = (result % 3600) / 60, second = result % 60;
    System.out.printf("%02d:%02d:%02d", hour, minute, second);
  }
}

/*
time complexity
O(1)

critical point
1. 현재 시간 > 임무 시간인 경우, 임무 시간에 24시간을 더한 후 차를 구한다
2. 현재 시간 < 임무 시간인 경우, 그대로 차를 구한다
두 시간 간의 차이를 구하는 것이 아닌 현재 시간이 얼마나 흘러야 임무 시간이 되는지 구하는 문제

00:00:01
00:00:00
-> 23:59:59

23:59:59
00:00:00
-> 00:00:01

reference
https://www.acmicpc.net/problem/1408
 */
