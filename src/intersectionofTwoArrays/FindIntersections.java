package intersectionofTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class FindIntersections {
	public static void main(String[] args) {
		int[] arr1 = { 4,5 };
		int[] arr2 = { 4,4 };
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		List<Integer> out = findIntersections(arr1, arr2);
		System.out.println(out.size());
		for (Integer num : out) {
			System.out.print(num);
		}
	}

	private static List<Integer> findIntersections(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<Integer>();
		if (arr1 == null || arr2 == null || arr1.length < 1 || arr2.length < 1) {
			return list;
		}

		int aLen = arr1.length - 1;
		int bLen = arr2.length - 1;
		int left = 0;
		int right = 0;

		while (left <= aLen && right <= bLen) {

			if (arr1[left] == arr2[right]) {
				int countOfEqualElements = 2;
				int num = arr1[left];
				
				while (left+1 <= aLen && arr1[left + 1] == arr1[left] ) {
					countOfEqualElements++;
					left++;
				}
				while (right+1 <= bLen && arr2[right + 1] == arr2[right]) {
					countOfEqualElements++;
					right++;
				}
				
				for (int count = 0; count <= countOfEqualElements-1; count++) {
					list.add(num);
				}
				
				left++;
				right++;
			} else {
				if (arr1[left] < arr2[right]) {
					left++;
				} else {
					right++;
				}
			}

		}

		return list;
	}
}
