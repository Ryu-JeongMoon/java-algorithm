package algorithm.solvedac.silver_3;

import java.io.IOException;
import java.util.LinkedList;

import algorithm.util.FastIO;

/**
 * 카드 문자열
 */
public class _13417 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();

    int t = io.nextInt();

    LinkedList<Character> chars = new LinkedList<>();
    for (int i = 0; i < t; i++) {
      chars.clear();

      int n = io.nextInt();
      char[] charArray = io.readLine().toCharArray();
      for (int j = 0; j < 2 * n; j += 2) {
        if (!chars.isEmpty() && chars.peek() >= charArray[j]) {
          chars.offerFirst(charArray[j]);
        } else {
          chars.offerLast(charArray[j]);
        }
      }

      for (char c : chars) {
        io.writeBuffer((byte) c);
      }
      io.writeBuffer((byte) '\n');
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
맨 앞 글자와 동일하다면 맨 앞에 추가하는게 사전순으로 더 빠름

reference
https://www.acmicpc.net/problem/13417
*/
