package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 쓰레기 수거
 */
public class _1680 {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int total = nextInt();
    while (--total >= 0) {
      int totalWeight = nextInt(), count = nextInt();
      int currentWeight = 0, distance = 0, totalDistance = 0, previousDistance = 0;
      for (int i = 0; i < count; i++) {
        distance = nextInt();
        int weight = nextInt();
        totalDistance += (distance - previousDistance);
        previousDistance = distance;

        if (totalWeight > currentWeight + weight) {
          currentWeight += weight;
        } else {
          totalDistance += (distance * 2);
          currentWeight = totalWeight == currentWeight + weight ? 0 : weight;
        }
      }
      sb.append(currentWeight == 0 ? totalDistance - distance : totalDistance + distance).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
경계 조건 주의
마지막 지점에 도착 후 쓰레기 담았을 때 용량 초과 되는 경우 or 아닌 경우로 나누어 생각
첫번째 예시는 마지막 지점에 도착 후 쓰레기 담았을 때 용량 초과 되는 경우
두번째 예시는 마지막 지점에 도착 후 쓰레기 담았을 때 용량 초과 되지 않는 경우
(이전 지점에서 쓰레기 담을 때 용량 초과 되었기 때문에 한번 비운 후 빈 상태로 마지막 지점에 도착)

1
10 3
1 9
2 9
3 9

1
10 3
1 10
2 10
3 10

reference
https://www.acmicpc.net/problem/1680
*/
