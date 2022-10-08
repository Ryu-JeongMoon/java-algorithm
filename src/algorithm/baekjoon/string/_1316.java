package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그룹 단어 체커
 */
public class _1316 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numberOfWords = Integer.parseInt(br.readLine());
    int countOfGroupWord = 0;
    int[] existsChars;
    while (numberOfWords-- > 0) {
      char[] chars = br.readLine().toCharArray();
      char previous = '0';
      existsChars = new int[26];
      for (int i = 0; i < chars.length; i++) {
        char currentCharacter = chars[i];
        if (currentCharacter != previous && existsChars[currentCharacter - 'a'] != 0) {
          break;
        }

        if (i != chars.length - 1 && currentCharacter == previous) {
          continue;
        }

        existsChars[currentCharacter - 'a'] = 1;
        previous = currentCharacter;

        if (i == chars.length - 1) {
          countOfGroupWord++;
        }
      }
    }
    System.out.println(countOfGroupWord);
  }
}

/*
3
happy
new
year
 */