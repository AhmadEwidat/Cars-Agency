package application;

//node in the single linked list
public class InputCarNode {
	private Car car;
	private InputCarNode next;

	public InputCarNode(Car car) {
		this(car, null);
	}

	public InputCarNode(Car car, InputCarNode next) {
		this.car = car;
		this.next = next;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public InputCarNode getNext() {
		return next;
	}

	public void setNext(InputCarNode next) {
		this.next = next;
	}

}
