package algo.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeleteNodesAndReturnForest {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getSample1();
		TreeInoderTraversal.inOrderTraversal(root);
		List<TreeNode> delNodes = delNodes(root, new int[] { 3, 5 });

		for (TreeNode tree : delNodes) {
			System.out.println();
			TreeInoderTraversal.inOrderTraversal(tree);

		}
	}

	public static List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
		List<TreeNode> forest = new ArrayList<>();
		if (root == null) {
			return forest;
		}
		// Set<Integer> set = new
		// HashSet<>(IntStream.of(toDelete).boxed().collect(Collectors.toList()));
		Set<Integer> set = new HashSet<>();
		for (int i : toDelete) {
			set.add(i);
		}

		postOrderProcessingRefactor(root, set, forest);

		if (!set.contains(root.val)) {
			forest.add(root);
		}
		return forest;

	}

	private static void postOrderProcessing(TreeNode root, Set<Integer> setToDelete, List<TreeNode> forest) {

		if (root == null) {
			return;
		}

		postOrderProcessing(root.left, setToDelete, forest);
		postOrderProcessing(root.right, setToDelete, forest);

		if (setToDelete.contains(root.val)) {
			if (root.left != null) {
				if (setToDelete.contains(root.left.val)) {
					root.left = null;
				} else {
					forest.add(root.left);
				}

			}

			if (root.right != null) {
				if (setToDelete.contains(root.right.val)) {
					root.right = null;
				} else {
					forest.add(root.right);
				}

			}

		}

		if (root.left != null && setToDelete.contains(root.left.val))
			root.left = null;
		if (root.right != null && setToDelete.contains(root.right.val))
			root.right = null;

	}

	private static void postOrderProcessingRefactor(TreeNode root, Set<Integer> setToDelete, List<TreeNode> forest) {

		if (root == null) {
			return;
		}

		postOrderProcessing(root.left, setToDelete, forest);
		postOrderProcessing(root.right, setToDelete, forest);

		if (setToDelete.contains(root.val) && root.left != null) {
			if (setToDelete.contains(root.left.val)) {
				root.left = null;
			} else {
				forest.add(root.left);
			}

		}

		if (setToDelete.contains(root.val) && root.right != null) {
			if (setToDelete.contains(root.right.val)) {
				root.right = null;
			} else {
				forest.add(root.right);
			}

		}

		if (root.left != null && setToDelete.contains(root.left.val))
			root.left = null;
		if (root.right != null && setToDelete.contains(root.right.val))
			root.right = null;

	}

	private static void postOrderProcessingRefactorV3(TreeNode parent, TreeNode root, Set<Integer> setToDelete,
			List<TreeNode> forest) {

		if (root == null) {
			return;
		}

		postOrderProcessingRefactorV3(root, root.left, setToDelete, forest);
		postOrderProcessingRefactorV3(root, root.right, setToDelete, forest);

		if (setToDelete.contains(root.val)) {
			if (root.left != null) {
				forest.add(root.left);
			}

			if (root.right != null) {
				forest.add(root.right);
			}

			if (parent != null) {
				if (parent.left != null && parent.left.val == root.val) {
					parent.left = null;
				}
				if (parent.right != null && parent.right.val == root.val) {
					parent.right = null;
				}
			}
		}

	}

	public List<TreeNode> delNodesV2(TreeNode root, int[] toDelete) {
		List<TreeNode> forest = new ArrayList<>();
		if (root == null) {
			return forest;
		}

		Set<Integer> set = new HashSet<>();

		for (int i : toDelete) {
			set.add(i);
		}

		postOrderProcessingRefactorV4(root, set, forest);

		if (!set.contains(root.val)) {
			forest.add(root);
		} else {
			addTreeToForeset(root, forest);
		}
		return forest;
	}

	private static void postOrderProcessingRefactorV4(TreeNode root, Set<Integer> setToDelete, List<TreeNode> forest) {

		if (root == null) {
			return;
		}

		postOrderProcessingRefactorV4(root.left, setToDelete, forest);
		postOrderProcessingRefactorV4(root.right, setToDelete, forest);

		deleteNode(root, setToDelete, forest); // delete if child node has values in delete set.

	}

	private static void deleteNode(TreeNode root, Set<Integer> setToDelete, List<TreeNode> forest) {

		if (root.left != null && setToDelete.contains(root.left.val)) {
			addTreeToForeset(root.left, forest);
			root.left = null;
		}

		if (root.right != null && setToDelete.contains(root.right.val)) {
			addTreeToForeset(root.right, forest);
			root.right = null;
		}
	}

	private static void addTreeToForeset(TreeNode root, List<TreeNode> forest) {

		if (root.left != null) {
			forest.add(root.left);
		}

		if (root.right != null) {
			forest.add(root.right);
		}
	}

}
