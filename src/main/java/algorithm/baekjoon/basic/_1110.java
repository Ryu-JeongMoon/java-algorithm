package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 더하기 사이클
 */
public class _1110 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());

    int newNumber = number;
    int cycle = 0;

    do {
      int sumOfEachDigit = (newNumber / 10) + newNumber % 10;
      newNumber = (newNumber % 10) * 10 + sumOfEachDigit % 10;
      cycle++;
    } while (number != newNumber);

    System.out.print(cycle);
  }
}
