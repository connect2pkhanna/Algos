package binarySearch;

//https://leetcode.com/problems/first-bad-version
public class BadVersion {

	public static void main(String[] args) {
		boolean[] arr = { true, true };
		// boolean[] arr= {false};
		// boolean[] arr = { true };
		int index = findFirstBadVersion(arr);
		System.out.println(index);
	}

	private static int findFirstBadVersion(boolean[] arr) {
		if (null == arr || arr.length < 1) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		int mid = start + (end - start) / 2;
		while (start < end) {
			if (isBadVersion(arr,mid)) {
				// the first bad version can be this or to the left , so end is this
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		// start+1 as the series starts from 1
		return arr[start] == true ? start + 1 : -1;
	}

	private static boolean isBadVersion(boolean[] arr, int index) {
		return arr[index];
	}
}
