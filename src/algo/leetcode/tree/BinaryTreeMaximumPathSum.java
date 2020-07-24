package algo.leetcode.tree;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();

		// TreeNode tree = TreeUtil.getMaxPathSample1();
		// TreeNode tree = TreeUtil.getMaxPathSample2();
//		TreeNode tree = TreeUtil.getMaxPathSample3();
		TreeNode tree = TreeUtil.getMaxPathSample4();

		System.out.println(sol.maxPathSum(tree));
	}

	private int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return maxSum;
	}

	public int helper(TreeNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		int rootPlusLeft = addInfinity(root.val, left);
		int rootPlusRight = addInfinity(root.val, right);
		int maxRootLeftRight = max(root.val, rootPlusLeft, rootPlusRight);
		maxSum = max(maxSum, maxRootLeftRight, addInfinity(root.val, addInfinity(left, right)), left, right);

		return maxRootLeftRight;
	}

	public int helper2(TreeNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int left = helper2(root.left);
		int right = helper2(root.right);

		int rootPlusLeft = addInfinity(root.val, left);
		int rootPlusRight = addInfinity(root.val, right);
		maxSum = max(maxSum, root.val, rootPlusLeft, rootPlusRight, addInfinity(root.val, addInfinity(left, right)),
				left, right);

		return max(root.val, rootPlusLeft, rootPlusRight);
	}

	public int helper1(TreeNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		maxSum = max(maxSum, root.val, addInfinity(root.val, left), addInfinity(root.val, right),
				addInfinity(root.val, addInfinity(left, right)), left, right);

		return max(root.val, addInfinity(root.val, left), addInfinity(root.val, right));
	}

	public int addInfinity(int a, int b) {

//		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
//			return Integer.MAX_VALUE;		

		if (a == Integer.MIN_VALUE || b == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return a + b;
	}

	public int max(int... nums) {

		int result = Integer.MIN_VALUE;
		if (nums.length == 0)
			return result;

		if (nums.length == 1)
			return nums[0];

		for (int i = 0; i < nums.length; i++) {
			result = Math.max(result, nums[i]);
		}

		return result;
	}

	public boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
