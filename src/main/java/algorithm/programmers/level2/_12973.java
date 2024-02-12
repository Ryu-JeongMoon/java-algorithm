package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 짝지어 제거하기
 */
public class _12973 {

  public static void main(String[] args) {
    _12973 instance = new _12973();
    System.out.println(instance.solution("baabaa"));
    System.out.println(instance.solution("cdcd"));
  }

  public int solution(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (stack.isEmpty() || stack.peek() != current) {
        stack.push(current);
      } else {
        stack.pop();
      }
    }
    return stack.isEmpty() ? 1 : 0;
  }
}

/*
time complexity
O(N)

critical point
짝 맞추기는 Stack 사용

reference
https://school.programmers.co.kr/learn/courses/30/lessons/12973
*/
