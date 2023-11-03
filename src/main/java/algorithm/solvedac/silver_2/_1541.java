package algorithm.solvedac.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 잃어버린 괄호
 */
public class _1541 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    String[] numbers = line.split("[-+]");
    if (numbers[0].isEmpty()) {
      numbers = Arrays.copyOfRange(numbers, 1, numbers.length);
    }
    String[] operators = line.split("\\d+");
    if (operators.length == 0) {
      operators = new String[] { "+" };
    }

    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      if ("-".equals(operators[i])) {
        for (int j = i; j < numbers.length; j++) {
          sum -= Integer.parseInt(numbers[j]);
        }
        break;
      } else {
        sum += Integer.parseInt(numbers[i]);
      }
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(N)

critical point
입력으로 주어지는 수가 하나일 수도 있다 ?!

reference
https://www.acmicpc.net/problem/1541
*/
