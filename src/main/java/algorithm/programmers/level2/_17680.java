package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1차] 캐시
 */
public class _17680 {

  public static void main(String[] args) {
    _17680 instance = new _17680();
    System.out.println(instance.solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }));
    System.out.println(instance.solution(3, new String[] { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" }));
    System.out.println(
      instance.solution(2, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
    System.out.println(
      instance.solution(5, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome" }));
    System.out.println(instance.solution(2, new String[] { "Jeju", "Pangyo", "NewYork", "newyork" }));
    System.out.println(instance.solution(0, new String[] { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" }));
    System.out.println(instance.solution(3, new String[] { "A", "B", "C", "A", "D", "G", "A" }));
  }

  public int solution(int cacheSize, String[] cities) {
    int time = 0;
    if (cacheSize == 0) {
      return cities.length * 5;
    }

    Queue<String> queue = new LinkedList<>();
    for (String city : cities) {
      String lowerCase = city.toLowerCase();
      if (queue.contains(lowerCase)) {
        time += 1;
        queue.remove(lowerCase);
        queue.offer(lowerCase);
        continue;
      } else if (queue.size() == cacheSize) {
        queue.poll();
      }
      queue.offer(lowerCase);
      time += 5;
    }
    return time;
  }
}

/*
time complexity
O(N)

critical point
LRU의 이해

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17680
*/
