package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수
 */
public class _1312 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), n = Integer.parseInt(s[2]);
    int answer = 0;
    while (n-- > 0) {
      a = a % b * 10;
      answer = a / b;
    }
    System.out.println(answer);
  }
}

/*
time complexity
O(n)

critical point
나눗셈이 어떻게 이뤄지는가

a=25, b=7, n=5일 때
25 / 7 = 3.5714285714285714285714285714286
1. 25 % 7 = 4
2. 4 * 10 = 40
3. 40 / 7 = 5
4. 5 % 7 = 5
5. 5 * 10 = 50
6. 50 / 7 = 7

반복..

reference
https://www.acmicpc.net/problem/1312
*/
