package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 풍선 터뜨리기
 */
public class _2346 {

  public static void main(String[] args) throws IOException {
    Deque<Integer> queue = new ArrayDeque<>();
    int[] move = new int[nextIntWithNegative()];
    for (int i = 0; i < move.length; i++) {
      queue.add(i);
      move[i] = nextIntWithNegative();
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      int index = queue.poll();
      sb.append(index + 1).append(" ");

      int value = move[index];
      if (value > 0) {
        while (!queue.isEmpty() && --value > 0) {
          queue.offer(queue.poll());
        }
      } else {
        while (!queue.isEmpty() && value++ < 0) {
          queue.offerFirst(queue.pollLast());
        }
      }
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(n^2)

critical point
LinkedList 사용 시 메모리 초과

Deque 으로 구현 했기 때문에 현재의 풍선을 터트리고 다음 수로 갈 때 주의해야 함
poll()로 뺀 경우, 현재 수가 poll() + 1인 수가 되어있기 때문
1) value=2, move=2인 경우
2 -> 3 -> 4, 2를 뺀 후 3 -> 4 이므로 1칸만 더 움직이면 됨 (--value)
2) value=2, move=-2인 경우
1 -> 2 -> 3 -> 4, 2를 뺀 후 1 -> 3 -> 4 이고 현재 수는 3이므로 4 <- 1 <- 3 으로 2칸 움직여야 함 (value++)

# input
10
1 -2 3 -4 5 -6 7 -8 9 -10

# output
1 2 9 3 6 5 7 8 10 4

reference
https://www.acmicpc.net/problem/2346
*/
