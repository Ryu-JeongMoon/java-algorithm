package algorithm.programmers.level2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 귤 고르기
 */
public class _138476 {

  public static void main(String[] args) {
    _138476 instance = new _138476();
    System.out.println(instance.solution(6, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
    System.out.println(instance.solution(4, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
    System.out.println(instance.solution(2, new int[] { 1, 1, 1, 1, 2, 2, 2, 3 }));
  }

  public int solution(int k, int[] tangerines) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int tangerine : tangerines) {
      map.putIfAbsent(tangerine, 0);
      map.computeIfPresent(tangerine, (key, value) -> value + 1);
    }

    int[] values = map.entrySet().stream()
      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .mapToInt(Map.Entry::getValue)
      .toArray();

    int count = 0;
    for (int value : values) {
      if (k == 0) {
        break;
      } else if (k >= value) {
        k -= value;
        ++count;
      } else {
        ++count;
        break;
      }
    }

    return count;
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://school.programmers.co.kr/learn/courses/30/lessons/138476
*/
