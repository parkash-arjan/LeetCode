package algo.leetcode.dp;

public class WordSearch {

	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (explore(board, i, j, new StringBuilder(word))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean explore(char[][] board, int i, int j, StringBuilder word) {

		// check array bounds

		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
			return false;
		}

		if (board[i][j] == '1') {
			return false;
		}

		if (board[i][j] == word.charAt(0) && word.length() >= 1) {

			char temp = board[i][j];
			board[i][j] = '1';
			StringBuilder substring = word.deleteCharAt(0);
			explore(board, i, j + 1, substring); // left
			explore(board, i, j - 1, substring); // right
			explore(board, i - 1, j, substring); // top
			explore(board, i + 1, j, substring); // bottom

			board[i][j] = temp;
		}

		return word.length() == 0;
	}

}