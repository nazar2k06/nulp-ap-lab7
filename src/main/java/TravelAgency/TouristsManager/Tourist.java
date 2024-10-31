package TravelAgency.TouristsManager;

import Main.Main;
import TravelAgency.TicketsManager.TicketManager.Ticket;
import TravelAgency.TicketsManager.TicketsManager;

import java.util.ArrayList;

public class Tourist {
	String name;
	ArrayList<Ticket> tickets;

	public Tourist() {
		tickets = new ArrayList<>();
	}

	/* --- menu --- */
	public int menu(TicketsManager ticketsManager) {
		return 1;
	}
	/* --- menu --- */

	/* --- menu realization--- */

	public void addTicket(TicketsManager ticketsManager) {
		System.out.println("\n --- Add ticket --- ");
		Ticket ticket = new Ticket();

		if (ticket != null) {
			appendTicket(ticket);
		}

		System.out.println(" --- Add ticket --- ");
	}
	/* --- menu realization--- */

	/* --- getters & setters --- */
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAllPrice() {
		if (tickets.isEmpty()) {
			return 0;
		}
		int price = 0;

		if (!tickets.isEmpty()) {
			for (Ticket ticket : tickets) {
				price += ticket.getAllPrice();
			}
		}

		return price;
	}

	public int getTicketsCount() {
		return tickets.size();
	}
	/* --- getters & setters --- */

	/* --- others --- */
	public boolean printTicketsIndex() {
		if (tickets == null || tickets.isEmpty()) {
			System.out.println("Tickets list is empty");
			return false;
		}

		for (int i = 0; i < tickets.size(); i++) {
			System.out.println(" - " + i + "  " + tickets.get(i).getName());
		}

		return true;
	}

	public void appendTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
	}

	public void deleteCreatedTicket(Ticket ticket) {
		tickets.remove(ticket);
	}

	public Ticket getTicket() {
		if (!printTicketsIndex()) {
			return null;
		}

		int touristIndex = Main.enterIntValue("Select a Ticket:", 0, tickets.size() - 1);
		return tickets.get(touristIndex);
	}
	/* --- others --- */

}
