package algo.leetcode.dp;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(6));
	}

	public static int climbStairs(int n) {

		if (n < 3)
			return helper(null, n);

		int[] table = new int[n + 1];

		table[0] = 0;
		table[1] = 1;
		table[2] = 2;
		return helper(table, n);
	}

	public static int helper(int[] table, int n) {

		if (n <= 0)
			return 0;

		if (n <= 2)
			return n;

		if (table[n - 1] == 0)
			table[n - 1] = helper(table, n - 1);

		if (table[n - 2] == 0)
			table[n - 2] = helper(table, n - 2);

		return table[n - 1] + table[n - 2];

	}
}
