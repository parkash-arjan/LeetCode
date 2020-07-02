package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomListSolution {
	public Node copyRandomList(Node head) {

		Node copiedList = new Node(-1);
		Node dummyList = copiedList;

		Map<Integer, Node> indexNodeMap = new HashMap<>();
		Map<Node, Integer> nodeIndexMap = new HashMap<>();

		Map<Integer, Node> copiedListMap = new HashMap<>();

		int i = 0;
		while (head != null) {
			indexNodeMap.put(i, head.random);
			nodeIndexMap.put(head, i);

			Node temp = new Node(head.val);
			copiedList.next = temp;
			copiedList = copiedList.next;

			copiedListMap.put(i, temp);

			head = head.next;
			i++;
		}

		Node inputListHead = dummyList.next;

		i = 0;
		while (inputListHead != null) {

			Node tempNode = indexNodeMap.get(i);
			if (tempNode == null)
				inputListHead.random = null;
			else {
				Integer tempIndex = nodeIndexMap.get(tempNode);
				inputListHead.random = copiedListMap.get(tempIndex);
			}
			inputListHead = inputListHead.next;
			i++;

		}

		return dummyList.next;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}