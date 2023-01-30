package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 명령 프롬프트
 */
public class _1032 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) {
      System.out.println(br.readLine());
      return;
    }

    String[] inputs = new String[n];
    for (int i = 0; i < n; i++) {
      inputs[i] = br.readLine();
    }

    String pattern = inputs[0];
    for (int i = 1; i < n; i++) {
      if (pattern.equals(inputs[i])) {
        continue;
      }

      for (int j = 0; j < inputs[0].length(); j++) {
        if (pattern.charAt(j) != '?' && pattern.charAt(j) != inputs[i].charAt(j)) {
          pattern = pattern.substring(0, j) + "?" + pattern.substring(j + 1);
        }
      }
    }

    System.out.println(pattern);
  }
}

/*
time complexity
입력값 N, 입력값 N의 길이 M일 때 O(NM)

critical point
문자열을 입력 받아 같은 부분은 그대로 출력, 다른 부분은 ?로 치환

reference
https://www.acmicpc.net/problem/1032
 */