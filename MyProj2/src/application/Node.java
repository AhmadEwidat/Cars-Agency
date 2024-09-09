package application;

public class Node {
	private Order element;
	private Node next;

	public Node(Order element) {
		this(element, null);
	}

	public Node(Order element, Node next) {
		this.element = element;
		this.next = next;
	}

	public Order getElement() {
		return element;
	}

	public void setElement(Order element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
