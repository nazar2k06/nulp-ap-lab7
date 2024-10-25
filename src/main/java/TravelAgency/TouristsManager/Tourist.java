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

	public void close(TicketsManager ticketsManager) {
		for (Ticket ticket : tickets) {
			ticket.close(ticketsManager);
		}
	}

	@Override
	public String toString() {
		String string = getName();

		if (!tickets.isEmpty()) {
			for (Ticket ticket : tickets) {
				string += " <" + ticket.getName() + ">";
			}

			string += " Price: " + getAllPrice();
		}

		return string;
	}

	/* --- menu --- */
	public void menu(TicketsManager ticketsManager) {
		while (true) {
			int menu_select = 0;

			System.out.println("\n --- Tourist menu --- ");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Print info");
			System.out.println(" 2. Add ticket");
			System.out.println(" 3. Delete ticket");

			menu_select = Main.enterIntValue("Select an item:", 0, 3);
			System.out.println(" --- Tourist menu --- ");

			switch (menu_select) {
				case 0:
					return;
				case 1:
					printInfo();
					break;
				case 2:
					addTicket(ticketsManager);
					break;
				case 3:
					deleteTicket(ticketsManager);
					break;
			}
		}
	}
	/* --- menu --- */

	/* --- menu realization--- */
	private void printInfo() {
		System.out.println("\n --- Info --- ");
		System.out.println(this);
		System.out.println(" --- Info --- ");
	}

	private void addTicket(TicketsManager ticketsManager) {
		System.out.println("\n --- Add ticket --- ");
		Ticket ticket = ticketsManager.getTicket();

		if (ticket != null) {
			appendTicket(ticket);
		}

		System.out.println(" --- Add ticket --- ");
	}

	private void deleteTicket(TicketsManager ticketsManager) {
		System.out.println("\n --- Delete ticket --- ");
		Ticket ticket = getTicket();

		if (ticket != null) {
			ticket.close(ticketsManager);
			removeTicket(ticket);
		}
		System.out.println(" --- Delete ticket --- ");
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

	/* --- static methods --- */
	public static Tourist newTourist() {
		Tourist tourist = new Tourist();
		String touristName = Main.enterStringValue("Tourist name: ");

		tourist.setName(touristName);
		return tourist;
	}
}
