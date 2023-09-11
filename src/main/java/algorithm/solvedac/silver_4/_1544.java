package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 사이클 단어
 */
public class _1544 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), total = 0;

    HashSet<String> words = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String newWord = br.readLine();
      if (words.contains(newWord)) {
        continue;
      }

      StringBuilder sb = new StringBuilder(newWord);
      for (int j = 0; j <= newWord.length(); j++) {
        words.add(String.valueOf(sb.append(sb.charAt(0)).deleteCharAt(0)));
      }
      ++total;
    }
    System.out.println(total);
  }
}

/*
time complexity
L = max length of word
O(N*L)

critical point
매 입력 사이클 단어 확인 않고 Set에 없는 단어인 경우, 사이클 돌려서 추가

reference
https://www.acmicpc.net/problem/1544
*/
