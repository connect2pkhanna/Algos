package subetsWithADefiniteParity;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-number-of-nice-subarrays/
/*The question is similar to finding subets(sequential) but we have to keep a track of count of odds find in the subset*/
public class SubetsWithParityK {
	static List<List<Integer>> results= new ArrayList<List<Integer>>();
public static void main(String[] args) {
	int[] arr= {2,2,2,1,2,2,1,2,2,2};
	
	List<Integer> list= new ArrayList<Integer>();
	for (int i = 0; i <=arr.length-1; i++) {
		findSubSetsWithkOnes(arr,i,0,list,2);
	}
	System.out.println(results.size());
	
}

private static void findSubSetsWithkOnes(int[] arr, int i, int sum,List<Integer> list ,int numOfOnesToFind) {
	//base case
	if(sum==numOfOnesToFind) {
		for (Integer num : list) {
			System.out.print(num);
		}
		System.out.println("====");
		results.add(list);
		
	}
	if(i>arr.length-1) {
		list.clear();
		return;
	}
	
	if((arr[i] & 1)==1) {
		sum=sum+1;
	}
	list.add(arr[i]);
	findSubSetsWithkOnes(arr,i+1,sum,list,numOfOnesToFind);
	
	
	
	
	
	
	
	
	
}
}
