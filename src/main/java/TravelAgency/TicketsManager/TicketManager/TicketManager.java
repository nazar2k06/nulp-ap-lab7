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

	public void close(TouristsManager touristsManager) {
		for (Ticket ticket : createdTickets) {
			touristsManager.deleteCreatedTicket(ticket);
		}
	}

	@Override
	public String toString() {
		String string = "\n --- Ticket (" + demoTicket.getName() + ") --- \n";
		string += String.format("%dx  ", availableCount);
		string += demoTicket + "\n";

		if (!availableServicesManager.isEmpty()) {
			for (ServicesManager servicesManager : availableServicesManager) {
				string += servicesManager;
			}
		}

		string += " --- Ticket (" + demoTicket.getName() + ") --- ";
		return string;
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

	private ServicesManager getServicesManager() {
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

	private boolean printServicesManagersIndex() {
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

	/* --- static methods --- */
	public static TicketManager newTicketManager() {
		TicketManager ticketManager = new TicketManager();
		Ticket demoTicket;
		int availableCount;

		demoTicket = Ticket.newTicket();
		availableCount = Main.enterIntValue("Available count of this ticket: ", 0, 5);

		ticketManager.setDemoTicket(demoTicket);
		ticketManager.setAvailableCount(availableCount);

		while (true) {
			ServicesManager servicesManager;
			int continuationFlag;

			continuationFlag = Main.enterIntValue("\nAdd services group? (0 - no, 1 - ok): ", 0, 1);
			if (continuationFlag == 0) {
				break;
			}

			System.out.printf("\n<Adding services group No%d>\n", ticketManager.getServicesManagersCount() + 1);
			servicesManager = ServicesManager.newServicesManager();
			System.out.printf("<Adding services group No%d>\n", ticketManager.getServicesManagersCount() + 1);

			if (servicesManager != null) {
				ticketManager.addServicesManager(servicesManager);
			}
		}

		return ticketManager;
	}
}
