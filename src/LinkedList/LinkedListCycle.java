package LinkedList;
//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a=null;
		//a.next = a;
		//b.next = c;
		//c.next = b;
	boolean isPresent=	findIfCycleIsThere(a);
	System.out.println(isPresent);
	}

	private static boolean findIfCycleIsThere(Node head) {
		if(head==null) {
			return false;
		}
		Node faster=head.next;//1
		Node slower=head;//1
		while(faster!=null && faster!=slower) {
			faster=faster.next;//2
			if(faster!=null) {
				faster=faster.next;//3
				slower=slower.next;//3
			}
			if(faster==slower) {
				return true;
			}
			
			
		}
		
		return faster==slower?true:false;
	}
}
