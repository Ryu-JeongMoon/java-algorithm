package algorithm.solvedac.bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모음의 개수
 */
public class _1264 {

  public static void main(String[] args) throws IOException {
    solByStream();
    solByCharAt();
    solByCharArray();
  }

  private static void solByStream() {
    new BufferedReader(new InputStreamReader(System.in)).lines()
      .filter(s -> !s.equals("#"))
      .mapToInt(s -> (int) s.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count())
      .forEach(System.out::println);
  }

  private static void solByCharArray() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String line = br.readLine();
      if (line.equals("#")) {
        break;
      }
      int count = 0;
      char[] chars = line.toCharArray();
      for (char c : chars) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
          count++;
        }
      }
      System.out.println(count);
    }
  }

  private static void solByCharAt() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String line = br.readLine();
      if (line.equals("#")) {
        break;
      }
      int count = 0;
      for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}

/*
time complexity
문자 하나하나 다 비교해야 하므로 O(n)

critical point
모음 대소문자 a, e, i, o, u 와 비교를 어떻게 가장 빠르게 할 수 있을까?
스트림이 가장 느렸고 charArray 로 바꾸고 비교하는 것보다 charAt 으로 비교하는 것이 더 빨랐다.
charAt vs charArray 성능 차이 (String -> charArray 변환에 대한 비용 때문일 듯)

How are you today?
Quite well, thank you, how about yourself?
I live at number twenty four.
#

7
14
9
 */
