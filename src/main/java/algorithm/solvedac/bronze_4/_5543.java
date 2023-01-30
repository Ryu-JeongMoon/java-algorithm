package algorithm.solvedac.bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 상근날드
 */
public class _5543 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int burger1 = Integer.parseInt(br.readLine());
    int burger2 = Integer.parseInt(br.readLine());
    int burger3 = Integer.parseInt(br.readLine());
    int drink1 = Integer.parseInt(br.readLine());
    int drink2 = Integer.parseInt(br.readLine());

    int price = Math.min(burger1, Math.min(burger2, burger3)) + Math.min(drink1, drink2) - 50;
    System.out.println(price);
  }
}

/*
time complexity
O(1)

critical point

 */