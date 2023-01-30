package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이진수 덧셈
 */
public class _1252_2 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    StringBuilder back = new StringBuilder(), front = new StringBuilder();
    while (s[0].length() > 1 && s[0].charAt(0) == '0') {
      s[0] = s[0].substring(1);
    }
    while (s[1].length() > 1 && s[1].charAt(0) == '0') {
      s[1] = s[1].substring(1);
    }

    String max = s[0].length() > s[1].length() ? s[0] : s[1];
    String min = s[0].length() > s[1].length() ? s[1] : s[0];
    int diff = max.length() - min.length();

    int carry = 0;
    for (int i = min.length() - 1; i >= 0; i--) {
      int current = (max.charAt(i + diff) - '0') + (min.charAt(i) - '0') + carry;
      if (current > 1) {
        carry = 1;
        current -= 2;
      } else {
        carry = 0;
      }
      back.append(current);
    }

    if (diff == 0) {
      if (carry != 0) {
        back.append(carry);
      }
      System.out.println(back.reverse());
      return;
    }

    for (int i = diff; i > 0; i--) {
      int origin = max.charAt(i - 1) - '0';
      int current = origin + carry;
      if (carry < 1) {
        front.insert(0, max.substring(0, i));
        break;
      }

      if (current < 2) {
        carry = 0;
      }

      front.insert(0, current > 1 ? current - 2 : current);
      if (i == 1 && carry == 1) {
        front.insert(0, 1);
      }
    }

    StringBuilder result = front.append(back.reverse());
    while (result.length() > 1 && result.charAt(0) == '0') {
      result.deleteCharAt(0);
    }
    System.out.println(result);
  }
}

/*
time complexity
O(n.length)

critical point
1. leading 0를 제거하기 위한 while (length() > 1 && charAt(0) == '0') 활용 반복 제거
2. 첫번째 반복에서는 작은 쪽 길이에 맞추고 carry 처리를 위해 뒤에서부터 연산
3. 두 이진수의 길이가 같은 경우 carry 처리, reverse() 후 출력
4. 두번째 반복에서는 첫번째 반복에서 연산 끝낸 이후부터 반복 시작 (따라서 back, front 나눔)
  4-1. carry 없는 경우, max 제일 앞에서부터 차이나는 길이만큼 잘라 front 전면 추가 후 반복 종료
  4-2. carry 있고 current > 1인 경우, 올림해야 되므로 carry = 1 후 front 전면에 (current - 2) 추가
  4-3. carry 있고 current < 2인 경우, 올림하지 말아야 하므로 carry = 0 후 front 전면에 1 추가, 다음 반복에 4-1 조건을 타 반복 종료됨
  4-4. i == 1 && carry == 1인 경우, front 전면에 1 추가 후 반복 종료
5. back.reverse() 하여 정방향 정렬 후 front 후면에 이어붙임 && leading 0 제거 후 출력

reference
https://www.acmicpc.net/problem/1252
 */