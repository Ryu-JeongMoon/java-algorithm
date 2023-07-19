package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 괄호 회전하기
 */
public class _76502 {

  public static void main(String[] args) {
    _76502 instance = new _76502();
    System.out.println(instance.solution("[](){}"));
    System.out.println(instance.solution("}]()[{"));
    System.out.println(instance.solution("[)(]"));
    System.out.println(instance.solution("}}}"));
    System.out.println(instance.solution("({"));
    System.out.println(instance.solution("(("));
    System.out.println(instance.solution("{(})"));
  }

  public int solution(String s) {
    if (s.length() % 2 != 0) {
      return 0;
    }

    Stack<Character> stack = new Stack<>();
    int answer = 0;
    boolean isCorrect = false;
    for (int i = 0; i < s.length(); i++) {
      if (isCorrect) {
        ++answer;
      }

      isCorrect = true;
      for (int j = 0; j < s.length(); j++) {
        char current = s.charAt((i + j) % s.length());
        if (current == '(' || current == '{' || current == '[') {
          stack.push(current);
          continue;
        }

        if (stack.isEmpty() || isPair(current, stack)) {
          isCorrect = false;
          break;
        }
      }
    }

    return answer;
  }

  private boolean isPair(char current, Stack<Character> stack) {
    return (current == ')' && stack.pop() != '(')
      || (current == ']' && stack.pop() != '[')
      || (current == '}' && stack.pop() != '{');
  }
}

/*
time complexity
O(N^2)

critical point
Stack 대신 int 사용 하려 했으나 {(}) 와 같은 포개진 케이스 처리 필요

reference
https://programmers.co.kr/learn/courses/30/lessons/76502
*/
