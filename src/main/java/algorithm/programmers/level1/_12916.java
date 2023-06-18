package algorithm.programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 */
public class _12916 {

  public static void main(String[] args) {
    _12916 instance = new _12916();
    System.out.println(instance.solution("pPoooyY"));
    System.out.println(instance.solution("Pyy"));
  }

  boolean solution(String s) {
    return 0 == s.chars().reduce(0, (acc, cur) -> switch (cur) {
      case 'p', 'P' -> acc + 1;
      case 'y', 'Y' -> acc - 1;
      default -> acc;
    });
  }
}

/*
time complexity
O(n)

critical point
switch expression in java

reference
https://programmers.co.kr/learn/courses/30/lessons/12916
*/
