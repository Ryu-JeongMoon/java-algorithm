package algorithm.algorithmbyimages.chap04;

import java.util.Vector;

public class VectorTest {

  public static void main(String[] args) {
    Vector<Integer> vector = new Vector<>();

    vector.add(5);
    vector.add(4);
    vector.add(-1);

    vector.add(2, 100);

    System.out.println("vector.size() = " + vector.size());
    System.out.println("vector.capacity() = " + vector.capacity());

    for (Integer integer : vector) {
      System.out.println("integer = " + integer);
    }
  }
}
