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

	@Override
	public String toString() {
		return String.format("%-10s - %d $", getName(), getPrice());
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

	/* --- static methods --- */
	public static Service newService() {
		Service service = new Service();
		String name;
		int price;

		name = Main.enterStringValue("Service name: ");
		price = Main.enterIntValue("Service price $: ", 0, 10000);

		service.setName(name);
		service.setPrice(price);

		return service;
	}
}
