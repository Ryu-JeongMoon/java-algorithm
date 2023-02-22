package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 막대기
 */
public class _1094 {

  public static void main(String[] args) throws IOException {
    String binary = Integer.toBinaryString(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    int total = 0;
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        ++total;
      }
    }
    System.out.println(total);
  }
}

/*
time complexity
O(1)

critical point
Integer.toBinaryString API 사용

reference
https://www.acmicpc.net/problem/1094
 */