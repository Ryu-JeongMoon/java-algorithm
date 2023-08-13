package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 암호 키
 */
public class _1816 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    while (--n >= 0) {
      bw.write(isPrime(Long.parseLong(br.readLine())) ? "YES\n" : "NO\n");
    }
    bw.flush();
  }

  private static boolean isPrime(long n) {
    int min = Math.min(1_000_000, (int) (Math.sqrt(n) + 1));
    for (int i = 3; i < min + 1; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return n > 2;
  }
}

/*
time complexity
min = 10^6 or sqrt(n)
O(N * min)

critical point
Math.min() 활용, 10^6과 sqrt(n) 중 작은 값까지만 확인하면 됨

reference
https://www.acmicpc.net/problem/1816
*/
