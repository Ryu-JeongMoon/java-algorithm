package algorithm.leetcode.easy;

/**
 * Merge Two Sorted Lists
 */
public class _21_2 {

  public static void main(String[] args) {
    _21_2 instance = new _21_2();

    _21.ListNode result = instance.mergeTwoLists(
      new _21.ListNode(1, new _21.ListNode(2, new _21.ListNode(4))),
      new _21.ListNode(1, new _21.ListNode(3, new _21.ListNode(4))));
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public _21.ListNode mergeTwoLists(_21.ListNode l1, _21.ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}

/*
time complexity
O(N)

critical point
0 ms, Beats 100.00%

reference
https://leetcode.com/problems/merge-two-sorted-lists/
*/
