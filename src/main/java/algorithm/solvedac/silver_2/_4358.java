package algorithm.solvedac.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 생태학
 */
public class _4358 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Integer> map = new TreeMap<>();
    String name;
    int total = 0;
    while ((name = br.readLine()) != null) {
      map.put(name, map.getOrDefault(name, 0) + 1);
      ++total;
    }
    br.close();

    double denominator = total * 100d;
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      sb.append(entry.getKey())
        .append(" ")
        .append(String.format("%.4f", entry.getValue() / denominator))
        .append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
소수점 넷째자리까지 출력

reference
https://www.acmicpc.net/problem/4358
*/
