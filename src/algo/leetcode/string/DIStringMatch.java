package algo.leetcode.string;

public class DIStringMatch {
	public int[] diStringMatch(String S) {

		int i = 0;
		int j = S.length();

		int[] permutation = new int[S.length() + 1];
		int idx = 0;

		for (int k = 0; k < S.length(); k++) {
			if (S.charAt(k) == 'I')
				permutation[idx] = i++;
			else
				permutation[idx] = j--;
			idx++;
		}

		if (j == 0) {
			permutation[idx] = i;
		} else {
			permutation[idx] = j;
		}
		return permutation;
	}
}
