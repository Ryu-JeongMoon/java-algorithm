package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 농구 경기
 */
public class _1159 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[26];
    while (--n >= 0) {
      arr[br.readLine().charAt(0) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] >= 5) {
        sb.append((char) (i + 'a'));
      }
    }

    if (sb.length() == 0)
      System.out.println("PREDAJA");
    else
      System.out.println(sb);
  }
}

/*
time complexity
입력값에 따라 반복 돌려야 하므로 O(n)

critical point
뽑을 수 있는 성이 하나도 없으면 sb.length() == 0
 */