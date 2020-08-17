package algo.leetcode.dp;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();

		char[][] board = new char[][] { { 'A', 'B' }, { 'C', 'D' } };
		// char[][] board = new char[][] { { 'A' } };

		System.out.println(wordSearch.exist(board, "ABDCX"));
	}

	private boolean isFound = false;

	public boolean exist(char[][] board, String word) {

		if (word == null || word.trim().length() == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0) && !isFound) {
					explore(board, i, j, new StringBuilder(word));
				}
			}
		}
		return isFound;
	}

	public void explore(char[][] board, int i, int j, StringBuilder word) {

		if (!isFound) {
			isFound = word.length() == 0;

			// check array bounds
			if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
				return;
			}

			if (board[i][j] == '1') {
				return;
			}

			if (!isFound && board[i][j] == word.charAt(0)) {

				char temp = board[i][j];
				board[i][j] = '1';
				StringBuilder substring = new StringBuilder(word).deleteCharAt(0);
				explore(board, i, j + 1, substring); // left
				explore(board, i, j - 1, substring); // right
				explore(board, i - 1, j, substring); // top
				explore(board, i + 1, j, substring); // bottom
				board[i][j] = temp;
			}
		}
	}

}