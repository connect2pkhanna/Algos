package binarySearch;

public class SearchInsertPosition {
	/* https://leetcode.com/problems/search-insert-position 
	 * 
	 * Given a sorted array and a target value, return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
	 * 
	 * LeetCode output ===>
	 * Runtime: 30 ms, faster than 100.00% of Java online submissions for Search Insert Position.
       Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Search Insert Position.
	 * 
	 */
public static void main(String[] args) {
	int[] arr = {1,2,3,4};
	int out=searchInsert(arr,0);
	System.out.println(out);
}

	public static int searchInsert(int[] arr, int key) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] > key) {
				end = mid - 1;
				System.out.println(" new end = " + end);
			} else {
				start = start + 1;
				System.out.println(" new start = " + start);
			}
		}
		System.out.println("  start = " + start);
		if (key < arr[start]) {
			return start;
		}
		return arr[start] == key ? start : start + 1;

	}
}
