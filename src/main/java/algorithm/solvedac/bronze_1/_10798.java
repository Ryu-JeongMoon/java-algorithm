package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 세로읽기
 */
public class _10798 {

  public static void main(String[] args) throws IOException {
    Map<Integer, StringBuilder> map = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); j++) {
        map.put(j, map.getOrDefault(j, new StringBuilder()).append(line.charAt(j)));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Integer i : map.keySet()) {
      sb.append(map.get(i));
    }
    br.close();
    System.out.println(sb);
  }
}

/*
time complexity
O(n)

critical point

reference
https://www.acmicpc.net/problem/10798
*/
