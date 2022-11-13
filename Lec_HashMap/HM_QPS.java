package Lec_HashMap;

import java.util.HashMap;

public class HM_QPS {
	public static void main(String[] args) {
		int[] arr1 = { 30, 20, 40, 50, 70, 30, 20, 20, 50, 50 };

		int[] arr2 = { 50, 80, 30, 20, 20, 20, 90, 50, 20 };

//		Intersection(arr1, arr2);
		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6} ;
		LongestPossibleSeq(arr);
	}

	public static void Intersection(int[] arr1, int[] arr2) {
//		O(n+m)
		HashMap<Integer, Integer> HM = new HashMap<>();
		for (int ali : arr2) {
//			int prev_freq =0;
//			if(HM.containsKey(ali)) {
//				prev_freq = HM.get(ali);
//			}

			int prev_freq = HM.getOrDefault(ali, 0);
			HM.put(ali, prev_freq + 1);
		}
		System.out.println(HM);
		for (int ali : arr1) {
			if (HM.containsKey(ali) && HM.get(ali) > 0) {
				System.out.println(ali);
				int prev_freq = HM.get(ali);
				HM.put(ali, prev_freq - 1);

			}
		}

	}

//	https://leetcode.com/discuss/interview-question/1721687/find-maximum-mex-from-an-array
	
	public static void LongestPossibleSeq(int[] arr) {
		HashMap<Integer, String>HM = new HashMap<>();
		for(int ali : arr) {
			HM.put(ali, null);
		}
		for(int key :arr) {
			if(!HM.containsKey(key-1)) {
//				System.out.println(key);
				int curr = key;
				int size=0;
				while(HM.containsKey(curr)) {
					System.out.print(curr+" ");
					curr++;
					size++;
				}
				System.out.println(" => "+size);
			}
		}
	}
}
