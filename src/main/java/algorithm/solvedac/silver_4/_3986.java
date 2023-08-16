package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 좋은 단어
 */
public class _3986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), count = n;
    Stack<Character> stack = new Stack<>();
    while (--n >= 0) {
      char[] chars = br.readLine().toCharArray();
      if (chars.length % 2 != 0) {
        --count;
        continue;
      }

      for (char current : chars) {
        if (!stack.isEmpty() && stack.peek() == current) {
          stack.pop();
        } else {
          stack.push(current);
        }
      }

      if (!stack.isEmpty()) {
        --count;
        stack.clear();
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(N)

critical point
단순한 전방 탐색은 ABAABA 같은 케이스 처리 불가

reference
https://www.acmicpc.net/problem/3986
*/
