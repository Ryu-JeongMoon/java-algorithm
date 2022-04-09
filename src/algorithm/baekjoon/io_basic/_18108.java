package algorithm.baekjoon.io_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1998년생인 내가 태국에서는 2541년생?!
 */
public class _18108 {

  public static void main(String[] args) throws IOException {
    // 2541 -> 1998
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int toBeChangeYear = Integer.parseInt(br.readLine());
    System.out.print(toBeChangeYear - 543);
  }
}
