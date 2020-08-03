package algo.leetcode.graph;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {

		int islandCount = 0;

		if (grid == null || grid.length == 0) {
			return islandCount;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == '1') {
					islandCount++;
					connectDfs(grid, i, j);
				}

			}

		}
		return islandCount;
	}

	private void connectDfs(char[][] grid, int i, int j) {

		// base cases

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || grid[i][j] == 'V') {
			return;
		}

		grid[i][j] = 'V';

		connectDfs(grid, i, j + 1); // left
		connectDfs(grid, i, j - 1); // right
		connectDfs(grid, i - 1, j); // top
		connectDfs(grid, i + 1, j); // bottom

	}

}
