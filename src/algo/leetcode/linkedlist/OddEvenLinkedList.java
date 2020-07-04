package algo.leetcode.linkedlist;

public class OddEvenLinkedList {

	public static void main(String[] args) {

		OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
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

		oddEvenLinkedList.print(one);
		ListNode oddEvenList = oddEvenLinkedList.oddEvenList(one);
		oddEvenLinkedList.print(oddEvenList);

	}

	public void print(ListNode head) {

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

		System.out.println();
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
