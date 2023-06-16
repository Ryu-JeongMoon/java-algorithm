package algorithm.programmers.level2;

/**
 * 문자열 압축
 */
public class _60057 {

  public static void main(String[] args) {
    _60057 instance = new _60057();
    System.out.println(instance.solution("aabbaccc"));
    System.out.println(instance.solution("ababcdcdababcdcd"));
    System.out.println(instance.solution("abcabcdede"));
    System.out.println(instance.solution("abcabcabcabcdededededede"));
    System.out.println(instance.solution("xababcdcdababcdcd"));
    System.out.println(instance.solution("a"));
    System.out.println(instance.solution("aaaaa"));
    System.out.println(instance.solution("aaaaaaaaaa"));
    System.out.println(instance.solution("acacacbacacac"));
  }

  public int solution(String s) {
    int length = s.length();
    int answer = length;
    for (int i = 1; i < length / 2 + 1; i++) {
      answer = Math.min(answer, process(s, i));
    }
    return answer;
  }

  private int process(String input, int unit) {
    String previous = "", substring;
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 0; i < input.length() + unit; i += unit) {
      if (i + unit <= input.length()) {
        substring = input.substring(i, i + unit);
      } else if (i <= input.length() - 1) {
        substring = input.substring(i);
      } else {
        substring = "";
      }

      if (previous.equals(substring)) {
        ++count;
      } else if (count != 1) {
        sb.append(count).append(previous);
        previous = substring;
        count = 1;
      } else {
        sb.append(previous);
        previous = substring;
      }
    }
    return sb.length();
  }
}

/*
time complexity
O(n^2)

critical point
1. for (int i = 0; i < input.length() + unit; i += unit)
반복되는 문자들의 count prefix 더해주기 위해 check-and-act pattern 동작
input.length() 까지 반복해서는 안 되고 i가 input.length() - 1를 초과하더라도
previous로 저장한 값을 더해줘야해서 input.length() + unit 까지 반복해야 함

2. i <= input.length() - 1
input.substring(i) 사용하기 위해선 위 조건을 만족해야 함

3. process 메서드 반복문 내 첫번째 조건 검사의 else 조건
i > input.length() 이더라도 마지막으로 저장된 previous 값을 더해주기 위함

reference
https://programmers.co.kr/learn/courses/30/lessons/60057
*/
