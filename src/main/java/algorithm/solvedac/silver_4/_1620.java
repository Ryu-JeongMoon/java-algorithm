package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 나는야 포켓몬 마스터 이다솜
 */
public class _1620 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);

    String[] pocketMonsters = new String[n + 1];
    Map<String, Integer> pocketMonstersMap = new HashMap<>(n);
    for (int i = 1; i < n + 1; i++) {
      String input = br.readLine();
      pocketMonsters[i] = input;
      pocketMonstersMap.put(input, i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      String input = br.readLine();
      if (Character.isDigit(input.charAt(0))) {
        sb.append(pocketMonsters[Integer.parseInt(input)]);
      } else {
        sb.append(pocketMonstersMap.get(input));
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}

/*
time complexity
O(n)

critical point
Key, Value 둘 모두를 이용해 검색 필요

reference
https://www.acmicpc.net/problem/1620
*/
