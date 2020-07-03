package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.isBstTest();

		ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
		boolean isValidBST = validator.isValidBST(root);
		System.out.println(isValidBST);
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
