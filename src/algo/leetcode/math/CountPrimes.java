package algo.leetcode.math;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CountPrimes {

	public static void main(String[] args) {
		CountPrimes countPrimes = new CountPrimes();
		int count = countPrimes.countPrimes(100);
		System.out.println(count);
	}

	public int countPrimes(int n) {

		Map<Integer, Boolean> map = new ConcurrentHashMap<>(n);

		for (int i = 2; i < n; i++) {
			if (i % 2 != 0 || i == 2) {
				map.put(i, true);
			}
		}
		System.out.println("Map size = " + map.size());
		int k = 0;
		for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
			k++;
			int key = entry.getKey();

			if (Math.pow(key, 2.0) >= n) {
				break;
			}

			int multiple = 0;
			for (int i = key; multiple < n; i++) {
				multiple = key * i;
				map.remove(multiple);
			}

		}
		System.out.println("K = " + k);
		return map.size();
	}
}
