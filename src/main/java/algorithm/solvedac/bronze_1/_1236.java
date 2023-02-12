package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 성 지키기
 */
public class _1236 {

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    solution2();
    long end = System.currentTimeMillis();
    System.out.println("time: " + (end - start) + "ms");
  }

  public static void solution1() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
    String guard = "X";
    int totalRow = 0, totalColumn = 0;
    boolean[] visitedColumn = new boolean[m];
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      if (!line.contains(guard)) {
        ++totalRow;
      }

      for (int j = 0; j < line.length(); j++) {
        if (!visitedColumn[j] && line.charAt(j) == guard.charAt(0)) {
          visitedColumn[j] = true;
        }
      }
    }
    for (boolean visited : visitedColumn) {
      if (!visited) {
        ++totalColumn;
      }
    }
    System.out.println(Math.max(totalRow, totalColumn));
  }

  public static void solution2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
    String security = "X";
    int totalRow = 0;
    LinkedList<Integer> notVisitedIndexes = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      notVisitedIndexes.add(i);
    }
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      if (!line.contains(security)) {
        ++totalRow;
      }
      notVisitedIndexes.removeIf(notVisitedIndex -> line.charAt(notVisitedIndex) == security.charAt(0));
    }
    System.out.println(Math.max(totalRow, notVisitedIndexes.size()));
  }
}

/*
time complexity
O(n * m)

critical point
1. 매 반복 마다 배열 전체 순회
2. 방문하지 않은 열만 확인하면 되도록 LinkedList 사용

실제 제출 시 결과는 다음과 같음
배열 vs LinkedList 비용 차이 때문인 것으로 생각 됨
solution1 - 80ms
solution2 - 224ms

reference
https://www.acmicpc.net/problem/1236
 */