package algorithm.solvedac.bronze_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 2007년
 */
public class _1924 {

  private static final String[] DAY_OF_WEEK = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

  public static void main(String[] args) throws IOException {
    int[] daysPerMonth = new int[12];
    daysPerMonth[1] = 28;
    daysPerMonth[0] = daysPerMonth[2] = daysPerMonth[4] = daysPerMonth[6] = daysPerMonth[7] = daysPerMonth[9] = daysPerMonth[11] = 31;
    daysPerMonth[3] = daysPerMonth[5] = daysPerMonth[8] = daysPerMonth[10] = 30;

    int month = nextInt() - 1, day = nextInt();
    for (int i = 0; i < month; i++) {
      day += daysPerMonth[i];
    }
    System.out.println(DAY_OF_WEEK[day % 7]);
  }
}

/*
time complexity
O(1)

critical point

reference
https://www.acmicpc.net/problem/1924
*/
