package algorithm.solvedac.silver_5;

import static algorithm.util.MathUtils.gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백대열
 */
public class _14490 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] numbers = br.readLine().split(":");
    int first = Integer.parseInt(numbers[0]), second = Integer.parseInt(numbers[1]);
    int gcd = gcd(Math.max(first, second), Math.min(first, second));
    System.out.println(first / gcd + ":" + second / gcd);
  }
}

/*
time complexity
O(logN)

critical point

reference
https://www.acmicpc.net/problem/14490
*/
