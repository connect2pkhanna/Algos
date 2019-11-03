package validateSodoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidateSoduko {
	public static void main(String[] args) {
		int[][] arr = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 }

		};

		boolean isValid = validate(arr);
		System.out.println(isValid);
	}

	private static boolean validate(int[][] arr) {
		if (arr == null || arr.length < 1) {
			return false;
		}
		int rows = arr.length - 1;
		int colums = arr[0].length - 1;

		HashMap<SubMatrixIdentifier, Set<Integer>> subMatrixesCache = new HashMap<SubMatrixIdentifier, Set<Integer>>();
		HashMap<Integer, Set<Integer>> datByRowId = new HashMap<Integer, Set<Integer>>();
		HashMap<Integer, Set<Integer>> dataByColumnId = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < colums; j++) {
				Set<Integer> row = datByRowId.get(i);
				Set<Integer> column = dataByColumnId.get(j);
				Set<Integer> subMatrix = subMatrixesCache.get(new SubMatrixIdentifier(i / 3, j / 3));
				int element = arr[i][j];
				System.out.println("element " + element + "    i = " + i + "  j = " + j);
				if (element == 0) {
					continue;
				}
				if (row != null) {
					if (row.contains(element)) {
						return false;
					} else {
						// System.out.println("added to row "+i+ " element = "+element);
						row.add(element);
					}
				} else if (row == null) {
					Set<Integer> rowData = new HashSet<Integer>();
					rowData.add(element);
					// System.out.println("added to row "+i+ " element = "+element);
					datByRowId.put(i, rowData);
				}
				if (column != null) {

					if (column.contains(element)) {
						return false;
					} else {
						System.out.println("added to column " + j + " element = " + element);
						column.add(element);
					}

				} else if (column == null) {
					Set<Integer> columnData = new HashSet<Integer>();
					columnData.add(element);
					System.out.println("added to column " + j + " element = " + element);
					dataByColumnId.put(j, columnData);
				}
				if (subMatrix != null) {
					if (subMatrix.contains(element)) {
						return false;
					} else {
						subMatrix.add(element);
					}
				} else if (subMatrix == null) {
					Set<Integer> subMatrixToStore = new HashSet<Integer>();
					subMatrixToStore.add(element);
					subMatrixesCache.put((new SubMatrixIdentifier(i, j)), subMatrixToStore);

				}

			}
		}

		// TODO Auto-generated method stub
		return true;
	}
}

class SubMatrixIdentifier {
	int x;
	int y;

	public SubMatrixIdentifier(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubMatrixIdentifier other = (SubMatrixIdentifier) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubMatrixIdentifier [x=" + x + ", y=" + y + "]";
	}

}