package algo.leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " → ");
			node = node.next;
		}
		System.out.print("Null");
		System.out.println();
	}

	public static ListNode linkedList(int[] arr) {
		ListNode dummyNode = new ListNode(-1);
		ListNode head = dummyNode;
		for (int i = 0; i < arr.length; i++) {
			head.next = new ListNode(arr[i]);
			head = head.next;
		}
		return dummyNode.next;
	}

}
