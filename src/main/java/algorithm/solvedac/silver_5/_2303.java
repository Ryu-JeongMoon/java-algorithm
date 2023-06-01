package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 게임
 */
public class _2303 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), max = 0, maxIndex = 0;
    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      int maxValue = getMax(s);
      if (max <= maxValue) {
        max = maxValue;
        maxIndex = i + 1;
      }
    }
    System.out.println(maxIndex);
  }

  private static int getMax(String[] s) {
    final int length = s.length;
    int[] numbers = new int[length];
    for (int i = 0; i < length; i++) {
      numbers[i] = Integer.parseInt(s[i]);
    }

    int max = 0;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        for (int k = j + 1; k < length; k++) {
          max = Math.max(max, (numbers[i] + numbers[j] + numbers[k]) % 10);
        }
      }
    }
    return max;
  }
}

/*
time complexity
한 사람 당 카드가 5개 고정이므로 루프를 세번 돌더라도 5C3 = 10 => O(1)
O(n)

critical point
가장 큰 수를 갖는 사람이 두 명 이상일 경우에는 번호가 가장 큰 사람의 번호를 출력

reference
https://www.acmicpc.net/problem/2303
*/
