package algorithm.programmers.level1;

/**
 * 둘만의 암호
 */
public class _155662 {

  public static void main(String[] args) {
    _155662 instance = new _155662();
    System.out.println(instance.solution("aukks", "wbqd", 5));
    System.out.println(instance.solution("wbqd", "abcef", 5));
    System.out.println(instance.solution("aaaaa", "bcdef", 1));
  }

  public String solution(String s, String skip, int index) {
    if (index == 0) {
      return s;
    }

    boolean[] skipped = new boolean[26];
    for (int i = 0; i < skip.length(); i++) {
      skipped[skip.charAt(i) - 'a'] = true;
    }

    int length = s.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int current = s.charAt(i) - 'a', counter = 0;
      while (counter != index) {
        current = (current + 1) % 26;
        if (!skipped[current]) {
          ++counter;
        }
      }
      sb.append((char) (current + 'a'));
    }
    return sb.toString();
  }
}

/*
time complexity
O(N)

critical point
char -> int -> char 변환
skip 문자 제외, index 만큼 이동

reference
https://school.programmers.co.kr/learn/courses/30/lessons/155652
*/
