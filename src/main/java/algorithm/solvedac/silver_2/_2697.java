package algorithm.solvedac.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 다음수 구하기
 */
public class _2697 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char[] numbers = br.readLine().toCharArray();
      int target = -1;
      for (int j = numbers.length - 1; j >= 1; j--) {
        if (numbers[j] > numbers[j - 1]) {
          target = j - 1;
          interchange(j, numbers);
          break;
        }
      }

      if (target == -1) {
        sb.append("BIGGEST").append("\n");
        continue;
      }

      Arrays.sort(numbers, target + 1, numbers.length);
      for (char number : numbers) {
        sb.append(number);
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }

  private static void interchange(int target, char[] numbers) {
    for (int k = numbers.length - 1; k > target - 1; k--) {
      if (numbers[k] > numbers[target - 1]) {
        char temp = numbers[k];
        numbers[k] = numbers[target - 1];
        numbers[target - 1] = temp;
        break;
      }
    }
  }
}

/*
time complexity
O(NlogN)

critical point
바뀌어야 할 위치 찾기

reference
https://www.acmicpc.net/problem/2697
*/
