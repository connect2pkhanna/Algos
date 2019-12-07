package binarySearch;

public class FindMinimumInRotatedArray {
	// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	/*
	 * leetcode output Runtime: 5 ms, faster than 100.00% of Java online submissions
	 * for Find Minimum in Rotated Sorted Array. Memory Usage: 36.2 MB, less than
	 * 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 3 };
		// 0 1 2 3 4 s=0 e=4 , mid = 2
		int out = find(arr);
		System.out.println(out);
	}

	private static int find(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		int len = arr.length - 1;
		int start = 0;
		int end = len;
		if (arr[0] < arr[len]) {
			return arr[0];
		}
		int out = Integer.MAX_VALUE;
		while (start < end) {
			// System.out.println("start = " + start + " end = " + end);
			int mid = start + (end - start) / 2;
			System.out.println(" mid index = " + mid + " val = " + arr[mid]);
			if (mid + 1 <= len && arr[mid] > arr[mid + 1]) {
				out = arr[mid + 1];
				break;
			} else {
				if (arr[mid] > arr[end]) {
					start = mid + 1;
					System.out.println("start shifted to right = " + start);
				} else if (arr[mid] < arr[end]) {
					end = mid;
					System.out.println("end shifted to left = " + end);
				}
			}
		}
		/*
		 * if (end == -1) { return arr[0]; }
		 */

		if (start == end) {
			if (arr[start] > arr[start + 1]) {
				out = arr[start + 1];
			}
		}
		return out;
	}
}
