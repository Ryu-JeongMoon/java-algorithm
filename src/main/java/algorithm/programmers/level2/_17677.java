package algorithm.programmers.level2;

import static java.lang.Character.isAlphabetic;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 뉴스 클러스터링
 */
public class _17677 {

  public static void main(String[] args) {
    _17677 instance = new _17677();
    System.out.println(instance.solution("FRANCE", "french"));
    System.out.println(instance.solution("handshake", "shake hands"));
    System.out.println(instance.solution("aa1+aa2", "AAAA12"));
    System.out.println(instance.solution("E=M*C^2", "e=m*c^2"));
    System.out.println(instance.solution("E=M", "e=m"));
    System.out.println(instance.solution("aaabbcccccccc", "aaaabbcccc"));
  }

  public int solution(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    Queue<String> elements = new ArrayDeque<>();
    for (int i = 0; i < str1.length() - 1; i++) {
      if (isAlphabetic(str1.charAt(i)) && isAlphabetic(str1.charAt(i + 1))) {
        elements.add(str1.substring(i, i + 2));
      }
    }

    int union = elements.size(), intersection = 0;
    for (int i = 0; i < str2.length() - 1; i++) {
      if (isAlphabetic(str2.charAt(i)) && isAlphabetic(str2.charAt(i + 1))) {
        String substring = str2.substring(i, i + 2);
        if (elements.contains(substring)) {
          elements.remove(substring);
          ++intersection;
        } else {
          ++union;
        }
      }
    }

    return intersection == 0 && union == 0
      ? 65536
      : (int) (((double) intersection / union) * 65536);
  }
}

/*
time complexity
O(max(str1.length, str2.length))

critical point
다중원소의 합집합과 교집합

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17677
*/
