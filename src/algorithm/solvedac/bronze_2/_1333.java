package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부재중 전화
 */
public class _1333 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int n = Integer.parseInt(s[0]), l = Integer.parseInt(s[1]), d = Integer.parseInt(s[2]);
    int interval = 5, time = 0, dTime = d;
    for (int i = 0; i < n; i++) {
      time += l;
      while (dTime < time) {
        dTime += d;
      }

      if (time <= dTime && dTime < time + interval) {
        System.out.println(dTime);
        return;
      }

      time += interval;
    }

    if (time <= dTime) {
      System.out.println(dTime);
    } else {
      System.out.println(dTime + d);
    }
  }
}

/*
time complexity
노래 개수에 따라 반복 O(n)

critical point
1) 노래 개수만큼 반복
2) 0초부터 노래 시간 만큼 더 해줌
3) 현재 시간(time)에 맞춰 전화벨 시간(dTime) 조정
  ex) time 10초이고 전화벨 간격이 3초라면 dTime을 12초로 맞춰줌
  9초로 맞춘다면 9초 ~ 10초 사이에 들을 수 있으므로 이미 time 10초라 의미 없음, time 보다 같거나 큰 값으로 맞춰야 함
4) 현재 시간 (time)과 현재 시간에 맞춘 전화벨 시간(dTime) 비교
  4-1) 현재 시간이 dTime과 같거나 작고
  4-2) dTime이 현재 시간 + 간격보다 작다면 전화벨 들을 수 있음
    노래가 끝난 시점부터 바로 전화벨을 들을 수 있으므로 time <= dTime < time + interval
5) 위에 해당 사항이 없다면 다음 노래 시작 시간까지의 간격을 현재 시간에 더 해줌
6) 노래 반복 종료
  6-1) 현재 시간이 dTime과 같거나 작다면 dTime을 반환
  6-2) 현재 시간이 dTime보다 크다면 dTime에 전화벨 울리는 간격만큼 더 해줌

노래와 노래 사이에는 5초 동안 아무 노래도 들리지 않는 조용한 구간
D초에 1번씩 울리며, 한 번 울릴 때 1초동안 울린다

reference
https://www.acmicpc.net/problem/1333
 */