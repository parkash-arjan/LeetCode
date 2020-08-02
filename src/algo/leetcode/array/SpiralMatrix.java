package algo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };

		// int[][] matrix = new int[][] { { 1, 2, 3 } };
		// int[][] matrix = new int[][] { { 1 } };

		int[][] matrix = new int[][] { { 1, 2 }, { 4, 3 } };

		List<Integer> list = spiralOrder(matrix);
		System.out.println(list);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return result;

		int topRow = 0;
		int leftCol = 0;
		int rightCol = matrix[topRow].length - 1;
		int bottomRow = matrix.length - 1;
		int dir = 0;

		while (topRow <= bottomRow && leftCol <= rightCol) {
			if (dir == 0) {
				for (int i = leftCol; i <= rightCol; i++) {
					result.add(matrix[topRow][i]);
				}
				topRow++;
				dir = 1;
			} else if (dir == 1) {
				for (int i = topRow; i <= bottomRow; i++) {
					result.add(matrix[i][rightCol]);
				}
				rightCol--;
				dir = 2;
			} else if (dir == 2) {
				for (int i = rightCol; i >= leftCol; i--) {
					result.add(matrix[bottomRow][i]);
				}
				bottomRow--;
				dir = 3;
			} else if (dir == 3) {
				for (int i = bottomRow; i >= topRow; i--) {
					result.add(matrix[i][leftCol]);
				}
				leftCol++;
				dir = 0;
			}
		}

		return result;
	}

}
