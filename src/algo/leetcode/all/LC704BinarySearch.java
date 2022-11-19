package algo.leetcode.all;

import com.leetcode.util.Util;

public class LC704BinarySearch {

    public static void main(String[] args) {
        LC704BinarySearch runner = new LC704BinarySearch();
        runner.search(new int[]{-1,0,3,5,9,12}, 9);

    }
    public int search(int[] nums, int target) {
        int start = 0;
        int end - nums.length;
        int mid = (start + end)/2;
        for (int num : nums) {
            Util.print(num);
        }
        return -1;
    }
}
