package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations2 {

	public static void main(String[] args) {
		Permutations2 permutations2 = new Permutations2();
		List<String> permuteHelper = permutations2.permuteHelper(new StringBuilder("ABC"));
		for (String string : permuteHelper) {
			System.out.println(string);
		}
	}

//	public List<String> permuteHelper(StringBuilder inputString) {
//
//		if (inputString.length() == 1) {
//			return Arrays.asList(inputString.toString());
//		}
//
//		List<String> permutations = new ArrayList<>();
//		int len = inputString.length();
//		for (int i = 0; i < len; i++) {
//			char prefixCharacter = inputString.charAt(i);
//			StringBuilder nextPermutation = inputString.replace(i, i + 1, "");
//			List<String> listSubPermutations = permuteHelper(nextPermutation);
//
//			permutations
//					.addAll(listSubPermutations.stream().map(s -> prefixCharacter + s).collect(Collectors.toList()));
//
//			inputString.insert(i, prefixCharacter);
//		}
//		return permutations;
//	}

	public List<String> permuteHelper(StringBuilder inputString) {

		if (inputString.length() == 1) {
			return Arrays.asList(inputString.toString());
		}

		List<String> permutations = new ArrayList<>();
		int len = inputString.length();
		for (int i = 0; i < len; i++) {
			char prefixCharacter = inputString.charAt(i);
			StringBuilder nextPermutation = inputString.replace(i, i + 1, "");
			List<String> listSubPermutations = permuteHelper(nextPermutation);

			for (String subPermutation : listSubPermutations) {
				permutations.add(prefixCharacter + subPermutation);
			}
			inputString.insert(i, prefixCharacter);
		}
		return permutations;
	}
}
