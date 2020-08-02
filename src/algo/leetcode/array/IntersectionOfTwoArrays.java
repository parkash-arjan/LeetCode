package algo.leetcode.array;

import java.util.Arrays;

public class IntersectionOfTwoArrays {

	public int[] intersect(int[] nums1, int[] nums2) {
	  
		if(nums1.length > nums2.length){
			return intersect(nums2 , nums1);
		}

		// nums1 is less than nums2
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

		int i = 0 ;
		int j = 0;

		int idx = -1;
		while(i <nums1.length && j <nums2.length ){

				if(nums1[i] == nums2[j]){
					nums1[++idx] = nums2[j];
					i++;
					j++;	

				}else
				if(nums1[i] < nums2[j]){
					i++;	
				}else
				if(nums1[i] > nums2[j]){
					j++;	

				}

		}


		return idx == -1? new int[0] : Arrays.copyOfRange(nums1 , 0 , idx+1 );



	}

/*    
public int[] intersect(int[] nums1, int[] nums2) {
	if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
		return new int[0];
	}
	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < nums1.length; i++) {
		if (map.containsKey(nums1[i])) {
			map.put(nums1[i], map.get(nums1[i]) + 1);
		} else {
			map.put(nums1[i], 1);
		}
	}
	List<Integer> resultSet = new ArrayList<>();
	for (int i = 0; i < nums2.length; i++) {
		if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
			map.put(nums2[i], map.get(nums2[i]) - 1);
			resultSet.add(nums2[i]);
		}
	}
	int[] array = new int[resultSet.size()];
	int i = 0;
	Iterator<Integer> itr = resultSet.iterator();
	while (itr.hasNext()) {
		array[i++] = itr.next();
	}
	return array;
}
*/ 
}
