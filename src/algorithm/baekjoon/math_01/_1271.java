package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 엄청난 부자2
 */
public class _1271 {

  public static void main(String[] args) throws IOException {
    String[] moneyAndLivingThings = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    BigDecimal money = new BigDecimal(moneyAndLivingThings[0]);
    BigDecimal livingThings = new BigDecimal(moneyAndLivingThings[1]);

    BigDecimal share = money.divide(livingThings, RoundingMode.DOWN);
    BigDecimal remains = money.subtract(share.multiply(livingThings));

    System.out.println(share);
    System.out.println(remains);
  }
}

/*
1000 100

10 - 분배할 수 있는 돈
0  - 분배할 수 없어 남는 돈

제한은 10^1000
1억 -> 10^8
O(n)이어선 안 된다, O(log n) 이하여야 한다
 */
