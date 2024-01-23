package algorithm.programmers.level2;

/**
 * JadenCase 문자열 만들기
 */
public class _12951 {

  public static void main(String[] args) {
    _12951 instance = new _12951();
    System.out.println(instance.solution("3people unFollowed me"));
    System.out.println(instance.solution(" for the last week"));
  }

  private String solution(String s) {
    StringBuilder sb = new StringBuilder();
    char prev = ' ';
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (prev == ' ' && Character.isAlphabetic(s.charAt(i))) {
        sb.append(Character.toUpperCase(current));
      } else {
        sb.append(Character.toLowerCase(current));
      }
      prev = current;
    }
    return sb.toString();
  }
}

/*
time complexity
O(N)

critical point
1. 공백 여러번 연속될 수 있음
2. 공백 문자로 시작될 수 있음
3. 공백 다음 문자가 알파벳인 경우만 체크하면 됨

reference
https://programmers.co.kr/learn/courses/30/lessons/12951
*/
