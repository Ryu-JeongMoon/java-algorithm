package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class SortByNoCriteria {

  public static void main(String[] args) {
    String[] strings = new String[]{ "sun", "bed", "car" };
    System.out.println(Arrays.toString(solution(strings, 1)));

    String[] strings2 = new String[]{ "abce", "abcd", "cdx" };
    System.out.println(Arrays.toString(solution(strings2, 2)));

    String[] strings3 = new String[]{ "ae", "be", "ce", "ae" };
    System.out.println(Arrays.toString(solution(strings3, 1)));

    String[] strings4 = new String[]{ "abzcd", "cdzab", "abzfg", "abzaa", "abzbb", "bbzaa" };
    System.out.println(Arrays.toString(solution(strings4, 2)));
  }

  static String[] solution(String[] strings, int n) {
    Arrays.sort(strings);
    Arrays.sort(strings, Comparator.comparing(s -> s.substring(n, n + 1)));
    return strings;
  }
}

/*
substring() 으로 짤랐을 때 뒤쪽까지 기준으로 해서 정렬이 되는데
문제 풀이에서 의도한 바는 딱 n번째 문자 기준으로 정렬이므로 아다리가 안 맞았던 것
 */
