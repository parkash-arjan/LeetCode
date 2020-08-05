package algo.leetcode.dp;

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 2));
	}

	public static int uniquePaths(int m, int n) {

		if (m <= 0 && n <= 0)
			return 0;

		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++) {
			matrix[0][i] = 1;
		}

		for (int i = 0; i < n; i++) {
			matrix[i][0] = 1;
		}

		int i = 0;
		int j = 0;

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}

		return matrix[m - 1][n - 1];

	}
}
