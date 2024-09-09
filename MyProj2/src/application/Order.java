package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private Car car;
	private Customer customer;
	private Date orderDate;
	private String OrderStatus;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	public Order(Car car, Customer customer, Date orderDate, String orderStatus) {
		this.car = car;
		this.customer = customer;
		this.orderDate = orderDate;
		OrderStatus = orderStatus;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public String getOrderDateAsString() {
		return dateFormat.format(orderDate);
	}

	@Override
	public String toString() {
		return "Order [car=" + car.toString() + "\n" + ", customer=" + customer.toString() + "\n" + ", orderDate="
				+ orderDate + "]";
	}

	public String toString1() {
		Date currentDate = new Date();

		// Retrieve the current date
		int year = currentDate.getYear() + 1900; // Add 1900 to get the actual year
		int month = currentDate.getMonth() + 1; // Add 1 to get the actual month (0-indexed)
		int day = currentDate.getDate();

		return "" + customer.toString1() + ", " + car.toString1() + ", " + year + "/" + month + "/" + day + ", "
				+ OrderStatus;
	}

}
