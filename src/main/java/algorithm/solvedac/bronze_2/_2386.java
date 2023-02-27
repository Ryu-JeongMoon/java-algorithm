package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 도비의 영어 공부
 */
public class _2386 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String line;
    while (!(line = br.readLine()).equals("#")) {
      int counter = 0;
      char c = line.charAt(0);
      for (int i = 1; i < line.length(); i++) {
        char charInLine = line.charAt(i);
        if (charInLine == c || charInLine == (c - 32)) {
          ++counter;
        }
      }
      sb.append(c).append(" ").append(counter).append("\n");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(n.length)

critical point
입력으로 들어오는 문자의 첫번째는 소문자
입력 문자를 찾기 위한 문자열에서는 소문자 / 대문자 모두 매칭시켜야 함
'a' - '0' -> 49
'A' - '0' -> 17

reference
https://www.acmicpc.net/problem/2386
 */