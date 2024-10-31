package TravelAgency.TicketsManager.TicketManager.ServicesManager;

import Main.Main;

public class Service {
	public String name;
	public int price;

	public Service() {

	}

	public Service(String name, int price) {
		setName(name);
		setPrice(price);
	}

	public Service cloneObject() {
		return new Service(getName(), getPrice());
	}

	/* --- getters & setters --- */
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	/* --- getters & setters --- */

}
