package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 최고의 피자
 */
public class _5545 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), priceOfDough = nextInt(), priceOfTopping = nextInt(), caloryOfDough = nextInt();
    int[] caloriesOfTopping = new int[n];
    for (int i = 0; i < n; i++) {
      caloriesOfTopping[i] = nextInt();
    }
    Arrays.sort(caloriesOfTopping);

    int maxCalory = caloryOfDough, maxPrice = priceOfDough;
    double maxCaloryPerPrice = (double) caloryOfDough / priceOfDough;
    for (int i = n - 1; i >= 0; i--) {
      double caloryPerPrice = (double) (maxCalory + caloriesOfTopping[i]) / (maxPrice + priceOfTopping);
      if (caloryPerPrice > maxCaloryPerPrice) {
        maxCalory += caloriesOfTopping[i];
        maxPrice += priceOfTopping;
        maxCaloryPerPrice = caloryPerPrice;
      } else {
        break;
      }
    }
    System.out.println((int) maxCaloryPerPrice);
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/5545
*/
