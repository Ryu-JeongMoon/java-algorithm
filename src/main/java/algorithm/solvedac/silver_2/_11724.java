package algorithm.solvedac.silver_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 연결 요소의 개수
 */
public class _11724 {

  public static void main(String[] args) throws IOException {
    int numberOfVertex = nextInt(), numberOfEdge = nextInt();
    boolean[] visited = new boolean[numberOfVertex];

    List<List<Integer>> relations = new ArrayList<>();
    for (int i = 0; i < numberOfVertex; i++) {
      relations.add(i, new ArrayList<>());
    }

    for (int i = 0; i < numberOfEdge; i++) {
      int key = nextInt() - 1, value = nextInt() - 1;
      relations.get(key).add(value);
      relations.get(value).add(key);
    }

    System.out.println(dfs(relations, visited));
  }

  private static int nextInt() throws IOException {
    int sum = 0;
    while (true) {
      int input = System.in.read();
      if (input == '\n' || input == ' ') {
        return sum;
      } else {
        sum = (sum * 10) + input - '0';
      }
    }
  }

  private static int dfs(List<List<Integer>> relations, boolean[] visited) {
    int count = 0;
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        visitAll(relations, visited, i);
        ++count;
      }
    }
    return count;
  }

  private static void visitAll(List<List<Integer>> relations, boolean[] visited, int key) {
    if (visited[key]) {
      return;
    } else {
      visited[key] = true;
    }

    List<Integer> adjacentElements = relations.get(key);
    for (int adjacentElement : adjacentElements) {
      visitAll(relations, visited, adjacentElement);
    }
  }
}

/*
time complexity
V: number of vertex
E: number of edge
O(V + E)

critical point
union-find ?!

reference
https://www.acmicpc.net/problem/11724
*/
