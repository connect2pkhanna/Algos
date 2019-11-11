package binarySearch;

public class BinarySearchToFindTheLastOccurence {
	public static void main(String[] args) {
		int[] arr= {1,2,3};
	int index=	find(arr,1);
	int index1=	findByStoringlastRightMostIndexAnGoingRight(arr,1);
	System.out.println(index);
	System.out.println(index1);
	}
// start 0 , end 2 ,mid 1
	private static int find(int[] arr, int key) {
		if(arr==null || arr.length<1) {
			return -1;
		}
		int start=0;
		int end=arr.length-1;
		while(start<=end) {

			int mid = start + (end - start) / 2;
			
			if (arr[mid] == key) {
				start = mid+1;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		
			
		}
		return arr[end]==key?end:-1;
		// TODO Auto-generated method stub
		
	}
	static int findByStoringlastRightMostIndexAnGoingRight(int[] arr,int key){
		
		if(arr==null || arr.length<1) {
			return -1;
		}
		int start=0;
		int end=arr.length-1;
		int result=-1;
		while(start<=end) {


			int mid = start + (end - start) / 2;
			
			if (arr[mid] == key) {
				result=mid;
				start = mid+1;
			} else if (arr[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		
			
		
			
		}
		return result;
	}
	
}
