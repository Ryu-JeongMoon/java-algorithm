package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문자열 내 마음대로 정렬하기
 */
public class _12915 {

  public static void main(String[] args) {
    _12915 instance = new _12915();
    System.out.println(Arrays.toString(instance.solution(new String[] { "sun", "bed", "car" }, 1)));
    System.out.println(Arrays.toString(instance.solution(new String[] { "abce", "abcd", "cdx" }, 2)));
  }

  public String[] solution(String[] strings, int n) {
    Arrays.sort(strings, Comparator.comparing(s -> s,
      (s1, s2) -> s1.charAt(n) == s2.charAt(n)
        ? s1.compareTo(s2)
        : s1.charAt(n) - s2.charAt(n)));
    return strings;
  }
}

/*
time complexity
O(NlogN)

critical point
n번째 인덱스에 위치한 문자가 다를 때만 사전순 정렬 필요

reference
https://programmers.co.kr/learn/courses/30/lessons/12915
 */
