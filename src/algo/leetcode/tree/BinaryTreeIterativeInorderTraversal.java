package algo.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeIterativeInorderTraversal {

	public static void main(String[] args) {

		BinaryTreeIterativeInorderTraversal traversal = new BinaryTreeIterativeInorderTraversal();

		TreeNode root = TreeUtil.getBSTSample2();
		List<Integer> inorderTraversal = traversal.inorderTraversal(root);
		System.out.println(inorderTraversal);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> outputList = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			outputList.add(root.val);
			root = root.right;
		}

		return outputList;
	}
}
