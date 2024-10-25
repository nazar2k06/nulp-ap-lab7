package TravelAgency.TouristsManager;

import Main.Main;
import TravelAgency.TicketsManager.TicketManager.Ticket;
import TravelAgency.TicketsManager.TicketManager.TicketManager;
import TravelAgency.TicketsManager.TicketsManager;

import java.util.ArrayList;

public class TouristsManager {
	ArrayList<Tourist> tourists;

	public TouristsManager() {
		tourists = new ArrayList<>();
	}

	/* --- menu --- */
	public void menu(TicketsManager ticketsManager) {
		while (true) {
			int menuSelect = 0;

			System.out.println("\n --- Tourists manager menu --- ");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Print tourists");
			System.out.println(" 2. Tourists menu");
			System.out.println(" 3. Add new tourist");
			System.out.println(" 4. Delete tourist");

			menuSelect = Main.enterIntValue("Select an item:", 0, 4);
			System.out.println(" --- Tourists manager menu --- ");

			switch (menuSelect) {
				case 0:
					return;
				case 1:
					printTourists();
					break;
				case 2:
					touristsMenu(ticketsManager);
					break;
				case 3:
					addTourist();
					break;
				case 4:
					deleteTourist(ticketsManager);
					break;
			}
		}
	}
	/* --- menu --- */

	/* --- menu realization--- */
	private void printTourists() {
		System.out.println("\n --- Tourists --- ");
		if (tourists == null || tourists.isEmpty()) {
			System.out.println("Tourists list is empty");
		} else {
			for (Tourist tourist : tourists) {
				System.out.println(tourist);
			}
		}

		System.out.println(" --- Tourists --- ");
	}

	public void touristsMenu(TicketsManager ticketsManager) {
		System.out.println("\n --- Tourist menu --- ");
		Tourist tourist = getTourist();

		if (tourist != null) {
			tourist.menu(ticketsManager);
		}

		System.out.println(" --- Tourist menu --- ");
	}

	private void addTourist() {
		System.out.println("\n --- Add tourist --- ");
		Tourist tourist = Tourist.newTourist();

		if (tourist != null) {
			appendTourist(tourist);
		}
		System.out.println(" --- Add tourist --- ");
	}

	private void deleteTourist(TicketsManager ticketsManager) {
		System.out.println("\n --- Delete tourist --- ");
		Tourist tourist = getTourist();

		if (tourist != null) {
			tourist.close(ticketsManager);
			removeTourist(tourist);
		}
		System.out.println(" --- Delete tourist --- ");
	}
	/* --- menu realization--- */

	/* --- others --- */
	private boolean printTouristsIndex() {
		if (tourists == null || tourists.isEmpty()) {
			System.out.println("Tourists list is empty");
			return false;
		}

		for (int i = 0; i < tourists.size(); i++) {
			System.out.println(" - " + i + "  " + tourists.get(i).getName());
		}

		return true;
	}

	public void appendTourist(Tourist tourist) {
		tourists.add(tourist);
	}

	public void removeTourist(Tourist tourist) {
		tourists.remove(tourist);
	}

	public void deleteCreatedTicket(Ticket ticket) {
		for (Tourist tourist : tourists) {
			tourist.deleteCreatedTicket(ticket);
		}
	}

	public int getTouristCount() {
		return tourists.size();
	}

	public Tourist getTourist() {
		if (!printTouristsIndex()) {
			return null;
		}

		int touristIndex = Main.enterIntValue("Select a tourist:", 0, tourists.size() - 1);
		return tourists.get(touristIndex);
	}
	/* --- others --- */
}
