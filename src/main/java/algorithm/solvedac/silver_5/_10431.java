package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * 줄세우기
 */
public class _10431 {

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = nextInt(), answer = 0;
    LinkedList<Integer> queue = new LinkedList<>();
    while (--n >= 0) {
      bw.write(nextInt() + " ");
      for (int i = 0; i < 20; i++) {
        int value = nextInt(), indexToAdd = getIndexToAdd(queue, value);
        answer += queue.size() - indexToAdd;
        queue.add(indexToAdd, value);
      }
      bw.write(answer + "\n");
      queue.clear();
      answer = 0;
    }
    bw.flush();
    bw.close();
  }

  private static int getIndexToAdd(LinkedList<Integer> queue, int value) {
    for (int i = 0; i < queue.size(); i++) {
      if (value < queue.get(i)) {
        return i;
      }
    }
    return queue.isEmpty() ? 0 : queue.size();
  }
}

/*
time complexity
O(N)

critical point
삽입 정렬 구현 대신 LinkedList 사용

reference
https://www.acmicpc.net/problem/10431
*/
