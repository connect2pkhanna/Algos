package LinkedList;
//https://gist.github.com/yitonghe00/a5cf958f85c24b2d89d7a0a75b1b4f6b
public class PlusOneLinkedList {
public static void main(String[] args) {
	Node a = new Node(9);
	Node b = new Node(9);
	Node c = new Node(9);
	Node d = new Node(9);
	Node e = new Node(9);
	a.next = b;
	b.next = c;
	c.next = d;
	d.next=e;
	int out=plusOne(a);
	if(out!=0) {
		Node node= new Node(1);
		node.next=a;
		a=node;
	}
	
	System.out.println(a);
	
	
}

private static int plusOne(Node node) {
	if(node.next==null) {
		int currentVal=node.val;
		int newVal=currentVal+1;
		if(newVal>9) {
			node.val=0;
			return 1;
		}else {
			return 0;
		}
	}
	int out=plusOne(node.next);
	if(out!=0) {
		int currentVal=node.val;
		int newVal=currentVal+1;
	
		if(newVal>9) {
			node.val=0;
			return 1;
		}
		node.val=newVal;
	}
	
	return 0;
}
}
