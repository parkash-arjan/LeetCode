package algo.leetcode.linkedlist;

public class DeleteNodeLinkedListGivenNode {
	public void deleteNode(ListNode node) {
		ListNode prev = node;
		int val = node.val;

		while (node.next != null) {
			node.val = node.next.val;
			node.next.val = val;
			prev = node;
			node = node.next;

		}

		prev.next = null;

	}
}
