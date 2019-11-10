package binarySearch;

public class BinarySearch {
	public static void main(String[] args) {
		//int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr= {10};
		int index = search(arr, 10);
		System.out.println(index);
	}

	private static int search(int[] arr, int key) {
		if (arr == null || arr.length < 1) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		// TODO Auto-generated method stub
		return -1;
	}
}
