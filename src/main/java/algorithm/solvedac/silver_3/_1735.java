package algorithm.solvedac.silver_3;

import static algorithm.util.MathUtils.*;
import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;

/**
 * 분수 합
 */
public class _1735 {

  public static void main(String[] args) throws IOException {
    int numerator1 = nextInt(), denominator1 = nextInt(), numerator2 = nextInt(), denominator2 = nextInt();
    int numerator, denominator;
    if (denominator1 != denominator2) {
      numerator = numerator1 * denominator2 + numerator2 * denominator1;
      denominator = denominator1 * denominator2;
    } else {
      numerator = numerator1 + numerator2;
      denominator = denominator1;
    }

    int gcd = gcd(numerator, denominator);
    System.out.println(numerator / gcd + " " + denominator / gcd);
  }
}

/*
time complexity
O(logN)

critical point
gcd를 통한 최대 공약수 구한 후, 분자 & 분모에 나눠주기

reference
https://www.acmicpc.net/problem/1735
*/
