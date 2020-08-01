package algo.leetcode.linkedlist;

public class MergeSortedLinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode three = new ListNode(3);
		one.next = three;

		ListNode two = new ListNode(2);

		ListNode mergeTwoLists = mergeTwoLists(one, two);
		LinkedListUtil.print(mergeTwoLists);

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		return helper(l1, l2);

	}

	// 1 3
	// 2
	public static ListNode helper(ListNode a, ListNode b) {

		if (a == null && b == null)
			return null;

		if (a == null)
			return b;

		if (b == null)
			return a;

		if (a.val < b.val) {

			a.next = helper(a.next, b);
			return a;

		} else {

			b.next = helper(b.next, a);
			return b;
		}

	}
}
