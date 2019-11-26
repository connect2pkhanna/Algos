package LinkedList;

import java.util.Stack;
// https://leetcode.com/problems/palindrome-linked-list/ The solution is o(n) time complexity and o(n) space complexity
public class PalindromeLinkedList {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(1);
		Node c = new Node(2);
		Node d = new Node(2);
		//a.next = b;
		//b.next = c;
		//c.next = d;
		System.out.println(checkIfPalindrome(a));
	}

	private static boolean checkIfPalindrome(Node head) {
		if (head == null) {
			return false;
		}

		Node current = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}
		current = head;
		while (!stack.isEmpty()) {
			if (stack.pop() != current.val) {
				return false;
			}
			current = current.next;
		}

		return true;
	}
}
