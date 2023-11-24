package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 햄버거 사랑
 */
public class _1980 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), t = nextInt();
    int lighter = Math.min(n, m), heavier = Math.max(n, m);
    int theNumberOfLighter = t / lighter, maxBurgers = theNumberOfLighter;
    int theNumberOfHeavier = 0, remains = t % lighter, currentTime = lighter * theNumberOfLighter;
    while (--theNumberOfLighter >= 0 && remains != 0) {
      currentTime -= lighter;
      if (currentTime + heavier <= t) {
        currentTime += heavier;
        ++theNumberOfHeavier;
        if (t - currentTime < remains) {
          maxBurgers = theNumberOfLighter + theNumberOfHeavier;
          remains = t - currentTime;
        }
      }
    }
    System.out.println(maxBurgers + " " + remains);
  }
}

/*
time complexity
O(t / Math.min(n, m))

critical point
햄버거 먹는 개수가 줄어들더라도 콜라 마시는 시간을 최소화해야 함, 콜라 마시는 시간이 같다면 햄최몇
먹는 시간에 따라 lighter, heavier 구분
시간이 먹는데 적게 걸리는 것(lighter)으로 나누어 떨어지지 않는 경우
lighter 빼나가고 시간을 초과하지 않는 경우 heavier 더해줌
최초의 먹을 수 있는 햄버거 최대 개수(theNumberOfLighter)를 기준으로 하나씩 줄여나가 0이 되는 순간까지 확인
콜라 마시는 시간 경우의 수가 0이 없는 경우를 위함

reference
https://www.acmicpc.net/problem/1980
*/
