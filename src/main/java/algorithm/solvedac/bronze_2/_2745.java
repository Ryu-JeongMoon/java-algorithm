package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 진법 변환
 */
public class _2745 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strings = br.readLine().split(" ");
    String number = strings[0];
    int numberSystem = Integer.parseInt(strings[1]);

    int result = 0, length = number.length(), target;
    for (int i = 0; i < length; i++) {
      char current = number.charAt(i);
      target = Character.isDigit(current) ? current - '0' : current - 'A' + 10;
      result += (int) (target * Math.pow(numberSystem, length - 1- i));
    }

    br.close();
    System.out.println(result);
  }
}

/*
time complexity
O(N)

critical point
인덱스와 계수는 역 관계
number.charAt(i) * Math.pow(numberSystem, length - 1 - i) ...

reference
https://www.acmicpc.net/problem/2745
*/
