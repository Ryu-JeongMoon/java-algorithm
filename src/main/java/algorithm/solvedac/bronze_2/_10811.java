package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 바구니 뒤집기
 */
public class _10811 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    int[] baskets = new int[n];
    for (int i = 0; i < n; i++) {
      baskets[i] = i + 1;
    }

    for (int i = 0; i < m; i++) {
      int start = nextInt() - 1, end = nextInt() - 1, halfOfDiff = (end - start) / 2;
      for (int j = 0; j <= halfOfDiff; j++) {
        swap(baskets, start + j, end - j);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int basket : baskets) {
      sb.append(basket).append(" ");
    }
    System.out.println(sb);
  }

  private static void swap(int[] baskets, int left, int right) {
    if (left == right) {
      return;
    }

    int temp = baskets[left];
    baskets[left] = baskets[right];
    baskets[right] = temp;
  }
}

/*
time complexity
O(NM)

critical point
left ~ right, 절반으로 나눠 swap
1. left, right - left
2. left + 1, right - (left + 1)
3. ...

reference
https://www.acmicpc.net/problem/10811
*/
