package algorithm.baekjoon.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 에디터
 */
public class _1406 {

  private static final Character ADD_LEFT = 'P';
  private static final Character MOVE_LEFT = 'L';
  private static final Character MOVE_RIGHT = 'D';
  private static final Character DELETE_LEFT = 'B';
  private static Stack<Character> temporary = new Stack<>();
  private static Stack<Character> editor = new Stack<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    char[] initialWord = br.readLine().toCharArray();
    for (char c : initialWord) {
      temporary.push(c);
    }

    int numberOfCommand = Integer.parseInt(br.readLine());

    for (int i = 0; i < numberOfCommand; i++) {
      st = new StringTokenizer(br.readLine());
      char command = st.nextToken().charAt(0);

      if (command == ADD_LEFT) {
        temporary.push(st.nextToken().charAt(0));
      } else if (command == MOVE_LEFT && !temporary.isEmpty()) {
        editor.push(temporary.pop());
      } else if (command == MOVE_RIGHT && !editor.isEmpty()) {
        temporary.push(editor.pop());
      } else if (command == DELETE_LEFT && !temporary.isEmpty()) {
        temporary.pop();
      }
    }

    while (!editor.isEmpty()) {
      temporary.push(editor.pop());
    }

    while (!temporary.isEmpty()) {
      editor.push(temporary.pop());
    }

    while (!editor.isEmpty()) {
      bw.write(editor.pop());
    }

    bw.flush();
    bw.close();
  }
}
