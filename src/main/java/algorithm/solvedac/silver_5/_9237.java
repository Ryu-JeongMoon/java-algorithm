package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 이장님 초대
 */
public class _9237 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = 0;
    int[] trees = new int[n];
    for (int i = 0; i < n; i++) {
      trees[i] = nextInt();
    }
    Arrays.sort(trees);
    for (int i = n - 1, day = 1; i >= 0; i--, day++) {
      max = Math.max(max, trees[i] + day);
    }
    System.out.println(max + 1);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 역순 정렬 (풀이는 정순 정렬 후 역순으로 순회)
2. 심는 행위는 별도 계산 필요
3. max = (지난 일수 + 현재 묘목 성장 소요 일수)

ex)
4
2 3 4 3

day  4  3  3  2
1.   심
2    4  심
3.   3  3  심
4.   2  2  3  심
5.   1  1  2  2
6.   0  0  1  1
7.   0  0  0  0

reference
https://www.acmicpc.net/problem/9237
*/
