package LinkedList;

public class DeleteKthNodeFromTheLast {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d= new Node(4);
		//a.next = b;
		//b.next = c;
		//c.next=d;
		a = delete(a, 1);
		System.out.println(a);

	}

	private static Node delete(Node a, int i) {
		if (a == null) {
			return a;
		}
		
		Node front = a;
		Node back = a;
		int pos = 0;
		// it assumed that the value of i is not going to be greater than the length of the list
		while (pos < i) {
			front = front.next;
			pos++;
		}
		if(front==null) {
			// the whole list is already traversed , this means that the head is to be removed
			Node next=a.next;
			a.next=null;
			a=next;
			return a;
		}
		while (front.next!= null) {
			back=back.next;
			front=front.next;
		}
		back.next=back.next.next;
		return a;
	}
}
