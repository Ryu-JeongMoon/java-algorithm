package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import algorithm.util.FastIO;

/**
 * 숫자놀이
 */
public class _1755 {

  private static final Map<Character, String> numberToWord = Map.of(
    '0', "zero",
    '1', "one",
    '2', "two",
    '3', "three",
    '4', "four",
    '5', "five",
    '6', "six",
    '7', "seven",
    '8', "eight",
    '9', "nine"
  );

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int from = io.nextInt(), to = io.nextInt();
    Map<String, Integer> wordAndNumbers = new TreeMap<>();
    StringBuilder word = new StringBuilder();
    for (int i = from; i < to + 1; i++) {
      word.setLength(0);
      String current = String.valueOf(i);
      for (int j = 0; j < current.length(); j++) {
        word.append(numberToWord.get(current.charAt(j)));
      }
      wordAndNumbers.put(word.toString(), i);
    }

    int count = 0;
    for (int value : wordAndNumbers.values()) {
      io.writeInt(value);
      io.writeBuffer((byte) ' ');
      if (++count % 10 == 0) {
        io.writeBuffer((byte) '\n');
      }
    }
    io.flushAndClose();
  }
}

/*
time complexity
1 ≤ M ≤ N ≤ 99
l = current.length, 최대 길이는 2
O(N * l) => O(N)

critical point
Word 사전 순 정렬 > TreeMap

reference
https://www.acmicpc.net/problem/1755
*/
