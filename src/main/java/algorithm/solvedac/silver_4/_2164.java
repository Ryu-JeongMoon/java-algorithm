package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 카드2
 */
public class _2164 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    if (n == 1) {
      System.out.println(1);
      return;
    }

    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 4; i <= n; i += 2) {
      queue.offer(i);
    }

    if (n % 2 != 0) {
      queue.offer(2);
    } else {
      queue.offerFirst(2);
    }

    while (queue.size() != 1) {
      queue.poll();
      queue.offer(queue.poll());
    }
    System.out.println(queue.poll());
  }
}

/*
time complexity
O(N)

critical point
bitwise operation ?!

reference
https://www.acmicpc.net/problem/2164
*/
