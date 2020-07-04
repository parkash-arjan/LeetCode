package algo.leetcode.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) {

		OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
		ListNode head = LinkedListUtil.getLinkedList();

		LinkedListUtil.print(head);
		ListNode oddEvenList = oddEvenLinkedList.oddEvenList(head);
		LinkedListUtil.print(oddEvenList);

	}

	public ListNode oddEvenList(ListNode head) {
		ListNode odd = new ListNode(-1);
		ListNode even = new ListNode(-1);
		ListNode oddHead = odd;
		ListNode evenHead = even;

		int count = 0;

		while (head != null) {

			count++;
			if (count % 2 == 0) {
				even.next = head;
				even = even.next;
			} else {
				odd.next = head;
				odd = odd.next;
			}

			head = head.next;

		}

		odd.next = evenHead.next;
		even.next = null;

		return oddHead.next;
	}

}
