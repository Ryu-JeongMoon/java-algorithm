package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import algorithm.util.FastIO;

/**
 * 베스트셀러
 */
public class _1302 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();

    Map<String, Integer> rank = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String current = io.readLine();
      rank.put(current, rank.getOrDefault(current, 0) + 1);
    }

    int max = 0;
    String bestSeller = "";
    for (Map.Entry<String, Integer> entry : rank.entrySet()) {
      int frequency = entry.getValue();
      if (frequency > max) {
        max = frequency;
        bestSeller = entry.getKey();
      } else if (frequency == max && entry.getKey().compareTo(bestSeller) < 0) {
        bestSeller = entry.getKey();
      }
    }
    io.writeln(bestSeller);
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
getOrDefault >> putIfAbsent & computeIfPresent

reference
https://www.acmicpc.net/problem/1302
*/
