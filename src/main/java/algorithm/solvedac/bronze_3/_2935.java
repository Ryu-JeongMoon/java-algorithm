package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소음
 */
public class _2935 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine(), command = br.readLine(), second = br.readLine();
    if (first.length() == second.length() && command.equals("+")) {
      System.out.print("2" + first.substring(1));
      return;
    }

    switch (command) {
      case "*":
        System.out.println("1" + first.substring(1) + second.substring(1));
        break;
      case "+":
        String max = first.length() > second.length() ? first : second;
        String min = first.length() > second.length() ? second : first;
        System.out.print(max.substring(0, max.length() - min.length()) + min);
        break;
      default:
        break;
    }
  }
}

/*
time complexity
O(1)

critical point
선생님이 써주는 숫자는 최대 100자리 -> Integer 계산하지 말라는 것

reference
https://www.acmicpc.net/problem/2935
 */