package LinkedList;

public class DeleteKthNodeFromTheLast {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d= new Node(4);
		a.next = b;
		b.next = c;
		c.next=d;
		a = delete(null, 3);
		System.out.println(a);

	}

	private static Node delete(Node a, int i) {
		if (a == null) {
			return a;
		}
		Node front = a;
		Node back = a;
		int pos = 0;
		while (pos < i) {
			front = front.next;
			pos++;
		}
		while (front != null) {
			back = back.next;
			front = front.next;
		}

		if (back.next == null) {
			if (back == a) {
				a = null;
			}
			back = null;
		} else {

			back.val = back.next.val;
			Node nextNode = back.next.next;
			back.next = nextNode;
		}
		return a;
	}
}
