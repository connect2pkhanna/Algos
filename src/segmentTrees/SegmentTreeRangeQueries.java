package segmentTrees;

public class SegmentTreeRangeQueries {

	public static void main(String[] args) {
		SegmentTreeRangeQueries segmentTree = new SegmentTreeRangeQueries();
		int[] arr = { 4, 1, 3, 7, 8, 4 };
		int[] segmentedTree = segmentTree.createSegmentTreeAndReturnItsArrayRepresnentatio(arr);
		System.out.println(segmentedTree);
		int out = queryTheSegmentedTree(segmentedTree, 1, 3, 0, 5, 1);
		System.out.println(out);
	}

	private static int queryTheSegmentedTree(int[] arr, int queryStart, int queryEnd, int rStart, int rEnd, int index) {
		System.out.println("int queryStart= " + queryStart + " int queryEnd =" + queryEnd + "int rStart=," + rStart
				+ " int rEnd " + rEnd);
		if (rStart < 0 || rStart > arr.length - 1 || rEnd > arr.length - 1 || rEnd < 0 || (rEnd < rStart)) {
			return 0;
		}

		if (queryStart == rStart && queryEnd == rEnd) {
			return arr[index];
		}
		if (rStart == rEnd && (rEnd < queryStart || queryEnd < rStart)) {
			return 0;
		}
		int mid = rStart + (rEnd - rStart) / 2;
		System.out.println("Mid " + mid);
		return queryTheSegmentedTree(arr, queryStart, Math.min(queryEnd, mid), rStart, mid, 2 * index)
				+ queryTheSegmentedTree(arr, Math.max(queryStart, mid + 1), queryEnd, mid + 1, rEnd, 2 * index + 1);

	}

	private int[] createSegmentTreeAndReturnItsArrayRepresnentatio(int[] arr) {
		int[] aux = new int[(2 * arr.length) + 2];
		construct(aux, 0, arr.length - 1, 1, arr);

		return aux;
	}

	private int construct(int[] aux, int start, int end, int index, int[] arr) {
		
		if (index > aux.length - 1) {
			return 0;
		}
		// now that the range is i to i , we store arr[num] to aux[index]
		// as sum of all digits from i to i is arr[num] itself
		// we should return from here as there is no further sub problem to solve
		if (start == end) {
			aux[index] = arr[start];
			return arr[start];
		}
		int mid = start + (end - start) / 2;
		// as result[i] is the result of 2 sub problmens result[2*i] * result[2*i+1)
		return aux[index] = construct(aux, start, mid, 2 * index, arr)
				+ construct(aux, mid + 1, end, (2 * index) + 1, arr);

	}

}
