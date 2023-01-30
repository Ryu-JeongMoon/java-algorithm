package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 옥상 정원 꾸미기
 */
public class _6198 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long count = 0;
    ArrayDeque<Long> heights = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      long input = Long.parseLong(br.readLine());

      while (!heights.isEmpty())
        if (heights.peek() <= input)
          heights.pop();
        else
          break;

      count += heights.size();
      heights.push(input);
    }
    System.out.println(count);
  }
}
