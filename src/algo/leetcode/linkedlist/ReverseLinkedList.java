package algo.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList reverser = new ReverseLinkedList();

		ListNode head = LinkedListUtil.getLinkedList(3);
		LinkedListUtil.print(head);

		// ListNode reverse = reverser.reverseRecursive(head);
		ListNode reverse = reverser.reverseRecursive_v2(head);

		LinkedListUtil.print(reverse);

	}

	ListNode tempHeadGlobal = new ListNode(-1);
	ListNode newHeadGlobal = tempHeadGlobal;

	public ListNode reverseRecursive(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		reverseHelper(head);
		return newHeadGlobal.next;
	}

	public void reverseHelper(ListNode head) {

		if (head != null) {
			reverseHelper(head.next);
			tempHeadGlobal.next = head;
			tempHeadGlobal = tempHeadGlobal.next;
			head.next = null;
		}

	}

	public ListNode reverseRecursive_v2(ListNode head) {
		ListNode tempHead = new ListNode(-1);
		ListNode newHead = tempHead;
		if (head == null || head.next == null) {
			return head;
		}
		reverseHelper_v2(head, tempHead);
		return newHead.next;
	}

	public ListNode reverseHelper_v2(ListNode head, ListNode tempHead) {

		if (head != null) {
			tempHead = reverseHelper_v2(head.next, tempHead);
			tempHead.next = head;
			tempHead = tempHead.next;
			head.next = null;
		}
		return tempHead;
	}

	public ListNode reverseWithStack(ListNode head) {
		Deque<ListNode> stack = new ArrayDeque<>();

		while (head != null) {
			stack.push(head);
			head = head.next;
		}

		ListNode tempNode = new ListNode(-1);
		ListNode newHeadNode = tempNode;

		while (!stack.isEmpty()) {
			ListNode node = stack.pop();
			tempNode.next = node;
			tempNode = tempNode.next;
			node.next = null;
		}
		return newHeadNode.next;
	}

	public ListNode reverseIterative(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}

		ListNode previous = null;
		ListNode current = head;
		ListNode next = current;

		// N ←1 	←		2	←    3←		4		    Null
		// 														↑c
		// 														↑n
		// 											↑p
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}

		return previous;
	}

	public void printReverse(ListNode head) {
		if (head != null) {
			printReverse(head.next);
			System.out.println(head.val);
		}
	}

}
