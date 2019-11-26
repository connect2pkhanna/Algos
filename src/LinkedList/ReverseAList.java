package LinkedList;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseAList {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a.next = b;
		b.next = c;
		//c.next = d;
		a=reverse(a);
		System.out.println(a);
	}

	private static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node prev = null;
		Node current = head;
		Node next = current.next;
		
		while (current != null) {
			current.next = prev;
			prev = current;
			current = next;
			if (next != null) {
				next = next.next;
			}
		}
		
		head = prev;
		return head;
	}
}
