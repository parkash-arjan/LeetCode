package algo.leetcode;

public class TreeUtil {
	private TreeUtil() {

	}

	public static TreeNode getSample1() {

		TreeNode one = new TreeNode(1);

		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);

		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		one.left = two;
		one.right = three;

		two.left = four;
		two.right = five;

		three.left = six;
		three.right = seven;

		return one;

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

	public static TreeNode getBSTSample1() {

		TreeNode one = new TreeNode(1);

		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);

		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		four.left = two;
		four.right = five;

		two.left = one;
		two.right = three;

		five.left = six;
		five.right = seven;

		return four;

	}

	public static TreeNode isBstTest() {

//		TreeNode one = new TreeNode(1);
//
//		TreeNode three = new TreeNode(3);
//
//		TreeNode four = new TreeNode(4);
//		TreeNode five = new TreeNode(5);
//		TreeNode six = new TreeNode(6);
//
//		five.left = one;
//		five.right = four;
//
//		four.left = three;
//		four.right = six;
//
//		return five;

		TreeNode one = new TreeNode(1);

		TreeNode wrong = new TreeNode(1);

		one.left = wrong;

		return one;

	}
}
