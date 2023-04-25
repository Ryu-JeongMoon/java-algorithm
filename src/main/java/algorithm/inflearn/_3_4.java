package algorithm.inflearn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 피부과
 */
public class _3_4 {

  public static void main(String[] args) {
    // 3
    System.out.println(solution1(new int[]{ 30, 20, 25, 15 }, new String[]{ "10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2" }));
    System.out.println(solution2(new int[]{ 30, 20, 25, 15 }, new String[]{ "10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2" }));

    // 4
    System.out.println(solution1(new int[]{ 30, 20, 25, 15 },
      new String[]{ "10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0" }));
    System.out.println(solution2(new int[]{ 30, 20, 25, 15 },
      new String[]{ "10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0" }));

    // 0
    System.out.println(solution1(new int[]{ 30, 20, 25, 15 }, new String[]{ "10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1" }));
    System.out.println(solution2(new int[]{ 30, 20, 25, 15 }, new String[]{ "10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1" }));
  }

  public static int solution1(int[] laser, String[] enter) {
    List<Reservation> reservations = new ArrayList<>(enter.length);
    for (int i = 0; i < enter.length; i++) {
      String[] s = enter[i].split(" ");
      String[] time = s[0].split(":");
      int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
      int taskTime = laser[Integer.parseInt(s[1])];
      int end = (reservations.isEmpty() || start >= reservations.get(i - 1).end)
        ? start
        : reservations.get(i - 1).end;

      reservations.add(new Reservation(start, end, taskTime));
    }

    int maxWaitCount = 0;
    for (int i = 0; i < reservations.size() - 1; i++) {
      int checkpoint = reservations.get(i).end;
      int currentWaitCount = 0;
      int j = i + 1;
      while (j < reservations.size() && reservations.get(j++).start < checkpoint) {
        ++currentWaitCount;
      }
      maxWaitCount = Math.max(maxWaitCount, currentWaitCount);
    }
    return maxWaitCount;
  }

  public static int solution2(int[] laser, String[] enter) {
    int maxWaitCount = 0, previousEnd = 0;
    Deque<Reservation> waiting = new ArrayDeque<>();
    for (String value : enter) {
      String[] timeAndLaser = value.split(" "), time = timeAndLaser[0].split(":");
      int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
      int taskTime = laser[Integer.parseInt(timeAndLaser[1])];
      int taskStart = (waiting.isEmpty() || start >= waiting.peekLast().end)
        ? start
        : waiting.peekLast().end;

      if (previousEnd > start) {
        waiting.offer(new Reservation(start, taskStart, taskTime));
      } else {
        previousEnd = taskStart + taskTime;
      }

      while (!waiting.isEmpty() && waiting.peek().end < start) {
        waiting.poll();
      }
      maxWaitCount = Math.max(maxWaitCount, waiting.size());
    }

    return maxWaitCount;
  }

  static class Reservation {

    // 입장 시간
    int start;
    int end;
    int taskTime;

    Reservation(int start, int taskStart, int taskTime) {
      this.start = start;
      this.end = taskStart + taskTime;
      this.taskTime = taskTime;
    }
  }
}

/*
time complexity
O(n^2) - ArrayList
O(n)   - Deque

critical point
taskStart, 시술 시작 시간
대기자가 없거나 입장 시간이 이전 고객의 시술 완료 시간보다 같거나 크다면 입장 시간
대기자가 있거나 입장 시간이 이전 고객의 시술 완료 시간보다 작다면 이전 고객의 시술 완료 시간

if (previousEnd > start)
이전 작업이 끝나지 않았다면 대기 큐에 추가
이전 작업이 끝났다면 대기 큐에 추가하지 않고 이전 작업 완료 시간 갱신만 수행

while (!reservations.isEmpty() && reservations.peek().end < start)
대기자가 얼마나 있는지 구하기 전에 현재 입장한 고객 기준으로 시술이 완료된 대기자들은 큐에서 제거

reference
https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%B5%9C%EC%8B%A0%EA%B8%B0%EC%B6%9C&unitId=149920
 */