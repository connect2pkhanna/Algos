package binarySearch;

public class SearchIn2DSortedMatrix {
	public static void main(String[] args) {
		//int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		//int[][] arr= {{1, 3}};
		int[][] arr= {{1},{6}};
		int[] index = find(arr, 3);
		for (int i : index) {
			System.out.print(i + " ");
		}

	}

	private static int[] find(int[][] arr, int key) {
		if (arr == null || arr.length < 1 || arr[0].length < 1) {
			int[] nArr = { -1, -1 };
			return nArr;
		}

		int rStart = 0;
		int rEnd = arr.length - 1;
		int rLen = arr[0].length - 1;

		while (rStart <= rEnd) {
			int mid = rStart + (rEnd - rStart) / 2;

			if (arr[mid][rLen] == key) {
				int[] nArr = { mid, rLen };
				return nArr;
			} else if (arr[mid][rLen] > key) {
				if (arr[mid][0] == key) {
					int[] nArr = { mid, 0 };
					return nArr;
				}
				if (arr[mid][0] < key) {
					int result = search(arr[mid], key);
					if (result != -1) {
						int[] nArr = { mid, result };
						return nArr;
					}
				} else {
					if (rEnd > 0) {
						rEnd = mid - 1;
					}
				}

			} else {
				if (rStart < arr.length) {
					rStart = mid + 1;
				}
			}

		}

		int[] nArr = { -1, -1 };
		return nArr;
		// TODO Auto-generated method stub

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
