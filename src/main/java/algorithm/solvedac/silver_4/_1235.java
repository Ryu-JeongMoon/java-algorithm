package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 학생 번호
 */
public class _1235 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] sequences = new String[n];
    for (int i = 0; i < n; i++) {
      sequences[i] = br.readLine();
    }

    int k = 0;
    HashSet<String> uniqueSequences = new HashSet<>(n);
    while (++k < 100) {
      for (String sequence : sequences) {
        uniqueSequences.add(sequence.substring(sequence.length() - k));
      }
      if (uniqueSequences.size() == n) {
        System.out.println(k);
        break;
      } else {
        uniqueSequences.clear();
      }
    }
  }
}

/*
time complexity
sequences 개수를 k, sequence 길이를 s라고 할 때
k는 최대 1,000 & s는 최대 100이므로 == O(1)
O(n * k * s) -> O(n * 1 * 1)
O(n)

critical point
Set을 이용해 중복이 없는지 == 전부 구분이 가는지 판단

reference
https://www.acmicpc.net/problem/1235
 */