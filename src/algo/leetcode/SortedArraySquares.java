package algo.leetcode;

public class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {

		// -3,-2,-1,0,1,2
		int i = arr.length-1;
		int j = 0;
		int[] squares = new int[arr.length];
		int idx = arr.length - 1;
		while (i > j) {

			int powI = arr[i] * arr[i];
			int powJ = arr[j] * arr[j];

			if (powI > powJ) {
				squares[idx--] = powI;
				i--;
			} else {
				squares[idx--] = powJ;
				j++;
			}
		}

		return squares;
	}

	public static void main(String[] args) {

		int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();

		result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
	}
}
