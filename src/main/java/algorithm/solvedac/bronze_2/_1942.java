package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 디지털시계
 */
public class _1942 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = 3;
    while (--n >= 0) {
      String[] s = br.readLine().split(" ");
      String[] start = s[0].split(":"), end = s[1].split(":");
      int startHour = Integer.parseInt(start[0]), startMinute = Integer.parseInt(start[1]), startSecond = Integer.parseInt(start[2]);
      int endHour = Integer.parseInt(end[0]), endMinute = Integer.parseInt(end[1]), endSecond = Integer.parseInt(end[2]);
      int startTime = startHour * 10_000 + startMinute * 100 + startSecond, endTime = endHour * 10_000 + endMinute * 100 + endSecond;
      int count;
      if (startTime < endTime) {
        count = getCount(startTime, endTime);
      } else {
        count = getCount(startTime, 23_5959);
        count += getCount(0, endTime);
      }
      bw.write(count + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static int getCount(int startTime, int endTime) {
    int count = 0;
    while (startTime <= endTime) {
      int second = startTime % 100;
      if (startTime % 3 == 0) {
        while (second < 60 && startTime <= endTime) {
          count += 1;
          startTime += 3;
          second += 3;
        }
      }

      if (second == 59) {
        startTime = carry(startTime + 1);
      } else if (second > 59) {
        startTime = carry(startTime);
      } else {
        startTime += 1;
      }
    }
    return count;
  }

  private static int carry(int value) {
    value += 40;
    value -= (value % 100);
    if (value / 100 % 100 > 59) {
      value += 4_000;
    }
    return value;
  }
}

/*
time complexity
입력값의 범위에 따라 달라짐

critical point
시계 정수의 올림을 구현하는 것이 핵심

입력의 두 가지 경우의 수
1. 시작 시간이 끝 시간보다 작은 경우, 그대로 getCount() 수행
2. 시작 시간이 끝 시간보다 큰 경우, 23:59:59까지의 수행 후 00:00:00부터 끝 시간까지 범위를 나눠 수행

getCount
1. 3의 배수인 경우, 불필요하게 1초씩 증가하지 않도록 60초 전까지는 반복을 통해 3초씩 증가
2. 내부 반복에서도 시작 시간과 끝 시간의 비교가 필요
3. 59초인 경우, 분단위 올림 수행을 위해 기존 시간에 1초를 더해 전달
4. 59초를 초과한 경우 분단위 올림 후 초단위 절삭 필요
5. 올림에 해당하지 않는 경우, 단순 1초 증가

carry
1. 시간에 결합되어 분단위 올림 -> 시간 단위 올림 연속 발생 가능
2. 초단위 절삭 (62초에서 올리면 02초가 아닌 00초가 되어야 함, 02초로 올린다면 3의 배수 값 누락 발생 가능)
3. 시간단위 올림, 초에 의한 올림이므로 분단위 절삭은 필요하지 않음

reference
https://www.acmicpc.net/problem/1942
 */