package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 대칭 차집합
 */
public class _1269 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    Set<String> elements = new HashSet<>();
    addToElements(elements, br.readLine());
    addToElements(elements, br.readLine());
    System.out.println(2 * elements.size() - (Integer.parseInt(s[0]) + Integer.parseInt(s[1])));
  }

  private static void addToElements(Set<String> elements, String line) {
    StringTokenizer st = new StringTokenizer(line);
    while (st.hasMoreTokens()) {
      elements.add(st.nextToken());
    }
  }
}

/*
time complexity
O(Math.max(a, b))

critical point
입력 수 증가할수록 token -> set 변환 overhead 상승
읽기 성능 향상 필요

reference
https://www.acmicpc.net/problem/1269
*/
