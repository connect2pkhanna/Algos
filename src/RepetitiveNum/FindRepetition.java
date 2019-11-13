package RepetitiveNum;

public class FindRepetition {
	public static void main(String[] args) {
		int[] arr = {1,2,2,3,4};
		int num = find(arr);
		System.out.println(num);
	}

	private static int find(int[] nums) {
		if (nums == null || nums.length < 1) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == mid + 1) {
				start = mid + 1;
			} else if (nums[mid] < mid + 1) {
				end = mid;
			}

		}
		return nums[start] < start + 1 ? nums[start] : -1;
	}
}
