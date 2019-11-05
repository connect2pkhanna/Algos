package wordSearchInAMatrix;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
//https://leetcode.com/problems/word-search/
public class SearchWordInMatrix {
//
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABC";
		boolean isFound = search(board, 0, word, new Position(0, 0));
		System.out.println(isFound);
	}

	public static boolean search(char[][] board, int indexInAWord, String word, Position pos) {

		;
		if (indexInAWord > word.length() - 1) {
			return false;
		}
		if (isPositionAMatch(pos, board, word.charAt(indexInAWord))) {
			// return true only when the matched char is the last match in the word
			if (indexInAWord == word.length() - 1) {
				return true;
			}
			if (indexInAWord < word.length() - 1) {
				List<Position> neighBours = getNeighBours(board, pos);

				for (Position position : neighBours) {
					if (search(board, indexInAWord + 1, word, position)) {
						return true;
					}

				}
			}

		}
		return false;
	}

	static boolean isPositionAMatch(Position pos, char[][] board, char expectedChar) {

		int rowNum = pos.x;
		int columNum = pos.y;

		if (board[rowNum][columNum] != expectedChar) {
			return false;
		}	
		
		return true;
	}

	static List<Position> getNeighBours(char[][] board, Position pos) {
		List<Position> neighPositions = new ArrayList<Position>();
		int x = pos.x;
		int y = pos.y;
		if (x + 1 <= board.length - 1)
			neighPositions.add(new Position(x + 1, y));
		if (x - 1 >= 0 && x - 1 <= board.length - 1)
			neighPositions.add(new Position(x - 1, y));
		if (y + 1 <= board[0].length - 1)
			neighPositions.add(new Position(x, y + 1));
		if (y - 1 >= 0 && y - 1 <= board[0].length - 1)
			neighPositions.add(new Position(x, y - 1));
		return neighPositions;
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

};
