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
	public int menu(TicketsManager ticketsManager) {
		return 1;
	}
	/* --- menu --- */

	/* --- menu realization--- */
	public int printTourists() {
		System.out.println("\n --- Tourists --- ");
		if (tourists == null || tourists.isEmpty()) {
			return 0;
		}

		return 1;
	}

	public void addTourist() {
		System.out.println("\n --- Add tourist --- ");
		Tourist tourist = new Tourist();

		if (tourist != null) {
			appendTourist(tourist);
		}
		System.out.println(" --- Add tourist --- ");
	}
	/* --- menu realization--- */

	/* --- others --- */
	public boolean printTouristsIndex() {
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
