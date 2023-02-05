package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대회 or 인턴
 */
public class _2875 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
    int team = n >= m * 2 ? m : n / 2;
    int remain = n + m - team * 3;
    if (remain >= k) {
      System.out.println(team);
      return;
    } else {
      k -= remain;
    }

    while (k > 0) {
      k -= 3;
      team--;
    }
    System.out.println(team);
  }
}

/*
time complexity
K ≤ M+N 이므로 O(1)

critical point
0 ≤ M ≤ 100, 0 ≤ N ≤ 100, 0 ≤ K ≤ M+N
팀을 구성하고 남은 인원 중 인턴을 먼저 보낸 후에도 인턴 인원이 부족하면 팀에서 빼기 시작

reference
https://www.acmicpc.net/problem/2875
 */