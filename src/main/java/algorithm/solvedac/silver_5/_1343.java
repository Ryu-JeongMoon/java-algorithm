package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 폴리오미노
 */
public class _1343 {

  private static final int FIRST_LENGTH = 4;
  private static final String FIRST = "AAAA";
  private static final String SECOND = "BB";

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
    if (!input.contains("X")) {
      System.out.println(input);
      return;
    }

    String[] words = input.split("\\.");
    String[] result = new String[words.length];
    int index = 0;
    for (String word : words) {
      int wordLength = word.length();
      if (wordLength % 2 != 0) {
        System.out.println("-1");
        return;
      } else {
        result[index++] = replace(wordLength);
      }
    }

    String value = String.join(".", result);
    value = input.length() > value.length()
      ? value + input.substring(value.length())
      : value;
    System.out.println(value);
  }

  private static String replace(int length) {
    if (length == 2) {
      return SECOND;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(FIRST.repeat(length / FIRST_LENGTH));
    return length % FIRST_LENGTH == 2
      ? sb.append(SECOND).toString()
      : sb.toString();
  }
}

/*
time complexity
O(n.length)

critical point
예외 처리 주의
1. '.'로만 이루어져 있는 경우 ('.', 'X'로 이루어져 있으므로 .만 여러개 있을 때는 그대로 출력)
2. '.'로 문자열을 나눴을 때 길이가 홀수인 경우
3. 'X'를 FIRST or SECOND로 바꿀 때 반복을 사용하지 않고 연산을 더 빠르게 하기 위해 나눠야 함
  3-1) word 길이 / 4 -> FIRST 개수
  3-2) word 길이 % 4 == 2 -> SECOND 추가

reference
https://www.acmicpc.net/problem/1343
 */