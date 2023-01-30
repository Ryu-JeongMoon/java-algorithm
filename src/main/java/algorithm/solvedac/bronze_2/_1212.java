package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 8진수 2진수
 */
public class _1212 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split("");
    StringBuilder sb = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s[0])));
    for (int i = 1; i < s.length; i++) {
      String binaryString = Integer.toBinaryString(Integer.parseInt(s[i]));
      if (binaryString.length() != 3) {
        for (int j = 0; j < 3 - binaryString.length(); j++) {
          sb.append("0");
        }
      }
      sb.append(binaryString);
    }
    System.out.println(sb);
  }
}

/*
time complexity
입력값의 길이에 따라 반복 돌려야 하므로 O(n.length)

critical point
첫 binary-string은 0이 없어야 함, 나머지는 3자리가 되도록 0을 채워야 함

reference
https://www.acmicpc.net/problem/1212
 */