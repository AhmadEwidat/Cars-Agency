package application;

//queue thats have the in process nodes
public class LinkedListQueue {
	private Node front, rear;
	private int size;

	public LinkedListQueue() {
		front = rear = null;
		size = 0;
	}

	public void enqueue(Order element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			front = rear = newNode;
			size++;
		} else {
			rear.setNext(newNode);
			rear = newNode;
			size++;
		}
	}

	public Order dequeue() {
		Order element = null;

		if (isEmpty()) {
			System.out.println("Empty Queue");
			return null;
		} else {
			element = front.getElement();
			front = front.getNext();
			size--;
			if (isEmpty()) {
				rear = null;
			}
		}
		return element;

	}

	public Order front() {// returns front
		if (isEmpty()) {
			System.out.println("Error: cannot return front from empty queue");
			return null;
		}
		return front.getElement();
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;

	}

	public String toString() {
		String result = "";
		Node current = front;
		while (current != null) {
			result = result + current.getElement() + "\n";
			current = current.getNext();
		}
		return result;
	}

}
