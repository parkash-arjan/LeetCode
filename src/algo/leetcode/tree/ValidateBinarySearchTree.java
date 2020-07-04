package algo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.isBstTest();

		ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
		boolean isValidBST = validator.isValidBST(root);
		System.out.println(isValidBST);
	}

	public boolean isValidBSTIterative(TreeNode root) {

		Deque<Integer> constantStack = new ArrayDeque<>();
		Deque<TreeNode> stack = new ArrayDeque<>();

		while (root != null || !stack.isEmpty()) {

			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();

			// process node
			if (constantStack.isEmpty()) {
				constantStack.push(root.val);
			} else {
				int preVal = constantStack.pop();
				if (preVal >= root.val) {
					return false;
				} else {
					constantStack.push(root.val);
				}
			}

			root = root.right;
		}

		return true;
	}

	public boolean isValidBST(TreeNode root) {
		List<Integer> values = new ArrayList<>();
		inOrderTraversal(root, values);

		if (values.size() <= 1) {
			return true;
		}

		int previous = values.get(0);
		for (int i = 1; i < values.size(); i++) {

			if (previous >= values.get(i)) {
				return false;
			}
			previous = values.get(i);
		}
		return true;
	}

	public void inOrderTraversal(TreeNode root, List<Integer> values) {
		if (root != null) {
			inOrderTraversal(root.left, values);
			values.add(root.val);
			inOrderTraversal(root.right, values);
		}

	}
}
