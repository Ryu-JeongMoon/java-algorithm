package algorithm.baekjoon.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 키로거
 */
public class _5397 {

  private static final Character MOVE_LEFT = '<';
  private static final Character MOVE_RIGHT = '>';
  private static final Character DELETE_LEFT = '-';

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    Deque<Character> temporary = new ArrayDeque<>();
    Deque<Character> characters = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      for (char c : br.readLine().toCharArray()) {
        if (c == MOVE_LEFT) {
          if (!temporary.isEmpty()) {
            characters.addLast(temporary.pollLast());
          }
        } else if (c == MOVE_RIGHT) {
          if (!characters.isEmpty()) {
            temporary.addLast(characters.pollLast());
          }
        } else if (c == DELETE_LEFT) {
          if (!temporary.isEmpty()) {
            temporary.pollLast();
          }
        } else {
          temporary.addLast(c);
        }
      }

      while (!temporary.isEmpty()) {
        characters.addLast(temporary.pollLast());
      }
      while (!characters.isEmpty()) {
        bw.write(characters.pollLast());
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}