package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자메시지
 */
public class _2037 {

  private static final int[] GROUP_INDICES = new int[] { 0, 3, 6, 9, 12, 15, 19, 22 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(tokenizer.nextToken()), w = Integer.parseInt(tokenizer.nextToken()), sum = 0, previousGroupIndex = -1;
    for (char c : br.readLine().toCharArray()) {
      if (Character.isSpaceChar(c)) {
        sum += p;
        previousGroupIndex = -1;
      } else {
        int groupIndex = findGroupIndex(c);
        if (groupIndex == previousGroupIndex) {
          sum += w;
        }
        sum += p * (c - 'A' - GROUP_INDICES[groupIndex] + 1);
        previousGroupIndex = groupIndex;
      }
    }
    System.out.println(sum);
  }

  private static int findGroupIndex(char c) {
    int current = c - 'A';
    for (int i = 0; i < GROUP_INDICES.length; i++) {
      if (current < GROUP_INDICES[i]) {
        return i - 1;
      }
    }
    return GROUP_INDICES.length - 1;
  }
}

/*
time complexity
N = input.length
O(N)

critical point
공백 문자일 때 이전 인덱스 그룹 변경 필요

reference
https://www.acmicpc.net/problem/2037
*/
