package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * UCPC는 무엇의 약자일까?
 */
public class _15904 {

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("[^A-Z]", "");
    System.out.println(Pattern.compile(".*U.*C.*P.*C.*").matcher(input).matches() ? "I love UCPC" : "I hate UCPC");
  }
}

/*
time complexity
N = input.length()
O(N)

critical point
U^ C P C

reference
https://www.acmicpc.net/problem/15904
*/
