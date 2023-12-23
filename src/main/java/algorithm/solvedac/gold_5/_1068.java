package algorithm.solvedac.gold_5;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 트리
 */
public class _1068 {

  private static int n, root, count = 0;
  private static int[] parents;
  private static boolean[] visited, deleted;

  public static void main(String[] args) throws NumberFormatException, IOException {
    n = nextIntWithNegative();
    parents = new int[n];
    visited = new boolean[n];
    deleted = new boolean[n];

    for (int i = 0; i < n; i++) {
      parents[i] = nextIntWithNegative();
      if (parents[i] == -1) {
        root = i;
      }
    }

    deleteNode(nextIntWithNegative());
    countLeaf(root);
    System.out.println(count);
  }

  private static void countLeaf(int idx) {
    visited[idx] = true;
    if (parents[idx] == -2) {
      return;
    }

    boolean isLeaf = true;
    for (int i = 0; i < n; i++) {
      if (parents[i] == idx && !visited[i]) {
        countLeaf(i);
        isLeaf = false;
      }
    }

    if (isLeaf) {
      count++;
    }
  }

  private static void deleteNode(int idx) {
    parents[idx] = -2;
    deleted[idx] = true;

    for (int i = 0; i < n; i++) {
      if (!deleted[i] && parents[i] == idx) {
        deleteNode(i);
      }
    }
  }
}

/*
time complexity
O(n)

critical point
재귀적 삭제, 재귀적 카운트

reference
https://www.acmicpc.net/problem/1068
*/
