package algorithm.baekjoon.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 요세푸스 문제
 */
public class _1158 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] nAndK = br.readLine().split(" ");

    int n = Integer.parseInt(nAndK[0]);
    int k = Integer.parseInt(nAndK[1]);

    Deque<Integer> numbers = new ArrayDeque<>(n);

    for (int i = 1; i <= n; i++) {
      numbers.addLast(i);
    }

    bw.write("<");
    for (int i = 1; i <= n; i++) {
      if (i == n) {
        bw.write(numbers.pollFirst() + ">");
      } else {
        for (int j = 1; j < k; j++) {
          numbers.addLast(numbers.pollFirst());
        }
        bw.write(numbers.pollFirst() + ", ");
      }
    }
    bw.flush();
    bw.close();
  }
}