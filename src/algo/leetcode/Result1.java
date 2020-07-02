package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Result1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
//
//		list.add(10);
//		list.add(20);
//		list.add(7);

//		list.add(2);
//		list.add(3);

		list.add(1);
		// System.out.println(minimumSum(list.stream().mapToInt(Integer::intValue).toArray(),
		// 565));

//		System.out.println(minimumSum(list.stream().mapToInt(Integer::intValue).toArray(), 1));
//		System.out.println(minSum(list, 1));
		System.out.println(minSumPQ(list, 1));

		// list.forEach(System.out::println);
	}

	public static int minSumPQ(List<Integer> num, int k) {

		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

		pQueue.addAll(num);

		for (int i = 0; i < k; i++) {
			Integer remove = pQueue.remove();
			double result = Double.valueOf(remove) / 2.0;
			Integer finalVal = (int) Math.ceil(result);
			pQueue.add(finalVal);
		}

		int sum = 0;
		Iterator<Integer> iterator = pQueue.iterator();
		while (iterator.hasNext()) {
			sum = sum + iterator.next();
		}

		return sum;
	}

	public static int minSum(List<Integer> num, int k) {

		Collections.sort(num, Collections.reverseOrder());

		for (int i = 0; i < k; i++) {

			double result = Double.valueOf(num.get(0)) / 2.0;
			num.set(0, (int) Math.ceil(result));

			Collections.sort(num, Collections.reverseOrder());
		}

		int sum = 0;
		for (int i = 0; i < num.size(); i++) {
			sum = sum + num.get(i);
		}
		return sum;
	}

	// 149373
	public static int minimumSum(int[] A, int k) {
		int sum = 0;
		Arrays.sort(A);
		for (int i = 0; i < k; i++) {

			int len = A.length;

			if (A[len - 1] % 2 == 0) {

				A[len - 1] = A[len - 1] / 2;

			} else {

				A[len - 1] = (int) Math.ceil((double) A[len - 1] / 2);

			}
			// System.out.print(A[len - 1] + " ,");
			Arrays.sort(A);
		}

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		return sum;

	}   
/* Brute force approach for the same 
    Collections.sort(num, Collections.reverseOrder());

    for (int i = 0; i < k; i++) {

        double result = Double.valueOf(num.get(0)) / 2.0;
        num.set(0, (int) Math.ceil(result));

        Collections.sort(num, Collections.reverseOrder());
    }

    int sum = 0;
    for (int i = 0; i < num.size(); i++) {
        sum = sum + num.get(i);
    }
    return sum; 
*/
}
