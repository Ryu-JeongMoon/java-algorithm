package algorithm.programmers.level3;

import java.util.HashSet;
import java.util.Set;

/**
 * 네트워크
 */
public class _43162 {

  public static void main(String[] args) {
    _43162 instance = new _43162();
    System.out.println(instance.solutionByArray(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
    System.out.println(instance.solutionByArray(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
    System.out.println(instance.solutionByArray(4, new int[][] { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } }));
    System.out.println(instance.solutionBySet(3, new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
    System.out.println(instance.solutionBySet(3, new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
    System.out.println(instance.solutionBySet(4, new int[][] { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 1 } }));
  }

  public int solutionByArray(int n, int[][] computers) {
    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visitByArray(visited, computers, i);
        ++count;
      }
    }
    return count;
  }

  private void visitByArray(boolean[] visited, int[][] computers, int index) {
    visited[index] = true;
    for (int i = 0; i < computers[index].length; i++) {
      if (computers[index][i] == 1 && !visited[i]) {
        visitByArray(visited, computers, i);
      }
    }
  }

  public int solutionBySet(int n, int[][] computers) {
    Set<Integer> networks = new HashSet<>(n);
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!networks.contains(i)) {
        visitBySet(networks, computers, i);
        ++count;
      }
    }
    return count;
  }

  private void visitBySet(Set<Integer> networks, int[][] computers, int index) {
    networks.add(index);
    for (int i = 0; i < computers[index].length; i++) {
      if (computers[index][i] == 1 && !networks.contains(i)) {
        visitBySet(networks, computers, i);
      }
    }
  }
}

/*
visitByArray                                visitBySet
테스트 1  〉	통과 (0.03ms, 73.8MB)         테스트 1  〉	통과 (0.06ms, 71.8MB)
테스트 2  〉	통과 (0.04ms, 78.1MB)         테스트 2  〉	통과 (0.06ms, 68.6MB)
테스트 3  〉	통과 (0.03ms, 73.3MB)         테스트 3  〉	통과 (0.12ms, 78MB)
테스트 4  〉	통과 (0.05ms, 79.5MB)         테스트 4  〉	통과 (0.15ms, 67.4MB)
테스트 5  〉	통과 (0.02ms, 73.6MB)         테스트 5  〉	통과 (0.05ms, 72.1MB)
테스트 6  〉	통과 (0.07ms, 73MB)           테스트 6  〉	통과 (1.10ms, 67.9MB)
테스트 7  〉	통과 (0.02ms, 75.3MB)         테스트 7  〉	통과 (0.08ms, 71.4MB)
테스트 8  〉	통과 (0.06ms, 76.2MB)         테스트 8  〉	통과 (0.15ms, 78.4MB)
테스트 9  〉	통과 (0.05ms, 74.4MB)         테스트 9  〉	통과 (0.10ms, 74.8MB)
테스트 10 〉	통과 (0.05ms, 73.1MB)         테스트 10 〉	통과 (0.17ms, 76.9MB)
테스트 11 〉	통과 (0.35ms, 74.9MB)         테스트 11 〉	통과 (0.60ms, 77.2MB)
테스트 12 〉	통과 (0.32ms, 78.1MB)         테스트 12 〉	통과 (0.51ms, 75.7MB)
테스트 13 〉	통과 (0.09ms, 77.6MB)         테스트 13 〉	통과 (0.25ms, 73.8MB)

time complexity
O(N^2)

critical point
방문 여부 확인용 자료구조 사용, 중복 방문 방지

reference
https://programmers.co.kr/learn/courses/30/lessons/43162
*/
