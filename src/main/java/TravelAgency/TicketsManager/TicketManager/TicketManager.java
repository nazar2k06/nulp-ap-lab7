package TravelAgency.TicketsManager.TicketManager;

import Main.Main;
import TravelAgency.TicketsManager.TicketManager.ServicesManager.Service;
import TravelAgency.TicketsManager.TicketManager.ServicesManager.ServicesManager;
import TravelAgency.TouristsManager.Tourist;
import TravelAgency.TouristsManager.TouristsManager;

import java.util.ArrayList;

public class TicketManager {
	int availableCount;
	Ticket demoTicket;
	ArrayList<ServicesManager> availableServicesManager;
	ArrayList<Ticket> createdTickets;

	public TicketManager() {
		availableServicesManager = new ArrayList<>();
		createdTickets = new ArrayList<>();
	}

	/* --- getters & setters --- */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public void setDemoTicket(Ticket demoTicket) {
		this.demoTicket = demoTicket;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public String getName() {
		return demoTicket.getName();
	}

	public int getServicesManagersCount() {
		return availableServicesManager.size();
	}

	public ServicesManager getServicesManager() {
		if (!printServicesManagersIndex()) {
			return null;
		}

		int servicesManagerIndex = Main.enterIntValue("Select a services group:", 0, availableServicesManager.size());
		return availableServicesManager.get(servicesManagerIndex);
	}
	/* --- getters & setters --- */

	/* --- others --- */
	public void addServicesManager(ServicesManager servicesManager) {
		if (servicesManager != null) {
			this.availableServicesManager.add(servicesManager);
		}
	}

	public boolean printServicesManagersIndex() {
		if (availableServicesManager == null || availableServicesManager.isEmpty()) {
			System.out.println("Services managers list is empty");
			return false;
		}

		System.out.println();

		for (int i = 0; i < availableServicesManager.size(); i++) {
			System.out.println(" - " + i + "  " + availableServicesManager.get(i).getName());
		}

		return true;
	}

	public void deleteCreatedTicket(Ticket ticket) {
		if (createdTickets.remove(ticket)) {
			availableCount++;
		}
	}

	public Ticket getTicket() {
		if (availableCount == 0) {
			System.out.println("This type of ticket is unavailable");
			return null;
		}

		Ticket newTicket = demoTicket.cloneObject();

		while (true) {
			ServicesManager servicesManager;
			Service newService;
			int continuationFlag;

			continuationFlag = Main.enterIntValue("\nAdd service? (0 - no, 1 - ok): ", 0, 1);
			if (continuationFlag == 0) {
				break;
			}

			servicesManager = getServicesManager();
			if (servicesManager != null) {
				newService = servicesManager.getService();

				if (newService != null) {
					newTicket.addService(newService);
				}
			}
		}

		if (newTicket != null) {
			createdTickets.add(newTicket);
			availableCount--;
		}

		return newTicket;
	}
	/* --- others --- */


}
