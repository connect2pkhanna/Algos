package createAllSubSetsFromAnIntArray;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class SubSets {

	public static void main(String[] args) {
		int[] arr= {1,2,3};
		List<Integer> list= new ArrayList<Integer>();
		
			recurse(arr,0,arr.length-1,list);
		
		//recurse(arr,0,arr.length-1,list);
	}
	// create a list (add) num 
	//from that num add the subsequent nums to the list int i->0->len-1
	// recursive(i,list);
	//if(i>j){
    // return;
	// list.add(arr[i]);
	// for j=i+1 add nums until j<len-1
	// recursiveCall(j,list);
	// remove last added item now 

	private static void recurse(int[] arr, int i, int len, List<Integer> list) {
		if(i>len) {
			return ;
		}
		list.add(arr[i]);
		for (Integer num : list) {
			System.out.print(num);
			
		}
		System.out.println("----");
		recurse(arr, i+1, len, list);
		list.remove(list.size()-1);
		recurse(arr, i+1, len, list);
		// TODO Auto-generated method stub
		
	}

	
}
