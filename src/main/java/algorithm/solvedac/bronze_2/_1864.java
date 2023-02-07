package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 문어 숫자
 */
public class _1864 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    final ConcurrentHashMap<String, Integer> symbolsAndIndexes = new ConcurrentHashMap<String, Integer>() {{
      put("-", 0);
      put("\\", 1);
      put("(", 2);
      put("@", 3);
      put("?", 4);
      put(">", 5);
      put("&", 6);
      put("%", 7);
      put("/", -1);
    }};

    while (!(line = br.readLine()).equals("#")) {
      String[] symbols = line.split("");
      int length = symbols.length;
      int total = 0;
      for (int i = 0; i < length; i++) {
        Integer number = symbolsAndIndexes.get(symbols[i]);
        if (number == 0) {
          continue;
        }
        total += number * Math.pow(8, length - i - 1);
      }
      bw.write(total + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
java8 HashMap 초기화 시 Generic 주의!

reference
https://www.acmicpc.net/problem/1864
 */