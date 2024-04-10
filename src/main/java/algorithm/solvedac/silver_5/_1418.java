package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * K-세준수
 */
public class _1418 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt();
    boolean[] compositeNumbers = new boolean[n + 1];
    for (int i = 4; i <= n; i += 2) {
      compositeNumbers[i] = true;
    }

    for (int i = 3; i <= n; i += 2) {
      for (int j = 2 * i; j <= n; j += i) {
        compositeNumbers[j] = true;
      }
    }

    Set<Integer> integers = new HashSet<>();
    for (int i = k + 1; i <= n; i++) {
      if (!compositeNumbers[i]) {
        for (int j = i; j <= n; j += i) {
          integers.add(j);
        }
      }
    }
    System.out.println(n - integers.size());
  }
}

/*
time complexity
O(NlogN)

critical point
소수를 찾아 그 배수를 전부 제외시켜야 할 수라 가정하는 경우
101 * 103 같은 수는 101에서의 배수에서도 포함되고 103에서의 배수에서도 포함 됨
이렇듯 겹치는 수를 제외시키기 위해 Set 사용

reference
https://www.acmicpc.net/problem/1418
*/
