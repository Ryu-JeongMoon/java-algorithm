package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문서 검색
 */
public class _1543 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder(br.readLine());
    String word = br.readLine();
    int count = 0;
    while (sb.indexOf(word) != -1) {
      sb.delete(0, sb.indexOf(word) + word.length());
      ++count;
    }
    System.out.println(count);
  }
}

/*
time complexity
O(n)

critical point
조회된 단어 이후부터 다시 조회

reference
https://www.acmicpc.net/problem/1543
*/
