package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다음 순열
 */
public class _10972 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] permutation = new int[n];
    for (int i = 0; i < n; i++) {
      permutation[i] = nextInt();
    }

    List<Integer> numbers = new ArrayList<>();
    int index = 0;
    for (int i = n - 1; i > 0; i--) {
      if (permutation[i] > permutation[i - 1]) {
        index = i;

        for (int j = i; j < n; j++) {
          numbers.add(permutation[j]);
        }
        Collections.sort(numbers);

        for (int j = 0; j < numbers.size(); j++) {
          if (permutation[i - 1] < numbers.get(j)) {
            int temp = numbers.get(j);
            numbers.set(j, permutation[i - 1]);
            permutation[i - 1] = temp;
            break;
          }
        }
        break;
      }
    }

    if (numbers.isEmpty()) {
      System.out.println(-1);
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < index; i++) {
      sb.append(permutation[i]).append(" ");
    }
    for (int number : numbers) {
      sb.append(number).append(" ");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 위치를 바꿀 인덱스 지정
2. 인덱스 이후의 값을 정렬
3. 정렬된 수 순회하며 순열[인덱스]의 값과 비교하여 제일 작은 수를 찾아 위치를 바꿈
4. 주어진 순열의 앞부분부터 출력, 정렬된 수 출력

ex)
1 4 3 2
2 > 3 -> false
3 > 4 -> false
4 > 1 -> true

1. 바꿀 부분의 index = 0
2-1. 바꿀 부분의 index 이후의 수 = 4 3 2
2-2. 정렬 = 2 3 4
3-1. 큰 수 순회, 제일 작은 수 찾기 = 2
3-2. 위치 변경 1 / 2 3 4 -> 2 / 1 3 4
4. 주어진 순열의 앞부분 출력 2, 정렬된 수 출력 1 3 4
1 4 3 2 -> 2 1 3 4

reference
https://www.acmicpc.net/problem/10972
*/
