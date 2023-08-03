package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 튜플
 */
public class _64065 {

  public static void main(String[] args) {
    _64065 instance = new _64065();
    System.out.println(Arrays.toString(instance.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    System.out.println(Arrays.toString(instance.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    System.out.println(Arrays.toString(instance.solution("{{20,111},{111}}")));
    System.out.println(Arrays.toString(instance.solution("{{123}}")));
    System.out.println(Arrays.toString(instance.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
  }

  public int[] solution(String s) {
    String[] tokens = s.substring(2, s.length() - 2).split("},\\{");
    Arrays.sort(tokens, Comparator.comparingInt(String::length));

    final int length = tokens.length;
    Set<String> visited = new HashSet<>(length);
    int[] answer = new int[length];

    for (int i = 0; i < length; i++) {
      String[] numbers = tokens[i].split(",");
      for (String numberString : numbers) {
        if (visited.add(numberString)) {
          answer[i] = Integer.parseInt(numberString);
          break;
        }
      }
    }
    return answer;
  }
}

/*
time complexity
O(NlogN)

critical point
[111, 20]은 두 가지 방법으로 표현 가능
1. {111}, {111, 20}
2. {111}, {20, 111}

reference
https://programmers.co.kr/learn/courses/30/lessons/64065
*/
