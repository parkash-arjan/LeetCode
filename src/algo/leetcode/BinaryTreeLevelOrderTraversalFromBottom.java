package algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversalFromBottom {

//	public List<List<Integer>> levelOrderBottom(TreeNode root) {
//
//		Deque<TreeNode> queue = new LinkedList<>();
//		Deque<List<Integer>> stack = new ArrayDeque<>();
//
//		if (root != null) {
//
//			queue.add(root);
//			int level = 1;
//
//			while (!queue.isEmpty()) {
//
//				int nodesToProcess = (int) Math.pow(2.0, level - 1.0);
//
//				level++;
//				List<Integer> tempList = new ArrayList<>();
//				for (int i = 0; i < nodesToProcess; i++) {
//					TreeNode node = queue.poll();
//					if (node != null) {
//						tempList.add(node.val);
//						queue.add(node.left);
//						queue.add(node.right);
//					}else {
//						queue.add(null);
//						queue.add(null);
//					}
//				}
//
//				if (!tempList.isEmpty())
//					stack.push(tempList);
//			}
//
//		}
//		List<List<Integer>> result = new ArrayList<>();
//		while (!stack.isEmpty())
//			result.add(stack.pop());
//		return result;
//	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		Deque<TreeNode> queue = new ArrayDeque<>();
		Deque<List<Integer>> stack = new ArrayDeque<>();
		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {

				List<TreeNode> list = new ArrayList<>();

				while (!queue.isEmpty()) {
					TreeNode tempNode = queue.poll();
					if (tempNode != null)
						list.add(tempNode);
				}

				List<Integer> intList = new ArrayList<>();
				for (TreeNode node : list) {
					intList.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}

				stack.push(intList);
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		while (!stack.isEmpty())
			result.add(stack.pop());
		return result;
	}

	public static void main(String[] args) {

//		TreeNode root =getSample1();
//		TreeNode root =getSample2();
		TreeNode root = getSample3();
		List<List<Integer>> levelOrderBottom = new BinaryTreeLevelOrderTraversalFromBottom().levelOrderBottom(root);

		System.out.println(levelOrderBottom);
	}

	public static TreeNode getSample1() {

		TreeNode root = new TreeNode(1);

		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);

		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = three;

		two.left = four;
		two.right = five;

		three.left = six;
		three.right = seven;

		return root;

	}

	public static TreeNode getSample2() {

		TreeNode three = new TreeNode(3);

		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);

		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);

		three.left = nine;
		three.right = twenty;

		twenty.left = fifteen;
		twenty.right = seven;

		return three;

	}

	public static TreeNode getSample3() {

		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);

		one.left = two;
		two.left = three;
		three.left = four;
		four.left = five;

		return one;

	}
}
