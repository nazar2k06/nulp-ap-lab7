package TravelAgency.TicketsManager;

import Main.Main;
import TravelAgency.TicketsManager.TicketManager.*;
import TravelAgency.TouristsManager.TouristsManager;

import java.util.ArrayList;

public class TicketsManager {
	private ArrayList<TicketManager> ticketManagers;

	public TicketsManager() {
		ticketManagers = new ArrayList<>();
	}

	/* --- menu --- */
	public int menu(TouristsManager touristsManager) {
		return 1;
	}
	/* --- menu --- */

	/* --- menu realization--- */
	public int printAvailableTicketsUI() {
		if (ticketManagers == null || ticketManagers.isEmpty()) {
			return 0;
		}

		return 1;
	}

	public void addTicketUI() {
		TicketManager ticketManager = new TicketManager();
		appendTicketManager(ticketManager);
	}
	/* --- menu realization--- */

	/* --- getters & setters --- */
	public TicketManager getTicketManager() {
		if (!printTicketManagersIndex()) {
			return null;
		}

		int ticketManagerIndex = Main.enterIntValue("Select an item:", 0, ticketManagers.size() - 1);
		return ticketManagers.get(ticketManagerIndex);
	}
	/* --- getters & setters --- */

	/* --- others --- */
	public boolean printTicketManagersIndex() {
		if (ticketManagers == null || ticketManagers.isEmpty()) {
			System.out.println("Tickets list is empty");
			return false;
		}

		for (int i = 0; i < ticketManagers.size(); i++) {
			System.out.println(" - " + i + "  " + ticketManagers.get(i).getName());
		}

		return true;
	}

	public void appendTicketManager(TicketManager ticketManager) {
		ticketManagers.add(ticketManager);
	}

	public void removeTicketManager(TicketManager ticketManager) {
		ticketManagers.remove(ticketManager);
	}

	public Ticket getTicket() {
		if (!printTicketManagersIndex()) {
			return null;
		}

		TicketManager ticketManager;
		int ticketManagerIndex = Main.enterIntValue("Select a ticket:", 0, ticketManagers.size() - 1);

		ticketManager = ticketManagers.get(ticketManagerIndex);

		return ticketManager.getTicket();
	}

	public int getTicketManagersCount() {
		return ticketManagers.size();
	}
	/* --- others --- */

}
