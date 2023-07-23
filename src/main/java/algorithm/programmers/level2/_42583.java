package algorithm.programmers.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 다리를 지나는 트럭
 */
public class _42583 {

  public static void main(String[] args) {
    _42583 instance = new _42583();
    System.out.println(instance.solutionByQueue(2, 10, new int[] { 7, 4, 5, 6 }));
    System.out.println(instance.solutionByQueue(100, 100, new int[] { 10 }));
    System.out.println(instance.solutionByQueue(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
  }

  public int solution(int bridgeLength, int weight, int[] truckWeights) {
    int[] enterTimes = new int[truckWeights.length];
    int index = 0, time = 0, sum = 0;

    while (index < truckWeights.length) {
      ++time;
      for (int i = 0; i < index; i++) {
        if (enterTimes[i] != 0 && time - bridgeLength == enterTimes[i]) {
          sum -= truckWeights[i];
          break;
        }
      }

      if (sum + truckWeights[index] <= weight) {
        sum += truckWeights[index];
        enterTimes[index++] = time;
      }
    }

    return enterTimes[enterTimes.length - 1] + bridgeLength;
  }

  public int solutionByHashMap(int bridgeLength, int weight, int[] truckWeights) {
    Map<Integer, Integer> timeAndTrucks = new HashMap<>();

    int index = 0, time = 0, sum = 0;
    while (index < truckWeights.length || !timeAndTrucks.isEmpty()) {
      int enterTime = ++time - bridgeLength;
      if (timeAndTrucks.containsKey(enterTime)) {
        sum -= timeAndTrucks.get(enterTime);
        timeAndTrucks.remove(enterTime);
      }

      if (index < truckWeights.length && sum + truckWeights[index] <= weight) {
        sum += truckWeights[index];
        timeAndTrucks.put(time, truckWeights[index++]);
      }
    }

    return time;
  }

  public int solutionByQueue(int bridgeLength, int weight, int[] truckWeights) {
    Queue<Integer> queue = new LinkedList<>();
    int[] enterTimes = new int[truckWeights.length];
    int index = 0, time = 0, timeIndex = 0, sum = 0;
    while (index < truckWeights.length) {
      ++time;

      if (time - bridgeLength == enterTimes[timeIndex] && queue.peek() != null) {
        sum -= queue.poll();
        ++timeIndex;
      }

      if (sum + truckWeights[index] <= weight) {
        queue.offer(truckWeights[index]);
        sum += truckWeights[index];
        enterTimes[index++] = time;
      }
    }

    return enterTimes[enterTimes.length - 1] + bridgeLength;
  }
}

/*
solutionByArray                         solutionByHashMap                      solutionByQueue
테스트 1  〉	통과 (0.18ms, 73.4MB)     테스트 1  〉	통과 (0.91ms, 73.4MB)    테스트 1  〉	통과 (0.17ms, 76.8MB)
테스트 2  〉	통과 (2.29ms, 67.4MB)     테스트 2  〉	통과 (3.71ms, 79.6MB)    테스트 2  〉	통과 (0.94ms, 66.2MB)
테스트 3  〉	통과 (0.02ms, 75.1MB)     테스트 3  〉	통과 (0.08ms, 72.5MB)    테스트 3  〉	통과 (0.12ms, 75.8MB)
테스트 4  〉	통과 (19.99ms, 77.2MB)    테스트 4  〉	통과 (3.53ms, 83.3MB)    테스트 4  〉	통과 (1.12ms, 72.6MB)
테스트 5  〉	통과 (108.01ms, 93.2MB)   테스트  5 〉	통과 (17.21ms, 83.8MB)   테스트 5  〉	통과 (4.65ms, 74.9MB)
테스트 6  〉	통과 (39.38ms, 73.8MB)    테스트 6  〉	통과 (9.28ms, 80.9MB)    테스트 6  〉	통과 (2.49ms, 78.5MB)
테스트 7  〉	통과 (0.13ms, 76.5MB)     테스트 7  〉	통과 (0.61ms, 72.8MB)    테스트 7  〉	통과 (0.15ms, 78.2MB)
테스트 8  〉	통과 (0.08ms, 71.5MB)     테스트 8  〉	통과 (0.32ms, 79.1MB)    테스트 8  〉	통과 (0.18ms, 74.6MB)
테스트 9  〉	통과 (10.63ms, 73.2MB)    테스트 9  〉	통과 (1.77ms, 81.1MB)    테스트 9  〉	통과 (1.12ms, 76.1MB)
테스트 10 〉	통과 (0.12ms, 77.7MB)     테스트 10 〉	통과 (0.34ms, 75.5MB)    테스트 10 〉	통과 (0.19ms, 74.6MB)
테스트 11 〉	통과 (0.02ms, 75.1MB)     테스트 11 〉	통과 (0.04ms, 77.4MB)    테스트 11 〉	통과 (0.18ms, 76.1MB)
테스트 12 〉	통과 (0.66ms, 74.9MB)     테스트 12 〉	통과 (0.41ms, 74.2MB)    테스트 12 〉	통과 (0.17ms, 68MB)
테스트 13 〉	통과 (2.19ms, 73.1MB)     테스트 13 〉	통과 (0.59ms, 74.2MB)    테스트 13 〉	통과 (0.30ms, 71.3MB)
테스트 14 〉	통과 (0.02ms, 74.8MB)     테스트 14 〉	통과 (0.07ms, 73.3MB)    테스트 14 〉	통과 (0.12ms, 74.1MB)

time complexity
O(n)     : solutionByArray, solutionByQueue
O(m * n) : solutionByHashMap

critical point
빈번한 삽입 / 삭제

reference
https://programmers.co.kr/learn/courses/30/lessons/42583
*/
