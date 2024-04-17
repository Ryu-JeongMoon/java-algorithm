package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 이전 순열
 */
public class _10973 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] permutation = new int[n];
    for (int i = 0; i < n; i++) {
      permutation[i] = nextInt();
    }

    int index = 0;
    List<Integer> numbers = new ArrayList<>();
    for (int i = n - 1; i > 0; i--) {
      if (permutation[i] < permutation[i - 1]) {
        index = i - 1;

        for (int j = n - 1; j >= i; j--) {
          numbers.add(permutation[j]);
        }

        for (int j = 0; j < numbers.size(); j++) {
          if (permutation[index] > numbers.get(j)) {
            int temp = permutation[index];
            permutation[index] = numbers.get(j);
            numbers.set(j, temp);
            break;
          }
        }
        Collections.sort(numbers);
        break;
      }
    }

    if (numbers.isEmpty()) {
      System.out.println(-1);
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= index; i++) {
      sb.append(permutation[i]).append(" ");
    }
    for (int i = numbers.size() - 1; i >= 0; i--) {
      sb.append(numbers.get(i)).append(" ");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
10972 같은 방식, 다른 방향

reference
https://www.acmicpc.net/problem/10973
*/
