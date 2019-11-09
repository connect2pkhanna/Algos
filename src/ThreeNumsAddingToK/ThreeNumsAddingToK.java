package ThreeNumsAddingToK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// modify the code to detect duplicates
public class ThreeNumsAddingToK {

	
	public static void main(String[] args) {
		int[] arr= {3,5,1,2,4,7,8,9,1,4,5,3,10,4,2,8,3,7,2,2,2,2};
		 List<List<Integer>> results=	find3NumsAddingTok(arr, 0, 10);
		 System.out.println(results);
		
	}
	
	
	
	
	
	
	public static List<List<Integer>> find3NumsAddingTok(int[] arr,int index,int k) {
		if(arr.length<3) {
			return null;
		}
		List<List<Integer>> listToReturn = new ArrayList<List<Integer>>();
		for(;index<=arr.length-1;index++) {
			int num=arr[index];
			
		     List<List<Integer>> result=FindNumsAddingToK(arr, k-num,index+1 );
		     if(result.size()<1) {
		    	 continue;
		     }
		     
			for (List<Integer> list : result) {
				List<Integer> nlist= new ArrayList<Integer>();
				nlist.addAll(list);
				nlist.add(num);
				listToReturn.add(nlist);
			}
			
		}
		
		return listToReturn;
	}
	
	private static List<List<Integer>> FindNumsAddingToK(int[] arr, int k,int index) {
		if (arr == null || arr.length < 2) {
			return null;
		}
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		// result to return
		List<List<Integer>> list = new ArrayList<>();
		for(;index<=arr.length-1;index++) {
		    int num=arr[index];
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
