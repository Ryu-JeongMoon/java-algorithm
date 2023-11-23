package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 예산
 */
public class _2512_1 {

  public static void main(String[] args) throws IOException, InterruptedException {
    printMaxBudgetByArray();
    printMaxBudgetByPriorityBlockingQueue();
  }

  private static void printMaxBudgetByArray() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] requests = br.readLine().split(" ");
    int budget = Integer.parseInt(br.readLine());

    int total = 0, max = 0;
    int[] budgetRequests = new int[requests.length];
    for (int i = 0; i < requests.length; i++) {
      int request = Integer.parseInt(requests[i]);
      budgetRequests[i] = request;
      total += request;
      max = Math.max(max, request);
    }

    if (total <= budget) {
      System.out.println(max);
      return;
    }

    Arrays.sort(budgetRequests);
    max = budget / n;
    for (int i = 0; i < budgetRequests.length; i++) {
      int budgetRequest = budgetRequests[i];
      if (budgetRequest > max) {
        break;
      } else {
        budget -= budgetRequest;
        max = budget / (n - i - 1);
      }
    }
    System.out.println(max);
  }

  private static void printMaxBudgetByPriorityBlockingQueue() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] requests = br.readLine().split(" ");
    int budget = Integer.parseInt(br.readLine());
    int total = 0, max = 0;
    PriorityBlockingQueue<Integer> budgetRequests = new PriorityBlockingQueue<>(requests.length);
    for (String s : requests) {
      int request = Integer.parseInt(s);
      budgetRequests.offer(request);
      total += request;
      max = Math.max(max, request);
    }

    if (total <= budget) {
      System.out.println(max);
      return;
    }

    max = budget / n;
    while (budgetRequests.size() > 1) {
      int polled = budgetRequests.poll();
      if (polled > max) {
        break;
      } else {
        budget -= polled;
        max = budget / budgetRequests.size();
      }
    }
    System.out.println(max);
  }
}

/*
time complexity
O(NlogN) printMaxBudgetByArray
O(NlogN) printMaxBudgetByPriorityBlockingQueue

critical point
이분탐색으로 풀어야 효율적
위 두 방식은 정렬 후 순차적으로 탐색하는 방식이므로 비효율적

reference
https://www.acmicpc.net/problem/2512
*/
