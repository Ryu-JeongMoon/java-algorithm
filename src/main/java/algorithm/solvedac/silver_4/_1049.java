package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 기타줄
 */
public class _1049 {

  private static final int PACKAGE_SIZE = 6;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int numberOfStrings = Integer.parseInt(s[0]);
    int numberOfBrands = Integer.parseInt(s[1]);
    int minPackagePrice = Integer.MAX_VALUE;
    int minSinglePrice = Integer.MAX_VALUE;
    for (int i = 0; i < numberOfBrands; i++) {
      s = br.readLine().split(" ");
      minPackagePrice = Math.min(minPackagePrice, Integer.parseInt(s[0]));
      minSinglePrice = Math.min(minSinglePrice, Integer.parseInt(s[1]));
    }

    if (minPackagePrice < minSinglePrice * PACKAGE_SIZE) {
      System.out.println(numberOfStrings / PACKAGE_SIZE * minPackagePrice
        + Math.min(numberOfStrings % PACKAGE_SIZE * minSinglePrice, minPackagePrice));
    } else {
      System.out.println(minSinglePrice * numberOfStrings);
    }
  }
}

/*
time complexity
O(n)

critical point
최소값 찾는 것은 O(1)로 해결하기

reference
https://www.acmicpc.net/problem/1049
*/
