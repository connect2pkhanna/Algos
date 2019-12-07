package binarySearch;

/* https://leetcode.com/problems/peak-index-in-a-mountain-array/
 *   LeetCode output=.
 *   Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
     Memory Usage: 39.4 MB, less than 80.00% of Java online submissions for Peak Index in a Mountain Array.
 * 
 */
public class FindPeakIntheMountain {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(peakIndexInMountainArray(arr));
	}

	public static int peakIndexInMountainArray(int[] arr) {
		if (arr == null) {
			return -1;
		}
		int len = arr.length;
		if (len == 1) {
			return 0;
		}

		int left = 0;
		int right = len - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == 0 && arr[mid] > arr[mid + 1]) {
				return mid;
			}
			if (mid == len - 1 && arr[mid] > arr[mid - 1]) {
				return mid;
			}

			if (mid > 0 && mid < len - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				}
			}

			if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
				right = mid - 1;
			} else if (mid + 1 <= len - 1 && arr[mid] < arr[mid + 1]) {
				left = mid + 1;
			}
		}
		return -1;
	}
}
