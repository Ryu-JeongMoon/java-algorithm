package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 인사성 밝은 곰곰이
 */
public class _25192 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), count = 0;
    Set<String> names = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String current = br.readLine();
      if (current.equals("ENTER")) {
        count += names.size();
        names.clear();
      } else {
        names.add(current);
      }
    }
    br.close();
    System.out.println(count + names.size());
  }
}

/*
time complexity
O(N)

critical point
입력으로 ENTER 들어올 때마다 초기화, 카운트는 누적

reference
https://www.acmicpc.net/problem/25192
*/
