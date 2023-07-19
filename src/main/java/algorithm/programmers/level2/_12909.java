package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 올바른 괄호
 */
public class _12909 {

  private static final char OPEN = '(';

  public static void main(String[] args) {
    _12909 instance = new _12909();
    System.out.println(instance.solution("()()"));
    System.out.println(instance.solution("(())()"));
    System.out.println(instance.solution(")()("));
    System.out.println(instance.solution("(()("));
  }

  boolean solution(String s) {
    int length = s.length();
    if (length % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < length; i++) {
      char current = s.charAt(i);
      if (current == OPEN) {
        if (stack.size() == length / 2) {
          return false;
        } else {
          stack.push(current);
        }
      } else if (stack.isEmpty()) {
        return false;
      } else {
        stack.pop();
      }
    }

    return stack.isEmpty();
  }
}

/*
time complexity
O(N)

critical point
ArrayBlockQueue 사용 시 시간 초과 발생

다음과 같은 케이스에는 false early return
1. Stack 사용 시 Stack 빈 경우
2. int 사용 시 int 음수가 되는 경우

reference
https://programmers.co.kr/learn/courses/30/lessons/12909
*/
