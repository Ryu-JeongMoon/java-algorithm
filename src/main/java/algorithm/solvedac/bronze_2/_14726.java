package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 신용카드 판별
 */
public class _14726 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char[] numbers = br.readLine().toCharArray();
      for (int j = numbers.length - 2; j >= 0; j -= 2) {
        int current = numbers[j] - '0';
        numbers[j] = current >= 5
          ? (char) (findDigitSum(current) + '0')
          : (char) (current * 2 + '0');
      }

      int total = 0;
      for (char number : numbers) {
        total += (number - '0');
      }
      sb.append(total % 10 == 0 ? 'T' : 'F').append('\n');
    }
    br.close();
    System.out.print(sb);
  }

  private static int findDigitSum(int current) {
    int currentTwoTimes = current * 2, sum = 0;
    while (currentTwoTimes != 0) {
      sum += (currentTwoTimes % 10);
      currentTwoTimes /= 10;
    }
    return sum;
  }
}

/*
time complexity
O(N)

critical point
1. 각 자리 수 더하기
2. char <-> int 변환

reference
https://www.acmicpc.net/problem/14726
*/
