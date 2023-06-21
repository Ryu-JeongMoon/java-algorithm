package algorithm.programmers.level1;

import java.util.regex.Pattern;

/**
 * 문자열 다루기 기본
 */
public class _12918 {

  public static void main(String[] args) {
    _12918 instance = new _12918();
    System.out.println(instance.solution("a234"));
    System.out.println(instance.solution("1234"));
    System.out.println(instance.solution("12345"));
  }

  public boolean solution(String s) {
    // return Pattern.compile("\\d{4}|\\d{6}").matcher(s).matches();
    return Pattern.compile("\\d{4}(?:\\d{2})?").matcher(s).matches();
  }
}

/*
time complexity
O(1)

critical point
1. "\\d{4}|\\d{6}"
2. \d{4}(?:\d{2})?
it used non-capturing group (optional matching - 0 or 1)

reference
https://programmers.co.kr/learn/courses/30/lessons/12918
*/
