package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 요세푸스 문제 0
 */
public class _11866 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt(), rotatingIndex = 0;
    boolean[] visited = new boolean[n];
    StringBuilder sb = new StringBuilder("<");
    for (int i = 0; i < n; i++) {
      int counter = 0;
      while (visited[rotatingIndex % n] || ++counter != k) {
        rotatingIndex = (rotatingIndex + 1) % n;
      }
      visited[rotatingIndex] = true;
      sb.append(++rotatingIndex).append(", ");
    }
    System.out.println(sb.delete(sb.length() - 2, sb.length()).append(">"));
  }
}

/*
time complexity
O(N^2)

critical point

reference
https://www.acmicpc.net/problem/11866
*/
