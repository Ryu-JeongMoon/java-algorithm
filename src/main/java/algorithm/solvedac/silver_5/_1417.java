package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 국회의원 선거
 */
public class _1417 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    if (n == 1) {
      System.out.println(0);
      return;
    }

    int maxIndex = 0;
    int[] people = new int[n];
    for (int i = 0; i < n; i++) {
      people[i] = Integer.parseInt(br.readLine());
      if (people[maxIndex] <= people[i]) {
        maxIndex = i;
      }
    }

    if (maxIndex == 0) {
      System.out.println(0);
      return;
    }

    int initialVotes = people[0];
    while (maxIndex != 0 && people[maxIndex]-- != people[0]++) {
      for (int i = 0; i < n; i++) {
        if (people[maxIndex] <= people[i]) {
          maxIndex = i;
        }
      }
    }
    System.out.println(people[0] - initialVotes);
  }
}

/*
time complexity
O(N^2)

critical point
loop 내의 if (people[maxIndex] <= people[i]) 비교에서 <= 사용해야 함
maxIndex 초기값이 0인 상태로 비교 시 작은 경우만 판단하면
10, 10, 10이 들어오는 경우 0번째 인덱스가 최댓값이라 인식됨
문제의 조건은 다른 사람들의 득표수보다 무조건 많아야 하기 때문에 같거나 작은 경우로 판단해
동일한 값이 올 때 뒤에 있는 값이 선택되도록 조건 비교 필요

reference
https://www.acmicpc.net/problem/1417
 */