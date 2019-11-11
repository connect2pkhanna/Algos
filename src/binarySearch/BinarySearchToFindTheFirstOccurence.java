package binarySearch;

import sun.security.util.Length;

public class BinarySearchToFindTheFirstOccurence {
int[] arr= {0};
public static void main(String[] args) {
	int[] arr= {1,1,1};
	int index=find(arr,1);
	System.out.println(index);
	
}
// start=0 end =0,mid=0
	private static int find(int[] arr, int key) {
		if (null == arr || arr.length < 1) {
			return -1;
		}
		
		int start = 0;
		int end = arr.length - 1;
		
		while (start < end) {
			int mid = start + (end - start) / 2;
			
			if (arr[mid] == key) {
				end = mid;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return arr[start] == key ? start : -1;
	}
}
