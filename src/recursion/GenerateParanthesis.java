package recursion;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParanthesis {
	public static void main(String[] args) {
		int pairOfParanthesis = 4;
		generate(pairOfParanthesis, 1, 0, "(");

	}

	private static void generate(int pairOfParanthesis, int openBrackets, int closedBrackets, String str) {
		// if no pairs to generate ,do not print anything and return
		if (pairOfParanthesis < 1) {
			return;
		}
		// if recursions occur so far form a well formed output i.e closed==open &&
		// len=2*pairsTogenrate
		if (str.length() == 2 * pairOfParanthesis) {
			System.out.println(str);
			return;
		}
		// if opened so far equal to pairs to generate ,we have to then close them
		if (openBrackets == pairOfParanthesis && closedBrackets < pairOfParanthesis) {
			generate(pairOfParanthesis, openBrackets, closedBrackets + 1, str + ")");
			return;
		}
		String initialString = str;
		generate(pairOfParanthesis, openBrackets + 1, closedBrackets, initialString + "(");
		// do not close any bracket when all are closed or closed brackets so far equal
		// to the pairs to genrate
		if (closedBrackets == openBrackets || closedBrackets == pairOfParanthesis) {
			return;
		}
		generate(pairOfParanthesis, openBrackets, closedBrackets + 1, initialString + ")");

	}
}
