package algorithm.solvedac.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 접두사
 */
public class _1141 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] words = new String[n];
    Set<String> splittedWords = new HashSet<>();
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
      for (int j = 1; j < words[i].length(); j++) {
        splittedWords.add(words[i].substring(0, j));
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!splittedWords.contains(words[i])) {
        splittedWords.add(words[i]);
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
L=word.length
O(N*L)

critical point
접두어 집합을 미리 생성
1. 각 단어를 1 ~ (단어 길이 - 1)씩 잘라 저장, ex) running -> r, ru, run, runn, runni, runnin
2. 한 단어가 다른 단어의 접두어가 되는 경우, 접두어 집합에 포함되어 있으므로 걸러짐
3. 접두어 집합에 들어가있지 않은 경우, 집합에 포함 시킨 후 ++count

reference
https://www.acmicpc.net/problem/1141
*/
