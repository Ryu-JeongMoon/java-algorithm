package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 미국 스타일
 */
public class _2712 {

  private static final Map<String, Pair> VALUE_PER_UNITS = new ConcurrentHashMap<>() {{
    put("kg", new Pair("lb", 2.2046));
    put("lb", new Pair("kg", 0.4536));
    put("l", new Pair("g", 0.2642));
    put("g", new Pair("l", 3.7854));
  }};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    while (--t >= 0) {
      String[] numberAndUnit = br.readLine().split(" ");
      double number = Double.parseDouble(numberAndUnit[0]);
      Pair pair = VALUE_PER_UNITS.get(numberAndUnit[1]);
      bw.write(String.format("%.4f %s\n", number * pair.getValue(), pair.getUnit()));
    }
    bw.flush();
    bw.close();
  }

  private static class Pair {

    private final String unit;
    private final Double value;

    public Pair(String unit, Double value) {
      this.unit = unit;
      this.value = value;
    }

    public String getUnit() {
      return unit;
    }

    public Double getValue() {
      return value;
    }
  }
}

/*
time complexity
O(n)

critical point
switch-case vs pair data structure
92ms vs 88ms, pair 진짜 쬐끔 빠름

reference
https://www.acmicpc.net/problem/2712
 */
