package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 크면서 작은 수
 */
public class _2992 {

  public static void main(String[] args) throws IOException {
    char[] origin = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
    char[] copy = Arrays.copyOf(origin, origin.length);
    for (int i = copy.length - 1; i > 0; i--) {
      if (copy[i] > copy[i - 1]) {
        int minimumIndex = findMinimumIndex(copy, i);
        char temp = copy[i - 1];
        copy[i - 1] = copy[minimumIndex];
        copy[minimumIndex] = temp;
        Arrays.sort(copy, i, copy.length);
        break;
      }
    }

    if (Arrays.equals(origin, copy)) {
      System.out.println(0);
    } else {
      System.out.println(new String(copy));
    }
  }

  private static int findMinimumIndex(char[] copy, int index) {
    int minIndex = Integer.MAX_VALUE, minValue = Integer.MAX_VALUE;
    for (int i = index; i < copy.length; i++) {
      if (copy[i] > copy[index - 1] && minValue > copy[i]) {
        minIndex = i;
        minValue = copy[i];
      }
    }
    return minIndex;
  }
}

/*
time complexity
O(NlogN)

critical point
12021 -> 12102
1. 12[021]
0과 2를 변경할 때 자릿수 변경 발생

2. 12[120]
단순히 0과 2를 변경하면 12201이 되어 중간에 더 작은 수가 존재
0과 2를 변경할 때 0 이후의 수들 중에서 0보다 크면서 가장 작은 수를 찾아 0이 들어있는 위치에 대입

3. 12[102]
0이 들어있던 위치에 자릿수 변경이 일어나 큰 수로 바뀌었으므로 변경된 인덱스 이후의 수들을 오름차순 정렬

reference
https://www.acmicpc.net/problem/2992
*/
