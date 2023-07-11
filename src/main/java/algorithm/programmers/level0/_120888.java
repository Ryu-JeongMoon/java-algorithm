package algorithm.programmers.level0;

import java.util.HashSet;
import java.util.Set;

/**
 * 중복된 문자 제거
 */
public class _120888 {

  public static void main(String[] args) {
    _120888 instance = new _120888();
    System.out.println(instance.solution("people"));
    System.out.println(instance.solution("We are the world"));
  }

  public String solution(String word) {
    StringBuilder sb = new StringBuilder();
    Set<Character> characters = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (!characters.contains(c)) {
        characters.add(c);
        sb.append(c);
      }
    }
    return sb.toString();
  }
}

/*
time complexity
O(N)

critical point

reference
https://programmers.co.kr/learn/courses/30/lessons/120888
*/
