package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 빈도 정렬
 */
public class _2910 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = nextInt();
    HashMap<Integer, Struct> structs = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int input = nextInt();
      Struct struct = structs.getOrDefault(input, new Struct(i, 0));
      ++struct.frequency;
      structs.put(input, struct);
    }

    StringBuilder sb = new StringBuilder();
    structs.entrySet().stream()
      .sorted(Map.Entry.comparingByValue())
      .forEach(e -> {
        int key = e.getKey(), frequency = e.getValue().frequency;
        for (int i = 0; i < frequency; i++) {
          sb.append(key).append(" ");
        }
      });
    System.out.println(sb);
  }

  private static class Struct implements Comparable<Struct> {

    private int order, frequency;

    private Struct(int order, int frequency) {
      this.order = order;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(Struct o) {
      return o.frequency - this.frequency != 0
        ? o.frequency - this.frequency
        : this.order - o.order;
    }
  }
}

/*
time complexity
O(NlogN)

critical point
Comparable의 이해

reference
https://www.acmicpc.net/problem/2910
*/
