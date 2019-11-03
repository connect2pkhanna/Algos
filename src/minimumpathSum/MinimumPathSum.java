package minimumpathSum;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
	private static int minSum = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		dfs(arr, new Position(0, 0), arr[0][0]);
		System.out.println(minSum);
	}

	private static void dfs(int[][] arr, Position pos, int sum) {
		System.out.println(pos.toString() + " sum = " + sum);
		List<Position> positions = getNextPositions(pos.x, pos.y, arr);

		for (Position position : positions) {

			if (position.x == arr.length - 1 && position.y == arr[0].length - 1) {
				minSum = Math.min(minSum, sum+arr[position.x][position.y]);
				return;
			}
			dfs(arr, position, sum + arr[position.x][position.y]);

		}

	}

	private static List<Position> getNextPositions(int i, int j, int[][] arr) {
		List<Position> positions = new ArrayList<Position>();
		Position down = new Position(i + 1, j);
		Position right = new Position(i, j + 1);
		if (isValid(down, arr)) {
			positions.add(down);
		}
		if (isValid(right, arr)) {
			positions.add(right);
		}

		return positions;
	}

	static boolean isValid(Position pos, int[][] arr) {
		int i = pos.x;
		int j = pos.y;

		if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1) {
			return false;
		}
		return true;
	}

}

class Position {

	int x;
	int y;

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

}