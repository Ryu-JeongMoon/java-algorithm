package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 삼각수의 합
 */
public class _2721 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (--n >= 0) {
      sb.append(getW(Integer.parseInt(br.readLine()))).append("\n");
    }
    System.out.println(sb);
  }

  private static int getW(int n) {
    int result = 0;
    for (int i = 1; i <= n; i++) {
      result += i * getT(i + 1);
    }
    return result;
  }

  private static int getT(int i) {
    return i * (i + 1) / 2;
  }
}

/*
time complexity
입력값에 따라 for-loop 돌려야 하므로 O(n)

critical point
memoization 통해 시간 줄일 수 있을듯?!
 */