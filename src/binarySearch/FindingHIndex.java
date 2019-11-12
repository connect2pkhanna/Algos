package binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/h-index-ii/
public class FindingHIndex {
	public static void main(String[] args) {
		int[] arr = {2,3,3,4,5};
        System.out.println(hIndex(arr));
	}

	public static int hIndex(int[] citations) {
		// 2,3,3,4,5
		// 0 1 2 3 4 
		// 0
		// 0 1 start=0 end =0 ,mid =0
		if (citations == null || citations.length < 1) {
			return 0;
		}

		int start = 0;
		int len = citations.length - 1;
		int end = len;

		while (start <=end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] == (len - mid + 1)) {
				return citations[mid];
			} else if (citations[mid] > len - mid + 1) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0;

	
        
	}
}
