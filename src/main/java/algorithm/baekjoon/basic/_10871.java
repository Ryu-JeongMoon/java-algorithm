package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * X보다 작은 수
 */
public class _10871 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    List<String> numList = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      String nextToken = st.nextToken();
      int nextValue = Integer.parseInt(nextToken);

      if (nextValue < x) {
        numList.add(nextToken);
      }
    }

    System.out.println(String.join(" ", numList));
  }
}

/*
Java / Python
메모리는 8배 차이지만 코드 길이 오마이갓..

메모리	시간	언어	코드 길이
15536	200	Java 11 / 수정	884B
123496	124	PyPy3 / 수정	147B
 */