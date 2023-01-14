package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 트로피 진열
 */
public class _1668 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] leftArr = new int[n], rightArr = new int[n];
    for (int i = 0; i < n; i++) {
      int height = Integer.parseInt(br.readLine());
      leftArr[i] = height;
      rightArr[n - 1 - i] = height;
    }

    int left = 0, right = 0, leftPrevious = 0, rightPrevious = 0;
    for (int i = 0; i < n; i++) {
      if (leftPrevious < leftArr[i]) {
        ++left;
        leftPrevious = leftArr[i];
      }
      if (rightPrevious < rightArr[i]) {
        ++right;
        rightPrevious = rightArr[i];
      }
    }
    System.out.println(left + "\n" + right);
  }
}

/*
time complexity
O(n)

critical point
1) 오른쪽에서 볼 때는 높이를 역순으로 넣어줌
2) 역순으로 넣어줬기 때문에 비교 시에 정순으로 비교해야 함
left - [1, 2, 3, 4, 5]
right - [5, 4, 3, 2, 1]

reference
https://www.acmicpc.net/problem/1668
 */