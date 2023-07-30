package algorithm.programmers.level2;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 큰 수 만들기
 */
public class _42883 {

  public static void main(String[] args) {
    _42883 instance = new _42883();
    System.out.println(instance.solution("4321", 1));
    System.out.println(instance.solution("1924", 2));
    System.out.println(instance.solution("1231234", 3));
    System.out.println(instance.solution("4177252841", 4));
  }

  public String solution(String number, int k) {
    Stack<Character> stack = new Stack<>();
    int finalLength = number.length() - k;
    for (int i = 0; i < number.length(); i++) {
      char current = number.charAt(i);
      while (!stack.isEmpty() && current > stack.peek() && k-- > 0) {
        stack.pop();
      }

      if (stack.size() != finalLength) {
        stack.push(current);
      } else if (k == 0) {
        break;
      }
    }

    return stack.stream()
      .map(String::valueOf)
      .collect(Collectors.joining());
  }
}

/*
time complexity
O(N)

critical point
앞 자리가 가장 큰 수를 찾을 때까지 스택 요소 확인 후 삭제 / 삽입
삭제할 수 있는지 k--와 비교
가장 마지막 조건에 두어 while 문 내부에 k 감소 연산자 사용 안 해도 됨

reference
https://programmers.co.kr/learn/courses/30/lessons/42883
*/
