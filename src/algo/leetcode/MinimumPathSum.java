package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {

	private Map<String, Integer> table = new HashMap<>();

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
//		int[][] grid = new int[][] { { 1, 1 }, { 3, 4 } };
//		// int[][] grid = new int[][] { { 1, 2 } };
		System.out.println(new MinimumPathSum().minPathSum(grid));
	}

	public int minPathSum(int[][] grid) {

		return explore(grid, 0, 0);
	}

	public int explore(int grid[][], int x, int y) {
		Integer value = table.get(x + "," + y);

		if (value != null)
			return value;

		if (x == grid.length - 1 && y == grid[x].length - 1) {
			table.put(x + "," + y, grid[x][y]);
			return grid[x][y];
		}

		if (x >= grid.length || y >= grid[x].length) {
			return Integer.MAX_VALUE;
		}
		
		int sum = grid[x][y] + Math.min(explore(grid, x, y + 1), explore(grid, x + 1, y));
		table.put(x + "," + y, sum);
		return sum;

	}

}
