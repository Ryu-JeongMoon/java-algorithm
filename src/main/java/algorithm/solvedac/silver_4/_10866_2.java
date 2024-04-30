package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 덱
 */
public class _10866_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int front = 0, back = 0, n = Integer.parseInt(br.readLine());
    String[] backingArray = new String[n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "push_front":
          backingArray[front] = st.nextToken();
          front = front == 0 ? n - 1 : front - 1;
          break;
        case "push_back":
          back = back + 1 == n ? 0 : back + 1;
          backingArray[back] = st.nextToken();
          break;
        case "pop_front":
          if (front == back) {
            bw.write("-1\n");
          } else {
            front = front + 1 == n ? 0 : front + 1;
            bw.write(backingArray[front] + "\n");
          }
          break;
        case "pop_back":
          if (front == back) {
            bw.write("-1\n");
          } else {
            bw.write(backingArray[back] + "\n");
            back = back == 0 ? n - 1 : back - 1;
          }
          break;
        case "size":
          bw.write(front <= back ? back - front + "\n" : n - (front - back) + "\n");
          break;
        case "empty":
          bw.write(front == back ? "1\n" : "0\n");
          break;
        case "front":
          bw.write(front == back ? "-1\n" : backingArray[front == n - 1 ? 0 : front + 1] + "\n");
          break;
        case "back":
          bw.write(front == back ? "-1\n" : backingArray[back] + "\n");
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
front, back 두 연산의 내부 순서가 달라야 함
front -> insert & --
back  -> ++ & insert

reference
https://www.acmicpc.net/problem/10866
*/
