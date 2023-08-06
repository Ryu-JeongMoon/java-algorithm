package algorithm.solvedac.bronze_2;

import java.io.IOException;
import java.util.LinkedList;

/**
 * 줄 세우기
 */
public class _2605 {

  public static void main(String[] args) throws IOException {
    int total = nextInt();
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < total; i++) {
      queue.add(i - nextInt(), i + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer i : queue) {
      sb.append(i).append(' ');
    }
    System.out.println(sb);
  }

  private static int nextInt() throws IOException {
    int sum = 0;
    while (true) {
      int input = System.in.read();
      if (input == '\n' || input == ' ') {
        return sum;
      } else {
        sum = (sum * 10) + input - '0';
      }
    }
  }
}

/*
time complexity
O(N)

critical point
삽입, 삭제가 빈번할 땐 LinkedList

reference
https://www.acmicpc.net/problem/2605
*/
