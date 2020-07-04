package algo.leetcode.linkedlist;

public class LinkedListUtil {

	private LinkedListUtil() {

	}

	public static ListNode getLinkedList() {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;

		return one;
	}

	public static void print(ListNode head) {

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

		System.out.println();
	}
}
