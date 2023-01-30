package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 이진수 덧셈, BigInteger version
 */
public class _1252_1 {

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
    String first = st.nextToken(), second = st.nextToken();
    BigInteger firstBinary = new BigInteger(first, 2);
    BigInteger secondBinary = new BigInteger(second, 2);
    BigInteger sum = firstBinary.add(secondBinary);
    System.out.println(sum.toString(2));
  }
}

/*
time complexity

critical point
new BigInteger(value, radix), BigInteger.toString(radix) 사용법 숙지

reference
https://www.acmicpc.net/problem/1252
 */