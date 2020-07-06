package algo.leetcode.math;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes countPrimes = new CountPrimes();
		Set<Integer> primes = countPrimes.countPrimes(10);
		System.out.println(primes);
		System.out.println(primes.size());
	}

	public Set<Integer> countPrimes(int n) {

		Map<Integer, Boolean> map = new ConcurrentHashMap<>(n);

		for (int i = 2; i < n; i++) {
			if (i % 2 != 0 || i == 2) {
				map.put(i, true);
			}
		}

		for (Integer key : map.keySet()) {

			if (Math.pow(key, 2.0) >= n) {
				break;
			}

			int multiple = 0;
			for (int i = key; multiple < n; i++) {
				multiple = key * i;
				map.remove(multiple);
			}

		}

		return map.keySet();
	}
//	public int countPrimes(int n) {
//
//		Map<Integer, Boolean> map = new ConcurrentHashMap<>(n);
//
//		for (int i = 2; i < n; i++) {
//			if (i % 2 != 0 || i == 2) {
//				map.put(i, true);
//			}
//		}
//
//		for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
//
//			int key = entry.getKey();
//
//			if (Math.pow(key, 2.0) >= n) {
//				break;
//			}
//
//			int multiple = 0;
//			for (int i = key; multiple < n; i++) {
//				multiple = key * i;
//				map.remove(multiple);
//			}
//
//		}
//
//		System.out.println(map.keySet());
//		return map.size();
//	}
}
