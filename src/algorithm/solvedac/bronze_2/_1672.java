package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DNA 해독
 */
public class _1672 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String source = br.readLine();
    if (source.length() == 1) {
      System.out.println(source);
      return;
    }

    char[] index = { 'A', 'C', 'G', 'T' };
    char[][] values = {
      { 'A', 'A', 'C', 'G' },
      { 'A', 'C', 'T', 'G' },
      { 'C', 'T', 'G', 'A' },
      { 'G', 'G', 'A', 'T' },
    };
    char result = values[Arrays.binarySearch(index, source.charAt(n - 2))][Arrays.binarySearch(index, source.charAt(n - 1))];
    for (int i = n - 3; i >= 0; i--) {
      result = values[Arrays.binarySearch(index, source.charAt(i))][Arrays.binarySearch(index, result)];
    }
    System.out.println(result);
  }
}

/*
time complexity
O(n)

critical point
예외, 인덱스 처리 & 메모리 주의..
HashMap + String 조합 시 16MB 초과

reference
https://www.acmicpc.net/problem/1672
 */