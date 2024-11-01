package TravelAgency.TicketsManager.TicketManager;

import Main.Main;
import TravelAgency.TicketsManager.TicketManager.ServicesManager.Service;
import TravelAgency.TicketsManager.TicketsManager;

import java.util.ArrayList;

public class Ticket {
	private String name;
	private int price;
	ArrayList<Service> services;

	public Ticket() {
		services = new ArrayList<>();
	}

	public Ticket(String name, int price) {
		setName(name);
		setPrice(price);

		services = new ArrayList<>();
	}

	public Ticket cloneObject() {
		return new Ticket(getName(), 0);
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

	public int getAllPrice() {
		if (services.isEmpty()) {
			return getPrice();
		}
		int price = getPrice();

		for (Service service : services) {
			price += service.getPrice();
		}

		return price;
	}

	public int getServicesCount() {
		return services.size();
	}
	/* --- getters & setters --- */

	/* --- others --- */
	public void addService(Service service) {
		if (service != null) {
			services.add(service);
		}
	}
	/* --- others --- */
}
