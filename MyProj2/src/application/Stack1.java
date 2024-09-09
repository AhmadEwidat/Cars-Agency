package application;

public class Stack1 {
	private int size;
	private Node head;
	private int max;

	public Stack1() {
		head = null;
		size = 0;
	}

	public void push(Order element) {
		Node node = new Node(element);
		node.setNext(head);
		head = node;
		size++;
	}

	public Order pop() {
		if (!isEmpty()) {
			Node top = head;
			head = head.getNext();
			size--;
			return top.getElement();
		} else
			return null;

	}

	public Order peek() {
		// Return the top element without changing the stack
		if (!isEmpty())
			return head.getElement();
		else
			return null;
	}

	public boolean isEmpty() {
		return (head == null); // return true if the stack is empty
	}

	public int Size() {
		return size;
	}

//	public void insertOrderd(int element) {
//		Stack1 sNew = new Stack1();
//
//		if (isEmpty()) {
//			push(element);
//		} else if (element > (Integer) (peek())) {
//			push(element);
//		} else {
//			while (!isEmpty()) {
//				sNew.push(pop());
//				if (!isEmpty()) {
//					if (element > (Integer) (peek())) {
//						push(element);
//						while (!sNew.isEmpty()) {
//							push(sNew.pop());
//						}
//						break;
//					}
//				} else {
//					push(element);
//					while (!sNew.isEmpty()) {
//						push(sNew.pop());
//					}
//					break;
//				}
//			}

}
