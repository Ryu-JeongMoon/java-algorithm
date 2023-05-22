package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 콘도 선정
 */
public class _2246 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] condos = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      condos[i][0] = Integer.parseInt(s[0]);
      condos[i][1] = Integer.parseInt(s[1]);
    }

    int candidate = 0;
    boolean satisfied;
    for (int i = 0; i < condos.length; i++) {
      satisfied = true;
      int distance = condos[i][0], cost = condos[i][1];
      for (int j = 0; j < condos.length; j++) {
        if (i == j) {
          continue;
        }

        int nextDistance = condos[j][0], nextCost = condos[j][1];
        boolean first = distance > nextDistance && cost >= nextCost;
        boolean second = distance >= nextDistance && cost > nextCost;

        if (first || second) {
          satisfied = false;
          break;
        }
      }

      if (satisfied) {
        ++candidate;
      }
    }
    System.out.println(candidate);
  }
}

/*
time complexity
O(n^2)

critical point
만족시켜야 하는 조건
1. X보다 바닷가에 더 가까운 콘도들은 모두 X보다 숙박비가 더 비싸다
2. X보다 숙박비가 더 싼 콘도들은 모두 X보다 바닷가에서 더 멀다

깨트려야 하는 조건 (스킵 조건)
1. X보다 바닷가에 더 가까운 콘도들 중 X보다 숙박비가 저렴한 것
distance > nextDistance && cost >= nextCost;
2. X보다 숙박비가 더 싼 콘도들 중 X보다 바닷가에 가까운 것
distance >= nextDistance && cost > nextCost

자기 자신을 제외한 모든 콘도와 비교해야 하기 때문에 O(n^2)의 시간 복잡도를 가진다.

reference
https://www.acmicpc.net/problem/2246
 */