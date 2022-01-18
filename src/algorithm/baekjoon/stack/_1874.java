package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열
 */
public class _1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int currentNumber = 0;
    Stack<Integer> integers = new Stack<>();

    while (n-- > 0) {
      int input = Integer.parseInt(br.readLine());

      if (input > currentNumber) {
        for (int i = currentNumber + 1; i <= input; i++) {
          integers.push(i);
          sb.append("+\n");
        }
        currentNumber = input;
      } else if (!integers.isEmpty() && integers.peek() != input) {
        System.out.print("NO");
        return;
      }

      if (!integers.isEmpty()) {
        integers.pop();
        sb.append("-\n");
      }
    }
    System.out.print(sb);
  }
}