package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Two Sorted Lists
 */
public class _21 {

  public static void main(String[] args) {
    _21 instance = new _21();

    ListNode result = instance.mergeTwoLists(
      new ListNode(1, new ListNode(2, new ListNode(4))),
      new ListNode(1, new ListNode(3, new ListNode(4))));
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return null;
    }

    List<Integer> numbers = new ArrayList<>();
    while (list1 != null || list2 != null) {
      int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
      int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
      if (val1 < val2) {
        numbers.add(val1);
        list1 = list1.next;
      } else {
        numbers.add(val2);
        list2 = list2.next;
      }
    }

    ListNode result = new ListNode();
    visit(result, numbers, 0);
    return result;
  }

  private void visit(ListNode result, List<Integer> numbers, int index) {
    if (index == numbers.size() - 1) {
      result.val = numbers.get(index);
      return;
    }

    result.val = numbers.get(index);
    result.next = new ListNode();
    visit(result.next, numbers, index + 1);
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}

/*
time complexity
O(N)

critical point
1 ms, Beats 5.11%

reference
https://leetcode.com/problems/merge-two-sorted-lists/
*/
