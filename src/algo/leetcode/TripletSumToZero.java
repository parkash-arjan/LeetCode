package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

	public static void main(String[] args) {

		// System.out.println(threeSum(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		// System.out.println(searchTriplets(new int[] { -5, 2, -1, -2, 3 }));

	}

	public List<List<Integer>> threeSum(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			List<List<Integer>> list = targetSum(-1 * arr[i], arr, i + 1, arr.length - 1);
			if (!list.isEmpty()) {
				list.forEach(triplets::add);
			}
		}

		return triplets;
	}

	public List<List<Integer>> targetSum(int target, int[] arr, int i, int j) {
		List<List<Integer>> triplets = new ArrayList<>();

		while (i < j) {
			if (arr[i] + arr[j] == target) {
				List<Integer> triplet = Arrays.asList(-target, arr[i], arr[j]);
				triplets.add(triplet);
				i++;
				j--;
			} else if (arr[i] + arr[j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return triplets;
	}
}
