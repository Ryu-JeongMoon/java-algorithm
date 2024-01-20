package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 스위치 켜고 끄기
 */
public class _1244 {

  public static void main(String[] args) throws IOException {
    int[] switches = new int[nextInt()];
    for (int i = 0; i < switches.length; i++) {
      switches[i] = nextInt();
    }

    int theNumberOfStudents = nextInt();
    for (int i = 0; i < theNumberOfStudents; i++) {
      int sex = nextInt(), target = nextInt();
      if (sex == 1) {
        for (int j = target - 1; j < switches.length; j += target) {
          switches[j] = (switches[j] + 1) % 2;
        }
      } else {
        int prev = target - 1, next = target - 1;
        while (prev >= 0 && next < switches.length && switches[prev] == switches[next]) {
          --prev;
          ++next;
        }

        for (int j = prev + 1; j < next; j++) {
          switches[j] = (switches[j] + 1) % 2;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0, count = 1; i < switches.length; i++, count++) {
      if (count > 20) {
        count = 1;
        sb.append("\n");
      }
      sb.append(switches[i]).append(" ");
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(n)

critical point
입력으로 주어지는 타겟 스위치와 인덱스의 시작 숫자가 다름 주의
입력 1, 2, 3... 인덱스 0, 1, 2...

prev, next 비교 중 현재 prev, next 가 동일할 시 --prev, ++next
즉 마지막에 지정된 prev, next 는 switches[prev] != switches[next]
혹은 prev < 0 or next > switches.length - 1
두 경우 스위치 변화 대상의 범위를 벗어났으므로
스위치를 변경시킬 땐 (prev+1) ~ (next-1)까지 변화 시켜야 함

reference
https://www.acmicpc.net/problem/1244
*/
