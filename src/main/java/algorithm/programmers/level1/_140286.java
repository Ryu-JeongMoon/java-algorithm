package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 가장 가까운 같은 글자
 */
public class _140286 {

  public static void main(String[] args) {
    _140286 instance = new _140286();
    System.out.println(Arrays.toString(instance.solution("banana")));
    System.out.println(Arrays.toString(instance.solution("foobar")));
  }

  public int[] solution(String s) {
    Map<Character, Integer> characterIndexes = new HashMap<>();
    int[] answer = new int[s.length()];
    for (int i = 0; i < answer.length; i++) {
      char current = s.charAt(i);
      answer[i] = characterIndexes.containsKey(current) ? i - characterIndexes.get(current) : -1;
      characterIndexes.put(current, i);
    }
    return answer;
  }
}

/*
time complexity
O(N)

critical point
동일 문자에 대한 이전 인덱스만 보관하면 됨

reference
https://school.programmers.co.kr/learn/courses/30/lessons/142086
*/
