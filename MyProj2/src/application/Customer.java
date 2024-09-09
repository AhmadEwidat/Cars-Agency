package application;

//the customer class and implementation
public class Customer {
	private String name;
	private int mobile;

	public Customer(String name, int mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + "]";
	}

	public String toString1() {
		return "" + name + ", 0" + mobile + "";
	}

}
