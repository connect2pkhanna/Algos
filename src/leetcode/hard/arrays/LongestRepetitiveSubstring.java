package leetcode.hard.arrays;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/longest-duplicate-substring/
// The below solution's time complexity is O(n^2) and space complexity is max O(n) ,incase all the characters are unique
//PLEASE NOTE : Iterative solution is better, i will move this solution to iterative to avoid the stackOverFlow due to recursion for large arrays
public class LongestRepetitiveSubstring {
// the question wants to output the consequetive longest substring which is repeated
	/*
	 * Given a string S, consider all duplicated substrings: (contiguous) substrings
	 * of S that occur 2 or more times. (The occurrences may overlap.)
	 * 
	 * Return any duplicated substring that has the longest possible length. (If S
	 * does not have a duplicated substring, the answer is "".)
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: "banana" Output: "ana" Example 2:
	 * 
	 * Input: "abcd" Output: ""
	 */

	public static void main(String[] args) {
		//String str = "abcdabc";
		//String str="aabcd";
		String str="";
		HashMap<Integer, HashSet<String>> map = new HashMap();
		String longestRepetitive="";
		for (int i = 0; i <=str.length() - 1; i++) {
			//pass longestRepetitive if this iteration finds a longer string than longestRepetitive ,it returns ,else it returns the same
			longestRepetitive=findLongestRepetitiveSubstring("", i, str.length() - 1, str, longestRepetitive.length(), longestRepetitive, map);
		}
		System.out.println("final answer = "+longestRepetitive);

	}

	private static String findLongestRepetitiveSubstring(String currentString, int i, int len, String originalString,
			int longestLengthFound, String longestStringRepetitive, HashMap<Integer, HashSet<String>> map) {
		if (i > len) {
			return longestStringRepetitive;
		}
		String sub = currentString + originalString.charAt(i);
		
		// check if map.get(len).contains(sub) // if yes ,check if len > currentMaxLen
				// ,if yes , update len to this len and clear all keys lesser than len
				// if no , just add
		int lenSub=sub.length();
		if (sub.length() > longestLengthFound) {
			if (map.containsKey(sub.length())) {
				if (map.get(lenSub).contains(sub)) {
					longestLengthFound = lenSub;
					longestStringRepetitive = sub;
					System.out.println("mostt repetetive so far "+sub);
					// remove all strings with smaller len as we have foudnd the a longer repetitive str
					int count=1;
					while (count<longestLengthFound) {
						map.remove(count);
						count++;
					}
					
				} else {
					map.get(lenSub).add(sub);
				}
			} else {
				HashSet<String> set = new HashSet<String>();
				set.add(sub);
				map.put(lenSub, set);
			}
		}
		
		
		return findLongestRepetitiveSubstring(sub, i + 1, len, originalString, longestLengthFound, longestStringRepetitive,
				map);
	}

}
