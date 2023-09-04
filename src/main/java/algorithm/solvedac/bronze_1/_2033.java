package algorithm.solvedac.bronze_1;

import java.io.IOException;

/**
 * 반올림
 */
public class _2033 {

  public static void main(String[] args) throws IOException {
    int input = nextInt(), cipher = findCipher(input);
    for (int i = 0; i < cipher; i++) {
      double pow = Math.pow(10, i), current = input / pow % 10;
      input += (int) ((Math.round(current) * pow) - input % Math.pow(10, i + 1));
    }
    System.out.println(input);
  }

  private static int findCipher(int i) {
    int cipher = 0;
    while (i != 0) {
      i /= 10;
      ++cipher;
    }
    return cipher;
  }

  private static int nextInt() throws IOException {
    int sum = 0;
    while (true) {
      int input = System.in.read();
      if (input == '\n' || input == ' ') {
        return sum;
      } else {
        sum = (sum * 10) + input - '0';
      }
    }
  }
}

/*
time complexity
N = input.length
O(N)

critical point
1. 자릿수 구하기
2. 역순 순회 반올림

reference
https://www.acmicpc.net/problem/2033
*/
