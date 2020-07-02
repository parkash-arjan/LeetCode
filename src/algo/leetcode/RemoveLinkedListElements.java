package algo.leetcode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// ListNode head = ListNode.linkedList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
		ListNode head = ListNode.linkedList(new int[] { 6 });
		ListNode.print(head);
		ListNode result = RemoveLinkedListElements.removeElements(head, 6);
		ListNode.print(result);
	}

	public static ListNode removeElements(ListNode head, int val) {

		if (head == null)
			return null;

		ListNode result = head;
		ListNode prev = null;
		// 			┌──────�?
		// Null		6 → 6 → Null
		// 			↑
		// ↑
		// 		1	2	3 6 5 	↑
						
		while (head != null) {
			
		}

		return result;

	}

}
