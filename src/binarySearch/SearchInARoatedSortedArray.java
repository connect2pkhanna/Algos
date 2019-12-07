package binarySearch;
/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
 * 
 * LeetCode output ->  
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
   Memory Usage: 39.4 MB, less than 18.24% of Java online submissions for Search in Rotated Sorted Array.
 */
public class SearchInARoatedSortedArray {
	public static void main(String[] args) {
		int[] arr = {2,3,4,1};
		int out = find(arr, 4);
		System.out.println(out);
	}

	private static int find(int[] arr, int key) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start<end) {
			int mid = start + (end - start) / 2;
			//System.out.println(" mid index = " + mid + " val = " + arr[mid]);
			if (arr[mid] == key) {
				return mid;
			} 
				if (arr[mid] >arr[end]) {
					if(arr[start]<=key && key<arr[mid]) {
						end=mid-1;
					}else {
						start=mid+1;
					}
				
			}else {
				if(arr[mid]<arr[end]) {
					if(arr[mid]<key && arr[end]>=key) {
						start=mid+1;
					}else {
						end=mid-1;
					}
				}
				
			}

		}
		return arr[start]==key?start:-1;
	}
}
