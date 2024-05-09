package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캥거루 세마리2
 */
public class _11034 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = br.readLine()) != null) {
      StringTokenizer st = new StringTokenizer(line);
      int smaller = Integer.parseInt(st.nextToken()), middle = Integer.parseInt(st.nextToken()), bigger = Integer.parseInt(st.nextToken());
      int count = 0;
      while (smaller + 1 != middle || middle + 1 != bigger) {
        if ((middle - smaller) > (bigger - middle)) {
          bigger = middle;
          middle = smaller + 1;
        } else {
          smaller = middle;
          middle = bigger - 1;
        }
        ++count;
      }
      sb.append(count).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
캥거루 사이 이동할 수 있는 조건 파악

reference
https://www.acmicpc.net/problem/11034
*/
