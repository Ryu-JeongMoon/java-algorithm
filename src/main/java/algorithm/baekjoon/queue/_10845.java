package algorithm.baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

/**
 * 큐
 */
public class _10845 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ArrayDeque<String> characters = new ArrayDeque<>();
    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      String command = br.readLine();
      switch (command) {
        case "pop":
          if (characters.isEmpty()) {
            bw.write("-1");
          } else {
            bw.write(characters.pollFirst());
          }
          bw.newLine();
          break;
        case "size":
          bw.write(String.valueOf(characters.size()));
          bw.newLine();
          break;
        case "empty":
          if (characters.isEmpty()) {
            bw.write("1");
          } else {
            bw.write("0");
          }
          bw.newLine();
          break;
        case "front":
          if (characters.isEmpty()) {
            bw.write("-1");
          } else {
            bw.write(characters.peekFirst());
          }
          bw.newLine();
          break;
        case "back":
          if (characters.isEmpty()) {
            bw.write("-1");
          } else {
            bw.write(characters.peekLast());
          }
          bw.newLine();
          break;
        default:
          characters.offer(command.substring(5));
          break;
      }
    }
    bw.flush();
    bw.close();
  }
}
