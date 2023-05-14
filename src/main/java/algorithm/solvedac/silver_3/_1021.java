package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 회전하는 큐
 */
public class _1021 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    Deque<Integer> numbers = new ConcurrentLinkedDeque<>();
    for (int i = 0; i < n; i++) {
      numbers.offer(i + 1);
    }

    String[] targetString = br.readLine().split(" ");
    int[] targets = new int[targetString.length];
    for (int i = 0; i < targetString.length; i++) {
      targets[i] = Integer.parseInt(targetString[i]);
    }

    int count = 0;
    for (int target : targets) {
      int temp = 0;
      while (numbers.peekFirst() != target) {
        numbers.offerLast(numbers.pollFirst());
        ++temp;
      }
      count += Math.min(temp, numbers.size() - temp);
      numbers.pollFirst();
    }
    System.out.println(count);
  }
}

/*
time complexity
원소의 개수를 n, 뽑아야 할 수 m 이라 할 때
O(nm)

critical point
다음 뽑아야 할 수로 이동할 때 동적으로 변하는 큐의 크기를 고려해야 함

reference
https://www.acmicpc.net/problem/1021
 */