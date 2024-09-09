package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;

//double linked list for Brands
class DoublyLinkedList1 {
	private CarNode head;
	private CarNode tail;
	private String duplicate = "";
	private String string = "";
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}

	private ArrayList arrayList = new ArrayList();

	public ArrayList getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList arrayList) {
		this.arrayList = arrayList;
	}

	public void insertOrderedBrand(String Brand) {
		CarNode newNode = new CarNode(Brand);

		if (head == null) {
			head = newNode;
			tail = newNode;
			duplicate = "its done";
		} else {
			CarNode current = head;
			while (current != null) {

				int comparison = Brand.compareToIgnoreCase(current.getBrand());
				if (comparison == 0) {
					duplicate = "this brand is already exist";
					// Duplicate brand found, no need to insert
					return;
				} else if (comparison < 0) {
					// Insert newNode before current node
					if (current == head) {
						newNode.setNext(current);
						current.setPrev(newNode);
						head = newNode;
						duplicate = "its done";
					} else {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
						duplicate = "its done";
					}

					return;
				}
				current = current.getNext();
			}

			// Insert newNode at the end of the list
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	public void printAllMartyrsWithLocations() {
		CarNode current = head;
		while (current != null) {
			InputCarNode carNode = current.getLinked().getHead();

			while (carNode != null) {
				Car car = carNode.getCar();

				System.out.println(car.getBrand() + ", " + car.getmodel() + ", " + car.getColor() + " ,"

						+ car.getYear() + ", " + car.getPrice() + "\n");

				carNode = carNode.getNext();
			}

			current = current.getNext();
			// Add an empty line between locations
		}

	}

	public void insertOrUpdateCar(String Brand, Car car) {
	
		if (head == null) {
			CarNode newNode = new CarNode(Brand);
			newNode.getLinked().insertSorted(car);
			head = newNode;
			tail = newNode;
		} else {
			CarNode current = head;

			while (current != null) {
				if (current.getBrand().equals(Brand)) {
					current.getLinked().insertSorted(car);
					return;
				}
				current = current.getNext();
			}


			CarNode newNode = new CarNode(Brand);
			newNode.getLinked().insertSorted(car);

			if (Brand.compareToIgnoreCase(head.getBrand()) < 0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else if (Brand.compareToIgnoreCase(tail.getBrand()) > 0) {
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			} else {
				current = head.getNext();
				while (current != null) {
					if (Brand.compareToIgnoreCase(current.getBrand()) < 0) {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
						break;
					}
					current = current.getNext();
				}
			}
		}
	}

	public void display() {
		CarNode current = head;
		arrayList.removeAll(arrayList);
		while (current != null) {
			arrayList.add(current.getBrand());
			current = current.getNext();
		}
	}

	public boolean searchLocation(String brand) {
		CarNode current = head;
		while (current != null) {
			if (current.getBrand().equalsIgnoreCase(brand)) {
				return true;
			}
			current = current.getNext();
		}

		return false;
	}

	public boolean updateBrand(String oldBrand, String newBrand) {
		CarNode current = head;
		boolean BrandUpdated = false;
		while (current != null) {
			if (current.getBrand().equalsIgnoreCase(oldBrand)) {
				current.setBrand(newBrand);

				BrandUpdated = true;
			}
			current = current.getNext();
		}
		return BrandUpdated;
	}

	public void deleteBrand(String Brand) {
		CarNode current = head;

		while (current != null) {
			if (current.getBrand().equals(Brand)) {
				CarNode prev = current.getPrev();
				CarNode next = current.getNext();

				if (prev != null) {
					prev.setNext(next);
				} else {
					head = next;
				}

				if (next != null) {
					next.setPrev(prev);
				} else {
					tail = prev;
				}

				break;
			}

			current = current.getNext();
		}
	}

	public boolean Find(Car car) {
		CarNode current = head;
		while (current != null) {
			InputCarNode carNode = current.getLinked().getHead();
			while (carNode != null) {
				if (carNode.getCar().compareTo(car) == 0) {
					return true;
				}
				carNode = carNode.getNext();
			}
			current = current.getNext();

		}
		return false;
	}

	public void displayAllCarsByBrand(String Brand) {
		CarNode current = head;
		boolean Found = false;
		string = "";
		while (current != null) {

			if (current.getBrand().equals(Brand)) {

				string += ("Car: " + current.getBrand() + "\n");
				current.getLinked().display();
				string += (current.getLinked().getString());

				Found = true;
			}
			current = current.getNext();
		}

		if (!Found) {
			string += ("Car not found: " + Brand);
		}
	}

	public void filter(String brand, String model, String color, Integer minYear, Integer maxYear, Double minPrice,
			Double maxPrice) {
		CarNode current = head;
		boolean found = false;
		string = "";

		while (current != null) {
			if (current.getBrand().equalsIgnoreCase(brand)) {
				InputCarNode carNode = current.getLinked().getHead();
				while (carNode != null) {
					Car car = carNode.getCar();
					boolean match = true;

					if (model != null && !model.isEmpty() && !car.getmodel().equalsIgnoreCase(model)) {
						match = false;
					}
					if (color != null && !color.isEmpty() && !car.getColor().equalsIgnoreCase(color)) {
						match = false;
					}
					if (minYear != null && car.getYear() < minYear) {
						match = false;
					}
					if (maxYear != null && car.getYear() > maxYear) {
						match = false;
					}
					if (minPrice != null && car.getPrice() < minPrice) {
						match = false;
					}
					if (maxPrice != null && car.getPrice() > maxPrice) {
						match = false;
					}

					if (match) {
						string += "Car Found: " + car.getBrand() + ", " + car.getmodel() + ", " + car.getColor() + ", "
								+ car.getYear() + ", " + car.getPrice() + "\n";
						this.car = car;
						found = true;
					}
					carNode = carNode.getNext();
				}
			}
			current = current.getNext();
		}

		if (!found) {
			string += "No cars found with the specified criteria in brand: " + brand;
		}
	}

}
