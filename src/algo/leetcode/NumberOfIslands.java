package algo.leetcode;

public class NumberOfIslands {

	public static void main(String[] args) {

//		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
//				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };

		char[][] grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

		System.out.println(new NumberOfIslands().numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int islandCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// System.out.println(explore(grid, i, j, 0));
				islandCount = islandCount + explore(grid, i, j, 0);
			}
		}

		return islandCount;
	}

	public int explore(char[][] grid, int x, int y, int count) {

		if (x == -1 || y == -1 || x >= grid.length || y >= grid[x].length) {
			return 0;
		}

		if (grid[x][y] == '0') {
			return 0;
		}

		if (grid[x][y] == '+') {
			return 0;
		}

		if (grid[x][y] == '1') {
			count++;
			grid[x][y] = '+';
		}

		explore(grid, x, y + 1, count);
		explore(grid, x, y - 1, count);
		explore(grid, x - 1, y, count);
		explore(grid, x + 1, y, count);

		return count;
	}

}
