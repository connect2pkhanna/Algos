package stack;

import java.util.EmptyStackException;
import java.util.Stack;
//https://leetcode.com/problems/min-stack/
public class MinStack implements stack {
	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	@Override
	public int pop() throws EmptyStackException {
		if (dataStack.isEmpty()) {
			throw new EmptyStackException();
		}
		if (dataStack.peek() == minStack.peek()) {
			minStack.pop();

		}
		// TODO Auto-generated method stub
		return dataStack.pop();
	}

	@Override
	public void push(int val) {
		if (this.dataStack.isEmpty()) {
			dataStack.push(val);
			minStack.push(val);
		} else {
			if (val <=minStack.peek()) {
				minStack.push(val);
			}
			dataStack.push(val);
		}

	}

	@Override
	public int min() throws EmptyStackException {
		if (minStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return minStack.peek();
	}

	@Override
	public int peek() {
		if (dataStack.isEmpty()) {
			throw new EmptyStackException();
		}
		return dataStack.peek();
	}

	public boolean isEmpty() {
		return dataStack.size() > 0 ? true : false;
	}
     public static void main(String[] args) {
    	 MinStack stack= new MinStack();
    	 stack.push(3);
    	 stack.push(3);
    	 stack.pop();
    	 System.out.println(stack.min());
    	 stack.push(1);
    	 System.out.println(stack.min());
    	 stack.pop();
    	 System.out.println(stack.min());
	}
}

interface stack {
	int pop();

	void push(int val);

	int min();

	int peek();
}

