package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 소트인사이드
 */
public class _1427 {

  public static void main(String[] args) throws IOException {
//    usingStream();
    usingArray();
  }

  // 236 ms
  private static void usingStream() throws IOException {
    StringBuilder sb = new StringBuilder();
    new BufferedReader(new InputStreamReader(System.in)).readLine()
      .chars()
      .mapToObj(c -> (char) c)
      .sorted(Comparator.reverseOrder())
      .forEach(sb::append);
    System.out.println(sb);
  }

  // 80ms
  private static void usingArray() throws IOException {
    char[] chars = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
    Arrays.sort(chars);
    StringBuilder sb = new StringBuilder();
    for (int i = chars.length - 1; i >= 0; i--) {
      sb.append(chars[i]);
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
char[] 이기 때문에 Comparator.reverseOrder() 역순 정렬이 안 되서 정순 정렬 후 역순으로 출력

reference
https://www.acmicpc.net/problem/1427
 */