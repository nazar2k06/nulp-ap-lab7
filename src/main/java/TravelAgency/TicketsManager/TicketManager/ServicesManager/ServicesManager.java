package TravelAgency.TicketsManager.TicketManager.ServicesManager;

import Main.Main;

import java.util.ArrayList;

public class ServicesManager {
	String name;
	int availableCount;
	ArrayList<Service> availableServices;
	ArrayList<Service> createdServices;

	public ServicesManager() {
		availableServices = new ArrayList<>();
		createdServices = new ArrayList<>();
	}

	@Override
	public String toString() {
		String string = "\n --- Services Group (" + getName() + ") --- \n";

		for (Service service : availableServices) {
			string += " - " + service + "\n";
		}

		string += " --- Services Group (" + getName() + ") --- \n";
		return string;
	}

	/* --- getters & setters --- */
	void setName(String name) {
		this.name = name;
	}

	void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getName() {
		return name;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public int getServicesCount() {
		return availableServices.size();
	}
	/* --- getters & setters --- */

	/* --- others --- */
	public void addService(Service service) {
		if (service != null) {
			this.availableServices.add(service);
		}
	}

	private boolean printServicesManagersIndex() {
		if (availableServices == null || availableServices.isEmpty()) {
			System.out.println("Services list is empty");
			return false;
		}

		System.out.println();

		for (int i = 0; i < availableServices.size(); i++) {
			System.out.println(" - " + i + "  " + availableServices.get(i).getName());
		}

		return true;
	}

	public Service getService() {
		if (availableCount == 0) {
			System.out.println("This type of services is unavailable");
			return null;
		}

		if (!printServicesManagersIndex()) {
			return null;
		}

		Service service;
		int serviceIndex = Main.enterIntValue("Select a service:", 0, availableServices.size());

		service = availableServices.get(serviceIndex);

		if (service != null) {
			service = service.cloneObject();
			createdServices.add(service);

			availableCount--;
		}

		return service;
	}
	/* --- others --- */

	/* --- static methods --- */
	public static ServicesManager newServicesManager() {
		ServicesManager servicesManager = new ServicesManager();
		String name;
		int availableCount;

		name = Main.enterStringValue("Services group name: ");
		availableCount = Main.enterIntValue("Available services count: ", 0, 5);

		servicesManager.setName(name);
		servicesManager.setAvailableCount(availableCount);

		while (true) {
			Service service;
			int continuationFlag;

			continuationFlag = Main.enterIntValue("\nAdd service? (0 - no, 1 - ok): ", 0, 1);
			if (continuationFlag == 0) {
				break;
			}

			System.out.printf("\n<Adding service No%d>\n", servicesManager.getServicesCount() + 1);
			service = Service.newService();
			System.out.printf("<Adding service No%d>\n", servicesManager.getServicesCount() + 1);

			if (service != null) {
				servicesManager.addService(service);
			}
		}

		return servicesManager;
	}
}
