package FindDuplicatesWithNoExtraSpaceWith3WayQuickSort;

public class ThreeWayQuickSortToFindDuplicates {
	public static void main(String[] args) {
		int[] arr={4,3,2,7,8,2,3,1};
		qSort(0, arr.length-1, arr);
		System.out.println(arr);
	}

	static void qSort(int start, int end, int[] arr) {
		System.out.println("start = "+start+" end "+end);
		if (end <=start || start<0 || end >arr.length-1 ||  start>arr.length-1) {
			//System.out.println("returning");
			return;
		}
		int left = start;
		int right = end;
		int lt = start;
		int gt = end;
		int current = start;
		int pivot = arr[end];
		while (current <= gt) {
			
			if (arr[current] > pivot) {
				swap(gt, current, arr);
				gt--;
				// push it to right and swap, while an element is coming to left we have to
				// check it again
				// do not increment lt and current

			} else if (arr[current] < pivot) {
				swap(current, lt, arr);
				current++;
				lt++;
				// swap lt and current
				// increment lt
				// increment current

			}else if (arr[current] == pivot) {
				// increment current;
				current++;

			}

		}
		if(gt-lt>0) {
			System.out.println("Duplicate ="+arr[gt]);
		}
		qSort(start, lt-1, arr);
		qSort(gt+1, end, arr);

	}

	static void swap(int i, int j, int[] arr) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
