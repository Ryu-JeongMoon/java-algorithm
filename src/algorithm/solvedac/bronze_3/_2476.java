package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 주사위 게임
 */
public class _2476 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] diceValues;
    int maxValue = 0;
    while (--n >= 0) {
      diceValues = new int[7];

      String[] s = br.readLine().split(" ");
      ++diceValues[Integer.parseInt(s[0])];
      ++diceValues[Integer.parseInt(s[1])];
      ++diceValues[Integer.parseInt(s[2])];

      for (int i = 1; i < diceValues.length; i++) {
        if (diceValues[i] == 3 && maxValue < 10000 + i * 1000) {
          maxValue = 10000 + i * 1000;
          break;
        } else if (diceValues[i] == 2 && maxValue < 1000 + i * 100) {
          maxValue = 1000 + i * 100;
          break;
        } else if (diceValues[i] == 1 && maxValue < i * 100) {
          maxValue = i * 100;
        }
      }
    }
    System.out.println(maxValue);
  }
}

/*
time complexity
입력값 마다 for-loop 돌려야 하므로 O(n)
1-6까지 돌리는 for-loop 상수 취급

critical point
3개 중 같은 값이 2, 3개라면 더 돌릴 필요가 없으므로 break

3
3 3 6
2 2 2
6 2 5
 */
