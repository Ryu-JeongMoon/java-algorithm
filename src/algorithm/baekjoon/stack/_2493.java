package algorithm.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑
 */
public class _2493 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Stack<Tower> towers = new Stack<>();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      int heightOfTower = Integer.parseInt(st.nextToken());

      if (towers.isEmpty()) {
        towers.push(new Tower(i, heightOfTower));
        sb.append("0 ");
      } else {
        while (true) {
          if (towers.isEmpty()) {
            towers.push(new Tower(i, heightOfTower));
            sb.append("0 ");
            break;
          }

          Tower latestTower = towers.peek();
          if (latestTower.height > heightOfTower) {
            towers.push(new Tower(i, heightOfTower));
            sb.append(latestTower.index).append(" ");
            break;
          } else {
            towers.pop();
          }
        }
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    System.out.print(sb);
  }

  static class Tower {

    int index;
    int height;

    public Tower(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }
}

/*
탑들의 높이는 1 이상 100,000,000 이하의 정수이다.
5
6 9 5 7 4
 */