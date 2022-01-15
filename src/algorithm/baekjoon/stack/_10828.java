package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 스택
 */
public class _10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    ArrayDeque<String> numbers = new ArrayDeque<>();

    int n = Integer.parseInt(br.readLine());
    String lineFeed = "\n";
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      switch (command) {
        case "push":
          numbers.push(st.nextToken());
          break;
        case "pop":
          if (numbers.isEmpty()) {
            bw.write("-1" + lineFeed);
          } else {
            bw.write(numbers.pop() + lineFeed);
          }
          break;
        case "size":
          bw.write(numbers.size() + lineFeed);
          break;
        case "empty":
          if (numbers.isEmpty()) {
            bw.write(1 + lineFeed);
          } else {
            bw.write(0 + lineFeed);
          }
          break;
        case "top":
          if (numbers.isEmpty()) {
            bw.write(-1 + lineFeed);
          } else {
            bw.write(numbers.peek() + lineFeed);
          }
          break;
      }
    }

    bw.flush();
    bw.close();
  }
}
