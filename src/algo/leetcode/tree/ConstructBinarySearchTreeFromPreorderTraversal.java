package algo.leetcode.tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	public static void main(String[] args) {
		new ConstructBinarySearchTreeFromPreorderTraversal().bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
	}

	public TreeNode bstFromPreorder(int[] preorder) {

		TreeNode root = null;

		if (preorder == null || preorder.length < 1) {
			return root;
		}

		for (int i = 0; i < preorder.length; i++) {
			root = addNode(root, preorder[i]);
		}

		return root;
	}

	public TreeNode addNode(TreeNode root, int value) {

		if (root == null) {
			root = new TreeNode(value);
		} else {
			if (value < root.val) {
				root.left = addNode(root.left, value);
			} else {
				root.right = addNode(root.right, value);
			}
		}

		return root;
	}
}
