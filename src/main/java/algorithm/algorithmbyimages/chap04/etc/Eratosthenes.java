package algorithm.algorithmbyimages.chap04.etc;

import java.util.Arrays;

public class Eratosthenes {

  public static int n = 1000;
  public static boolean[] arr = new boolean[n + 1];

  public static void main(String[] args) {
    Arrays.fill(arr, true);

    for (int i = 2; i < Math.sqrt(n); i++) {
      if (arr[i]) {
        int j = 2;

        while (i * j <= n) {
          arr[i * j] = false;
          j += 1;
        }
      }
    }

    for (int i = 2; i <= n; i++) {
      if (arr[i]) {
        System.out.println(i + " ");
      }
    }
  }
}
