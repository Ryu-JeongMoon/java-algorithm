package algorithm.leetcode.medium;

/**
 * Add Two Numbers
 */
public class _2 {

  public static void main(String[] args) {
    ListNode l1, l2;

    // [7,0,8]
    l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    System.out.println(addTwoNumbers(l1, l2));

    // [0]
    l1 = new ListNode(0);
    l2 = new ListNode(0);
    System.out.println(addTwoNumbers(l1, l2));

    // [8,9,9,9,0,0,0,1]
    l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
    l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
    System.out.println(addTwoNumbers(l1, l2));
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode(0, new ListNode());
    ListNode current = result;

    int carry = 0;
    while (true) {
      int l1Value = l1 != null ? l1.val : 0;
      int l2Value = l2 != null ? l2.val : 0;
      current.val = l1Value + l2Value + carry;

      if (current.val > 9) {
        current.val %= 10;
        carry = 1;
      } else {
        carry = 0;
      }

      l1 = l1 != null && l1.next != null ? l1.next : null;
      l2 = l2 != null && l2.next != null ? l2.next : null;

      if (carry != 0 || l1 != null || l2 != null) {
        current.next = new ListNode(0);
        current = current.next;
      } else {
        break;
      }
    }
    return result;
  }

  private static class ListNode {

    private int val;
    private ListNode next;

    private ListNode() {
    }

    private ListNode(int val) {
      this.val = val;
    }

    private ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}

/*
time complexity
O(n)

critical point
반환할 ListNode 분리와 참조 이동

reference
https://leetcode.com/problems/add-two-numbers/
*/
