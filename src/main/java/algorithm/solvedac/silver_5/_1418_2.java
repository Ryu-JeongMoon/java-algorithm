package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * K-세준수
 */
public class _1418_2 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] biggestDivisors = new int[n + 1];
    for (int i = 2; i < n + 1; i++) {
      if (biggestDivisors[i] == 0) {
        for (int j = i; j < n + 1; j += i) {
          biggestDivisors[j] = i;
        }
      }
    }

    int k = nextInt(), answer = 1;
    for (int e : biggestDivisors) {
      if (e != 0 && e <= k) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}

/*
time complexity
O(Nlog(logN))

critical point
n 100000, k 100인 경우
101*103은 biggestDivisors[101*103]은 처음에는 101로 초기화
103을 만났을 때 biggestDivisors[103]은 0인 상태라서 안쪽 for 문을 타게 되고 다시 한번 103으로 초기화

reference
https://www.acmicpc.net/problem/1418
*/
