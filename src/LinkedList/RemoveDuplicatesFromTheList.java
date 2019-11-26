package LinkedList;

public class RemoveDuplicatesFromTheList {
public static void main(String[] args) {
	Node a = new Node(1);
	Node b = new Node(1);
	Node c = new Node(2);
	Node d = new Node(3);
	Node e = new Node(3);
	a.next = b;
	b.next = c;
	c.next = d;
	d.next=e;
	removeDuplicates(a);
	System.out.println(a);
}

private static void removeDuplicates(Node head) {
	Node current=head;//1
	Node nList=head;//1
	while(current!=null) {
		
		while(current.next!=null && current.val==current.next.val) {
			current=current.next;//1(2)
		}
		
		nList.next=current.next;//
		nList=nList.next;//2
		current=current.next;//2	
	}	
}
}
