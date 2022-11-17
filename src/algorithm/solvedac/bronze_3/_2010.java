package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 플러그
 */
public class _2010 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int theNumberOfMultiTaps = Integer.parseInt(br.readLine());
    int totalConnectableComputers = 0;

    for (int i = 0; i < theNumberOfMultiTaps; i++) {
      int theNumberOfPlugs = Integer.parseInt(br.readLine());
      totalConnectableComputers += theNumberOfPlugs;
    }

    System.out.println(totalConnectableComputers - (theNumberOfMultiTaps - 1));
  }
}
/*
time complexity
입력값 마다 for-loop 돌려야 하므로 O(n)

critical point
각 멀티탭 마다 앞선 멀티탭에 연결시켜야 하고
마지막 멀티탭은 제한이 없으므로 (총 멀티탭 개수 - 1) 만큼 빼줘야 한다.

3
1
1
1

2
5
8
 */
