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
	public void menu(TouristsManager touristsManager) {
		while (true) {
			int menuSelect = 0;

			System.out.println("\n --- Tickets manager menu --- ");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Print available tickets");
			System.out.println(" 2. Add new ticket");
			System.out.println(" 3. Delete ticket");

			menuSelect = Main.enterIntValue("Select an item:", 0, 3);
			System.out.println(" --- Tickets manager menu --- ");

			switch (menuSelect) {
				case 0:
					return;
				case 1:
					printAvailableTicketsUI();
					break;
				case 2:
			 		addTicketUI();
					break;
				case 3:
					deleteTicketUI(touristsManager);
					break;
			}
		}
	}
	/* --- menu --- */

	/* --- menu realization--- */
	private void printAvailableTicketsUI() {
		System.out.print("\n --- Available tickets --- ");
		if (ticketManagers == null || ticketManagers.isEmpty()) {
			System.out.println("\nTickets list is empty");
		} else {
			for (TicketManager ticketManager : ticketManagers) {
				System.out.println(ticketManager);
			}
		}

		System.out.println("\n --- Available tickets --- ");
	}

	private void addTicketUI() {
		System.out.println("\n --- Add ticket manager --- ");
		TicketManager ticketManager = TicketManager.newTicketManager();

		if (ticketManager != null) {
			appendTicketManager(ticketManager);
		}
		System.out.println(" --- Add ticket manager --- ");
	}

	private void deleteTicketUI(TouristsManager touristsManager) {
		System.out.println("\n --- Delete ticket --- ");
		TicketManager ticketManager = getTicketManager();

		if (ticketManager != null) {
			ticketManager.close(touristsManager);
			removeTicketManager(ticketManager);
		}
		System.out.println(" --- Delete ticket --- ");
	}
	/* --- menu realization--- */

	/* --- getters & setters --- */
	private TicketManager getTicketManager() {
		if (!printTicketManagersIndex()) {
			return null;
		}

		int ticketManagerIndex = Main.enterIntValue("Select an item:", 0, ticketManagers.size() - 1);
		return ticketManagers.get(ticketManagerIndex);
	}
	/* --- getters & setters --- */

	/* --- others --- */
	private boolean printTicketManagersIndex() {
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

	public void deleteCreatedTicket(Ticket ticket) {
		for (TicketManager ticketManager : ticketManagers) {
			ticketManager.deleteCreatedTicket(ticket);
		}
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
