package algorithm.algorithmbyimages.chap04.etc;

public class Change {

  private static final int[] coinTypes = { 500, 100, 50, 10 };

  public static void main(String[] args) {
    changeCoin(1260);
  }

  private static void changeCoin(int n) {
    int count = 0;

    for (int i = 0; i < coinTypes.length; i++) {
      count += n / coinTypes[i];
      n %= coinTypes[i];
      System.out.printf("count = %d : coin = %d\n", count, coinTypes[i]);
    }
  }
}
