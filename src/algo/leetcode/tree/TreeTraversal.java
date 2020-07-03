package algo.leetcode.tree;

public class TreeTraversal {

	public static void main(String[] args) {

		TreeNode root = TreeUtil.getBSTSample1();
		inOrderTraversal(root);

	}

	public static void inOrderTraversal(TreeNode root) {

		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.val);
			inOrderTraversal(root.right);
		}

	}
}
