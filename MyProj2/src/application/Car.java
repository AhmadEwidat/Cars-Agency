package application;

//car class 
public class Car implements Comparable {
	private String brand;
	private String model;
	private int year;
	private String color;
	private double price;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Car(String brand, String model, int year, String color, double price) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", year=" + year + ", color=" + color + ", price=" + price
				+ "]";
	}

	public String toString1() {
		return "" + brand + ", " + model + ", " + year + ", " + color + ", " + price + "";
	}

	@Override
	public int compareTo(Object o) {
		if (brand.equalsIgnoreCase(((Car) o).getBrand()) && model.equalsIgnoreCase(((Car) o).getmodel())
				&& year == ((Car) o).getYear() && color.equalsIgnoreCase(((Car) o).getColor())
				&& price == ((Car) o).getPrice()) {
			return 0;
		} else
			return 1;
	}

}
