package algo.leetcode.linkedlist;

public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList reverser = new ReverseLinkedList();

		ListNode head = LinkedListUtil.getLinkedList();
		LinkedListUtil.print(head);
		ListNode reverse = reverser.reverse(head);
		LinkedListUtil.print(reverse);
	}

	public ListNode reverse(ListNode head) {
		return null;
	}
}
