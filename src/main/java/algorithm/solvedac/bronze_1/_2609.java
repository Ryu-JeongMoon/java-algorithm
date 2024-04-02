package algorithm.solvedac.bronze_1;

import static algorithm.util.MathUtils.gcd;
import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 최대공약수와 최소공배수
 */
public class _2609 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    int gcd = gcd(Math.max(n, m), Math.min(n, m));
    System.out.println(gcd + " " + n * m / gcd);
  }
}

/*
time complexity
O(logM)

critical point

reference
https://www.acmicpc.net/problem/2609
*/
