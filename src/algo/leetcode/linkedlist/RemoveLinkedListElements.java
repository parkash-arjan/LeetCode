package algo.leetcode.linkedlist;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode linkedList = LinkedListUtil.getLinkedListRandom(5, 4);
		// ListNode linkedList = LinkedListUtil.getLinkedList(3);
		LinkedListUtil.print(linkedList);

		RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
		ListNode removeElements = removeLinkedListElements.removeElements(linkedList, 2);
		LinkedListUtil.print(removeElements);
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode current = head;
		ListNode previous = null;
		while (current != null) {
			if (current.val == val) {
				if (previous == null) {
					head = current.next;
					current = current.next;
				} else {
					previous.next = current.next;
					current = current.next;
				}
			} else {
				previous = current;
				current = current.next;
			}
		}

		// we remove from each section and can have it at the end statement within while
		// loop since it is common statement.
		return head;
	}

}
