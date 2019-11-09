package Sorting;

public class Sort3NumbersinOrder {
	public static void main(String[] args) {
		// [] arr = { 0, 1, 1, 2, 0, 1, 2, 1, 0, 0, 1 };
		// int[] arr= {2,1};
		// int[] arr= {1,1};
		// int[] arr= {1,0};
		int[] arr = { 1, 1, 0, 0, 2, 2 };
		sort(arr);
		System.out.println(arr);
		for (int i : arr) {
			System.out.print(i);
		}
	}

	private static void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int reader = 0;
		int w0 = 0;
		int w2 = arr.length - 1;
		int writer = w2;
		;
		while (reader <= w2) {

			if (arr[reader] < 1) {
				swap(reader, w0, arr);
				reader++;
				w0++;

			} else if (arr[reader] > 1) {

				swap(reader, writer, arr);
				w2--;
				writer--;

			} else {
				reader++;

			}

		}
	}

	private static void swap(int reader, int writer, int[] arr) {

		int tmp = arr[reader];
		arr[reader] = arr[writer];
		arr[writer] = tmp;
	}
}
