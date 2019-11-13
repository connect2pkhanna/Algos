package binarySearch;

//https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/
public class FindMissingNumberFromTheSortedArray {
	public static void main(String[] args) {
		//int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9 };
		int[] arr= {2};
		int num = find(arr);
		System.out.println("missing num "+num);
	}

	private static int find(int[] arr) {
		if (arr == null || arr.length <1) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == mid + 1) {
				// the mising is on the right
				start = mid + 1;
			} else if (arr[mid] > mid + 1) {
				// the missing num can be this or on the left
				end = mid;
			}

		}

		return arr[start] > start + 1 ? arr[start] - 1 : -1;
	}
}
