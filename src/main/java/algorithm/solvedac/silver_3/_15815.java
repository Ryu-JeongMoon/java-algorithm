package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 천재 수학자 성필
 */
public class _15815 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char current = line.charAt(i);
      if (Character.isDigit(current)) {
        stack.push(current - '0');
        continue;
      }

      int first = stack.pop(), second = stack.pop();
      switch (current) {
        case '+':
          stack.push(first + second);
          break;
        case '-':
          stack.push(second - first);
          break;
        case '*':
          stack.push(first * second);
          break;
        case '/':
          stack.push(second / first);
          break;
        default:
          break;
      }
    }
    System.out.println(stack.pop());
  }
}

/*
time complexity
O(N)

critical point
연산 순서 주의

reference
https://www.acmicpc.net/problem/15815
*/
