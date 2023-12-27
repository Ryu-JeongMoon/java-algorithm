package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 한 줄로 서기
 */
public class _1138 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    List<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      queue.add(i);
    }

    int[] order = new int[n];
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      order[queue.get(current)] = i;
      queue.remove(current);
    }

    StringBuilder sb = new StringBuilder();
    for (int i : order) {
      sb.append(i + 1).append(" ");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
1. 인덱스에 대한 Queue 생성
2. 나보다 큰 사람이 몇명 있는지를 나타내는 current 변수 사용

현재 값보다 작은 값들은 어떤 위치에 있던 current 에 영향을 미치지 않음
큐에서 current 값으로 위치를 뽑아 결정

ex)
queue 0 1 2 3
input 2 1 1 0

0 -> 2, current = 2, queue = 0 1 3
1 -> 1, current = 1, queue = 0 3
2 -> 3, current = 1, queue = 0
3 -> 0, current = 0, queue =

출력 시 +1
3 1 0 2 -> 4 2 1 3

reference
https://www.acmicpc.net/problem/1138
*/
