package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 약수 구하기
 */
public class _2501 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int k = Integer.parseInt(s[1]);

    ArrayList<Integer> ints = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        ints.add(i);
      }
    }

    try {
      Integer value = ints.get(k - 1);
      if (value == null)
        System.out.println(0);
      else
        System.out.println(value);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(0);
    }
  }
}

/*
time complexity
입력값에 따라 루프 돌려야하므로 O(n)

critical point
k번째 약수 찾기 위해 ArrayList 활용, IndexOutOfBoundsException 발생하면 0 반환

reference
https://www.acmicpc.net/problem/2501
 */