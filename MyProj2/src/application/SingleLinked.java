package application;

public class SingleLinked {
	private InputCarNode head;
	String string = "";

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public InputCarNode getHead() {
		return head;
	}

	public void setHead(InputCarNode head) {
		this.head = head;
	}

	public void insertSorted(Car car) {
		InputCarNode newNode = new InputCarNode(car);

		if (head == null) {
			head = newNode;
		} else if (car.getYear() > (head.getCar().getYear())) {
			// Insert at the beginning
			newNode.setNext(head);
			head = newNode;
		} else {
			InputCarNode current = head;
			while (current.getNext() != null && car.getYear() < (current.getNext().getCar().getYear())) {
				current = current.getNext();
			}

			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}

	public void display() {
		string = "";
		InputCarNode current = head;
		while (current != null) {
			string += (current.getCar() + "\n");

			current = current.getNext();
		}
	}

}
