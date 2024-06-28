package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드로미터
 */
public class _4096 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    StringBuilder sb = new StringBuilder();
    while (!((line = br.readLine()).equals("0"))) {
      char[] numbers = line.toCharArray();
      int count = 0, length = numbers.length;
      while (!isPalindrome(numbers)) {
        ++count;

        int index = length - 1;
        if (numbers[index] != '9') {
          ++numbers[index];
          continue;
        }

        while (numbers[index] == '9') {
          numbers[index] = '0';
          --index;
        }
        ++numbers[index];
      }

      sb.append(count).append("\n");
    }

    br.close();
    System.out.print(sb);
  }

  private static boolean isPalindrome(char[] numbers) {
    int length = numbers.length;

    boolean isPalindrome = true;
    for (int i = 0; i < length / 2; i++) {
      if (numbers[i] != numbers[length - 1 - i]) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }
}

/*
time complexity
K = needed the number of increments
O(K*N)

critical point
올림이 끝날 때까지 자릿수 바꾸며 올림 처리
ex) 1999 -> 199 10 -> 19 10 0 -> 20 0 0 -> 2000

reference
https://www.acmicpc.net/problem/4096
*/
