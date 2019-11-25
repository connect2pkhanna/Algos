package LinkedList;

public class FindMid {
//https://leetcode.com/problems/middle-of-the-linked-list/
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		// Node d= new Node(4);
		a.next = b;
		b.next = c;
		// c.next=d;
		Node mid = findMid(a);
		System.out.println(mid==null?null:mid.toString());
		
		
		
	}

	private static Node findMid(Node head) {
		Node current = head;
		Node slower = head;
		while (current != null) {
			current = current.next;
			if (current != null) {
				current = current.next;
				slower = slower.next;
			}
		}
		return slower;
	}
}
