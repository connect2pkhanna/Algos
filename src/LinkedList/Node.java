package LinkedList;

public class Node {
	@Override
	public String toString() {
		return "Node [val=" + val + ", next=" + next + "]";
	}

	public int val;
	public Node next;

	public Node(int val) {
		this.val = val;
	}
}
