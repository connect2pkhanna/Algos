package Sorting;

public class PutZeroesOnLeftAndOnesOnRight {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0 };
		sort(arr);
		System.out.println(arr);

	}

	private static void sort(int[] arr) {
		if(arr==null || arr.length<2) {
			return ;
		}
		int reader = 0;
		int writer = arr.length - 1;
		while (reader < writer) {
			if (arr[reader] == 0) {
				reader++;
			} else {
				swap(reader, writer, arr);
				writer--;
			}

		}

	}

	private static void swap(int reader, int writer, int[] arr) {

		int tmp = arr[reader];
		arr[reader] = arr[writer];
		arr[writer] = tmp;
	}

}
