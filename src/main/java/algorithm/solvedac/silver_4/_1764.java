package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 듣보잡
 */
public class _1764 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(tokenizer.nextToken()), m = Integer.parseInt(tokenizer.nextToken());

    Set<String> unheard = new HashSet<>();
    for (int i = 0; i < n; i++) {
      unheard.add(br.readLine());
    }

    Set<String> unseenAndUnheard = new TreeSet<>();
    for (int i = 0; i < m; i++) {
      String current = br.readLine();
      if (unheard.contains(current)) {
        unseenAndUnheard.add(current);
      }
    }

    StringBuilder sb = new StringBuilder(unseenAndUnheard.size() + "\n");
    for (String value : unseenAndUnheard) {
      sb.append(value).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 듣도 못한 명단을 미리 만들어 두고
2. 보도 못한 명단 중 듣도 못한 명단에 포함 되는 것만 선별

reference
https://www.acmicpc.net/problem/1764
*/
