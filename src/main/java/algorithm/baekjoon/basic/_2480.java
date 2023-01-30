package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주사위 세개
 */
public class _2480 {

  public static void main(String[] args) throws IOException {
    int[] dices = new int[7];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    while (st.hasMoreTokens())
      dices[Integer.parseInt(st.nextToken())]++;

    System.out.println("dices = " + Arrays.toString(dices));

    int prize = 0;

    for (int i = 1; i < dices.length; i++) {
      if (dices[i] == 0)
        continue;

      if (dices[i] == 1) {
        prize = i * 100;
        continue;
      }

      if (dices[i] > 2) {
        prize = 10000 + 1000 * i;
        break;
      }

      if (dices[i] == 2) {
        prize = 1000 + 100 * i;
        break;
      }
    }

    System.out.print(prize);
  }
}
