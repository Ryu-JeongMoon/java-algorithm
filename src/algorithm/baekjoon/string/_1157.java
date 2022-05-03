package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 단어 공부
 */
public class _1157 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] chars = br.readLine().toLowerCase().toCharArray();

    int max = 0;
    int maxIndex = 0;
    int[] alphabets = new int[26];
    for (char c : chars) {
      if (++alphabets[c - 97] > max) {
        max = alphabets[c - 97];
        maxIndex = (byte) (c - 97);
      }
    }

    int maxCount = 0;
    for (int alphabet : alphabets)
      if (alphabet == max)
        maxCount++;

    if (maxCount > 1)
      System.out.println('?');
    else
      System.out.println(((char) (maxIndex + 65)));
  }
}

/*
'a' -> 97
'A' -> 65
대문자로 표현, 개수 중복일 시 ?
Mississipi -> ?
zZa -> Z
baaa -> A
 */