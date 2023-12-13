package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Stack;

/**
 * 물병
 */
public class _1052 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), k = nextInt(), exponent;
    Stack<Integer> stack = new Stack<>();
    while ((exponent = (int) (Math.log(n) / Math.log(2))) >= 0) {
      stack.add((int) Math.pow(2, exponent));
      n -= (int) Math.pow(2, exponent);
    }

    int count = 0;
    if (stack.size() > k) {
      while (stack.size() > k) {
        count += stack.pop();
      }
      count = stack.pop() - count;
    }
    System.out.println(count);
  }
}

/*
time complexity
O(logN)

critical point
스택 & log2를 사용해 최소 물병 개수로 세팅
n=1,000,000, k=5인 경우
stack = [2^19, 2^18, 2^17, 2^16, 2^14, 2^9, 2^6]
물병의 개수는 5개 이하여야 하므로 2^9, 2^6을 없애야 한다
물병 개수를 줄이기 위해서는 스택의 마지막 값에 동일한 값을 더해나가 다음 값과 동일한 값을 만들어야 함
이 예시에서는 2^9, 2^6 두 값을 없애기 위해서는 두 값을 이용해 2^14에 더할 수 있는 값을 만들어야 한다
2^14 - 2^9 - 2^6 = 15,808

1. 스택의 사이즈가 k와 같기 전까지의 값을 더하고
2^9 + 2^6 = 1,280
2. 스택의 마지막 값에서 빼면 구매해야 할 물병 개수를 구할 수 있다
2^14 - 1,280 = 15,808

reference
https://www.acmicpc.net/problem/1052
*/
