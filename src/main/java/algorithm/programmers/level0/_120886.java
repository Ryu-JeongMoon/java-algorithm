package algorithm.programmers.level0;

import java.util.HashMap;
import java.util.Map;

/**
 * A로 B 만들기
 */
public class _120886 {

  public static void main(String[] args) {
    _120886 instance = new _120886();
    System.out.println(instance.solution1("olleh", "hello"));
    System.out.println(instance.solution1("allpe", "apple"));
    System.out.println(instance.solution2("olleh", "hello"));
    System.out.println(instance.solution2("allpe", "apple"));
  }

  public int solution1(String before, String after) {
    Map<Character, Integer> frequency = new HashMap<>();
    for (int i = 0; i < before.length(); i++) {
      char key1 = before.charAt(i);
      frequency.put(key1, frequency.getOrDefault(key1, 0) + 1);

      char key2 = after.charAt(i);
      frequency.put(key2, frequency.getOrDefault(key2, 0) + 1);
    }

    return frequency.values()
      .stream()
      .anyMatch(v -> v % 2 == 1) ? 0 : 1;
  }

  public int solution2(String before, String after) {
    int[] alphabets = new int[26];
    for (int i = 0; i < before.length(); i++) {
      ++alphabets[before.charAt(i) - 'a'];
      ++alphabets[after.charAt(i) - 'a'];
    }
    for (int alphabet : alphabets) {
      if (alphabet % 2 != 0) {
        return 0;
      }
    }
    return 1;
  }
}

/*
solution1                              solution2
테스트 1  〉	통과 (1.16ms, 71.9MB)    테스트 1  〉	통과 (0.02ms, 72MB)
테스트 2  〉	통과 (1.15ms, 77.4MB)    테스트 2  〉	통과 (0.02ms, 74.2MB)
테스트 3  〉	통과 (1.16ms, 78.7MB)    테스트 3  〉	통과 (0.04ms, 76.6MB)
테스트 4  〉	통과 (1.18ms, 73.3MB)    테스트 4  〉	통과 (0.03ms, 70.1MB)
테스트 5  〉	통과 (2.11ms, 71.6MB)    테스트 5  〉	통과 (0.08ms, 73.4MB)
테스트 6  〉	통과 (1.16ms, 80.5MB)    테스트 6  〉	통과 (0.02ms, 74MB)
테스트 7  〉	통과 (1.23ms, 75MB)      테스트 7  〉	통과 (0.03ms, 67MB)
테스트 8  〉	통과 (1.97ms, 75.2MB)    테스트 8  〉	통과 (0.04ms, 76.6MB)
테스트 9  〉	통과 (1.03ms, 73.6MB)    테스트 9  〉	통과 (0.02ms, 73.8MB)
테스트 10 〉	통과 (1.76ms, 64.4MB)    테스트 10 〉	통과 (0.06ms, 72.1MB)
테스트 11 〉	통과 (1.78ms, 80.1MB)    테스트 11 〉	통과 (0.09ms, 82.2MB)
테스트 12 〉	통과 (1.74ms, 74MB)      테스트 12 〉	통과 (0.11ms, 76.4MB)
테스트 13 〉	통과 (1.68ms, 67.7MB)    테스트 13 〉	통과 (0.04ms, 78.4MB)
테스트 14 〉	통과 (1.18ms, 73.7MB)    테스트 14 〉	통과 (0.02ms, 74.9MB)
테스트 15 〉	통과 (1.92ms, 73.3MB)    테스트 15 〉	통과 (0.04ms, 76.5MB)
테스트 16 〉	통과 (1.69ms, 77.3MB)    테스트 16 〉	통과 (0.06ms, 74MB)
테스트 17 〉	통과 (1.52ms, 76.9MB)    테스트 17 〉	통과 (0.06ms, 80.2MB)
테스트 18 〉	통과 (1.93ms, 74.6MB)    테스트 18 〉	통과 (0.10ms, 74.8MB)
테스트 19 〉	통과 (2.01ms, 69.6MB)    테스트 19 〉	통과 (0.12ms, 69.4MB)
테스트 20 〉	통과 (2.80ms, 74.9MB)    테스트 20 〉	통과 (0.14ms, 75.6MB)
테스트 21 〉	통과 (2.31ms, 75MB)      테스트 21 〉	통과 (0.08ms, 74.4MB)
테스트 22 〉	통과 (1.07ms, 74MB)      테스트 22 〉	통과 (0.02ms, 82.8MB)
테스트 23 〉	통과 (1.16ms, 74.2MB)    테스트 23 〉	통과 (0.03ms, 78MB)

time complexity
N : before.length()
solution1 : O(N)
solution2 : O(N)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/120886
*/
