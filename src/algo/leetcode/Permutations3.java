package algo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1,2 
public class Permutations3 {
	public static void main(String[] args) {

		List<List<Integer>> listofPermutations = new Permutations3().permute(new int[] { 1 ,2 , 3});

		for (List<Integer> permutations : listofPermutations) {

			permutations.forEach(System.out::print);
			System.out.println();

		}

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		perm(0, nums, res);
		return res;
	}

	private void perm(int start, int[] nums, List<List<Integer>> res) {
		if (start == nums.length - 1) {
			res.add(IntStream.of(nums).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			perm(start + 1, nums, res);
			swap(nums, i, start);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
