package algo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalBFS {
	public void levelOrderBottom(TreeNode root) {

		Queue<TreeNode> queue = new ArrayDeque<>();

		if (root != null) {
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node != null) {
					System.out.println(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
			}
		}

	}

	public static void main(String[] args) {

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
		new BinaryTreeLevelOrderTraversalBFS().levelOrderBottom(root);
	}
}
