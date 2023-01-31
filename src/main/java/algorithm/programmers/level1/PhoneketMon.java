package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneketMon {

  public static void main(String[] args) {
    int[] nums = { 3, 3, 3, 2, 2, 2 };
    System.out.println(solution(nums));
  }

  static int solution(int[] nums) {
    Set<Integer> phoneketMonSet = new HashSet<>();
    Arrays.stream(nums).forEach(n -> phoneketMonSet.add(n));
    return Math.min(nums.length / 2, phoneketMonSet.size());
  }
}
