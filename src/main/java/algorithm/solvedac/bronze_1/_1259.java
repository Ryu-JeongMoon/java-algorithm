package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 팰린드롬수
 */
public class _1259 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while (!(line = br.readLine()).equals("0")) {
      String isPalindrome = "yes\n";
      for (int i = 0; i < line.length() / 2; i++) {
        if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
          isPalindrome = "no\n";
          break;
        }
      }
      bw.write(isPalindrome);
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
l이 입력 받은 문자의 길이라 할 때 O(n * l / 2)

critical point
메모리 낭비를 막기 위해 line.charAt(i) 비교

reference
https://www.acmicpc.net/problem/1259
 */