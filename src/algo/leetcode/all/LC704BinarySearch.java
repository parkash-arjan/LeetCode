package algo.leetcode.all;

import com.leetcode.util.Util;

public class LC704BinarySearch {

    public static void main(String[] args) {
        LC704BinarySearch runner = new LC704BinarySearch();
        // int result = runner.search(new int[]{-1,0,3,5,9,12}, 9);
        // int result = runner.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2);
        int result = runner.search(new int[] { -1, 0, 3, 5, 9, 12 }, 13);
        Util.print(result);
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while (mid >= start && mid <= end) {
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
            mid = (start + end) / 2;
        }
        return -1;
    }
}
