package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 덱
 */
public class _10866 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Deque<String> deque = new ArrayDeque<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push_front":
          deque.addFirst(st.nextToken());
          break;
        case "push_back":
          deque.addLast(st.nextToken());
          break;
        case "pop_front":
          if (deque.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(deque.pollFirst() + "\n");
          }
          break;
        case "pop_back":
          if (deque.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(deque.pollLast() + "\n");
          }
          break;
        case "size":
          bw.write(deque.size() + "\n");
          break;
        case "empty":
          bw.write(deque.isEmpty() ? "1\n" : "0\n");
          break;
        case "front":
          bw.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
          break;
        case "back":
          bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
          break;
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/10866
*/
