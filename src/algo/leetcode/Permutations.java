package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

//1,2 
public class Permutations {
	public static void main(String[] args) {

		List<List<Integer>> listofPermutations = new Permutations().permute(new int[] { 1, 2, 3 });

		for (List<Integer> permutations : listofPermutations) {

			permutations.forEach(System.out::print);
			System.out.println();

		}

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		permuteHelper(nums, 0, permutations);
		return permutations;

	}

	public void permuteHelper(int[] nums, int position, List<List<Integer>> permutations) {
		List<Integer> tempPermutation = new ArrayList<>();
		if (position == nums.length - 1) {
			tempPermutation.add(nums[position]);
			permutations.add(tempPermutation);

		} else {
			permuteHelper(nums, position + 1, permutations);

			int size = permutations.size();
			for (int i = 0; i < size; i++) {
				List<Integer> permutation = permutations.remove(0);
				for (int j = 0; j <= permutation.size(); j++) {
					tempPermutation = new ArrayList<>();
					tempPermutation.addAll(permutation);
					tempPermutation.add(j, nums[position]);
					permutations.add(tempPermutation);

				}

			}

		}

	}
//	public List<List<Integer>> permuteHelper(int[] nums, int position) {
//
//		if (position == nums.length - 1) {
//			List<List<Integer>> permutations = new ArrayList<>();
//			List<Integer> permutation = new ArrayList<>();
//			permutation.add(nums[position]);
//			permutations.add(permutation);
//			return permutations;
//		} else {
//			List<List<Integer>> permutations = permuteHelper(nums, position + 1);
//
//			int size = permutations.size();
//			for (int i = 0; i < size; i++) {
//
//				List<Integer> permutation = permutations.remove(0);
//				for (int j = 0; j <= permutation.size(); j++) {
//					List<Integer> tempList = new ArrayList<>();
//					tempList.addAll(permutation);
//					tempList.add(j, nums[position]);
//					permutations.add(tempList);
//
//				}
//
//			}
//
//			return permutations;
//		}
//
//	}
}
