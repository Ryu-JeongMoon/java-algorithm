package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 뒤에 있는 큰 수 찾기
 */
public class _154539 {

  public static void main(String[] args) {
    _154539 instance = new _154539();
    System.out.println(Arrays.toString(instance.solution(new int[] { 2, 3, 3, 5 })));
    System.out.println(Arrays.toString(instance.solution(new int[] { 9, 1, 5, 3, 6, 2 })));
  }

  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < numbers.length; i++) {
      while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    return answer;
  }
}

/*
time complexity
O(N)

critical point
Stack에 index를 저장하여 큰 수 찾기

reference
https://school.programmers.co.kr/learn/courses/30/lessons/154539
*/
