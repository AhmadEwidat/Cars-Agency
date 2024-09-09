package application;

//node from double linked list
public class CarNode {
	private CarNode next;
	private CarNode prev;
	private SingleLinked linked;
	private String Brand;

	public CarNode(String Brand) {
		this.next = null;
		this.prev = null;
		this.linked = new SingleLinked();
		this.Brand = Brand;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public CarNode getNext() {
		return next;
	}

	public void setNext(CarNode next) {
		this.next = next;
	}

	public CarNode getPrev() {
		return prev;
	}

	public void setPrev(CarNode prev) {
		this.prev = prev;
	}

	public SingleLinked getLinked() {
		return linked;
	}

	public void setLinked(SingleLinked linked) {
		this.linked = linked;
	}

}
