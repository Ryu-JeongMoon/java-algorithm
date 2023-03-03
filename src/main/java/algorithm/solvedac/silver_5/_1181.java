package algorithm.solvedac.silver_5;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 단어 정렬
 */
public class _1181 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> words = new HashSet<>();
    while (--n >= 0) {
      words.add(br.readLine());
    }

    String result = words.stream()
      .sorted(comparingInt(String::length).thenComparing(String::compareTo))
      .collect(joining("\n"));
    System.out.println(result);
  }
}

/*
time complexity
정렬 필요, O(NlogN)

critical point
1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로
3. 중복된 단어는 하나만 남기고 제거

1, 2는 비교 조건 사용
3은 Set의 특성을 이용

reference
https://www.acmicpc.net/problem/1181
 */