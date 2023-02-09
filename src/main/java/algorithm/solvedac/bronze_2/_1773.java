package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 폭죽쇼
 */
public class _1773 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), c = Integer.parseInt(s[1]);
    int[] cycle = new int[n];
    for (int i = 0; i < n; i++) {
      cycle[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(cycle);
    boolean[] visited = new boolean[c + 1];
    int count = 0;
    for (int i = 1; i <= c; i++) {
      for (int k : cycle) {
        if (i % k == 0 && !visited[i]) {
          visited[i] = true;
          ++count;
          break;
        }
      }
    }
    System.out.println(count);
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    boolean[] isExploded = new boolean[C + 1];
    int explosionTime = 0;

    // 입력과 검증을 합침
    for (int i = 0; i < N; i++) {
      int period = Integer.parseInt(br.readLine());

      // 폭죽이 폭발하지 않은 경우만 수행
      if (!isExploded[period]) {
        // 배수 형태로 늘려가기
        for (int j = period; j <= C; j += period) {
          // 폭발하지 않은 경우만 수행
          if (!isExploded[j]) {
            isExploded[j] = true;
            explosionTime++;
          }
        }
      }
    }

    bw.write(explosionTime + "\n");
    br.close();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
mine 464ms
fast 108ms
폭발하지 않은 경우만 수행시켜 반복을 줄이는 것이 뽀인트
1 ~ C까지 전부 돌리는 것보다 배수 형태로 돌리는 것이 재빠름

reference
https://www.acmicpc.net/problem/1773
 */
