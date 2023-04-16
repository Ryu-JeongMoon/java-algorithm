package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 */
public class _1120 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    String a = s[0], b = s[1];
    int min = Integer.MAX_VALUE;
    if (a.length() != b.length()) {
      for (int i = 0; i < b.length() - a.length() + 1; i++) {
        int difference = getDifference(a, b.substring(i, i + a.length()));
        if (difference < min) {
          min = difference;
        }
      }
    }
    System.out.println(a.length() == b.length() ? getDifference(a, b) : min);
  }

  private static int getDifference(String a, String b) {
    int difference = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        ++difference;
      }
    }
    return difference;
  }
}

/*
time complexity
1. b.length() - a.length() + 1 loop => N
2. substring => N
O(N^2)

단 여기서 문자열의 길이는 최대 50으로 정해졌으므로 substring 최대 시간 복잡도는 O(50)
O(N)

critical point
loop 조건 주의
b.length() = 6, a.length() = 5일 때 6 - 5라고 하면 i < 1이 되기 때문에 1번만 반복하게 됨
따라서 i < b.length() - a.length() + 1 or i <= b.length() - a.length()로 해야함

reference
https://www.acmicpc.net/problem/1120
 */