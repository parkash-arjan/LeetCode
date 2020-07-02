package algo.leetcode;

public class ArrangingCoins {
	public int arrangeCoins(int n) {

		long currentStairCount = 0;

		int i = 0;
		while (currentStairCount <= n) {
			i++;
			currentStairCount = currentStairCount + i;
		}
		return i - 1;

	}

	public static void main(String[] args) {
		ArrangingCoins arrangingCoins = new ArrangingCoins();
//		for (int i = 0; i <= 10; i++) {
//			System.out.println(i + "  ... " + arrangingCoins.arrangeCoins(i));
//		}
		System.out.println(arrangingCoins.arrangeCoins(2147483647));

	}
}
