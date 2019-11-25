package LinkedList;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class FindTheNodeWhereTheCycleBegins {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next=b;
       Node nodeWithinTheCycle= IfCycleIsPresentStopAndReturnTheNodeWhichIsaPartOfCycle(a);
       if(nodeWithinTheCycle!=null) {
    	  long cycleLen= findTheLengthOfTheCycle(nodeWithinTheCycle);
    	  // move ptr1 by cycleLen ,move ptr1 and ptr2 ,until they meet l
    	  Node ptr1=a;
    	  Node ptr2=a;
    	  int lenMoved=0;//as a is not null
    	  while(lenMoved<cycleLen) {
    		  ptr1=ptr1.next;// no need of null check as null is never found as there is a cycle
    		  lenMoved++;
    	  }
    	  //move both pointers
    	  while(ptr2!=ptr1) {
    		  ptr2=ptr2.next;
    		  ptr1=ptr1.next;
    	  }
    	  
    	  System.out.println(ptr1);
       }else {
    	   System.out.println("there is no cycle");
       }
		
	}

	private static long findTheLengthOfTheCycle(Node nodeWithinTheCycle) {
		//long for linkedlists of size > than Integer.MAX_VALUE 
		// as nodeWithinTheCycle is definately not null , thus the min size is 1
		long len=1;
		Node current=nodeWithinTheCycle.next;
		while(current!=nodeWithinTheCycle) {
			len++;
			current=current.next;
			
		}
		return len;
	}

	private static Node IfCycleIsPresentStopAndReturnTheNodeWhichIsaPartOfCycle(Node head) {
		Node slower=head;
		Node faster=head.next;
		while(faster!=null && faster!=slower) {
			faster=faster.next;
			if(faster!=null) {
				faster=faster.next;
				slower=slower.next;
			}
			if(faster==slower) {
				return faster;
			}
		}
		return faster!=null?faster:null;
	}
}
