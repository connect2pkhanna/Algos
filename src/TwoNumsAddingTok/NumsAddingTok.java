package TwoNumsAddingTok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// the algorith is to store k-num in a map and as we traverse we see if num is m present in a map (that means K-num and num exist in the array
public class NumsAddingTok {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 1, 3, 0, 4, 6, 3, 2, 2 };
		int k = 6;
		List<List<Integer>> result = FindNumsAddingToK(arr, k);
		System.out.println(result);
	}

	private static List<List<Integer>> FindNumsAddingToK(int[] arr, int k) {
		if (arr == null || arr.length < 2) {
			return null;
		}
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		// result to return
		List<List<Integer>> list = new ArrayList<>();
		for (int num : arr) {

			if (map.containsKey(num) && map.get(num) == false) {
				List<Integer> nList = new ArrayList<Integer>();
				nList.add(num);
				nList.add(k - num);
				list.add(nList);
				// as num was already used for a result for paring ,num and k-num
				map.put(num, true);

			} else {

				map.put(k - num, false);

			}

		}

		// TODO Auto-generated method stub
		return list;
	}
}
