package LinkedList;

public class ReorderList {
	//https://leetcode.com/problems/reorder-list/
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		a.next = b;
		// b.next = c;
		// c.next = d;
		// d.next = e;
		a = reorder(a);
	}

	private static Node reorder(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		int len = 0;
		Node current = head;
		while (current != null) {
			len++;
			current = current.next;
		}
		System.out.println(len);

		Node slow = head;
		Node fast = head;

		while (fast != null) {
			fast = fast.next;
			if (fast != null && fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		if (len == 2) {
			Node start = head;

			// reverse the list
			head = head.next;
			head.next = start;
			start.next = null;
			System.out.println(head);
			return head;
		}
		// reverse the other half
		Node rightStart = slow.next;
		// 1-2-3-4
		current = rightStart;
		Node prev = null;
		Node next = rightStart;
		while (current != null) {
			next = current.next;// null
			current.next = prev; // 4-3-null
			prev = current;// 4
			current = next;// null
			if (current != null) {
				next = current.next;
			}

		}

		slow.next = prev;

		System.out.println(head);
		if (len % 2 == 0) {
			rightStart = slow.next;
			Node mid = slow;
			slow.next = null;
			Node leftStart = head;
			// 1-2-3

			while (leftStart != null && rightStart != null) {
				Node leftNext = leftStart.next;// 2
				Node rightNext = rightStart.next;// null
				leftStart.next = rightStart;// 1-3
				rightStart.next = leftNext;// 1-3-2
				leftStart = leftNext;// 2
				rightStart = rightNext;// null

			}
			System.out.println(head);
			// TODO Auto-generated method stub
			return head;
		} else {

			rightStart = slow.next;
			Node mid = slow;
			slow.next = null;
			Node leftStart = head;
			// 1-2-3

			while (leftStart != mid && rightStart != null) {
				if (leftStart == mid) {
					break;
				}
				Node leftNext = leftStart.next;// 2
				Node rightNext = rightStart.next;// null
				leftStart.next = rightStart;// 1-3
				rightStart.next = leftNext;// 1-3-2
				leftStart = leftNext;// 2
				rightStart = rightNext;// null

			}
			System.out.println(head);
			// TODO Auto-generated method stub
			return head;

		}
	}
}
