package TravelAgency;

import Main.Main;
import TravelAgency.TicketsManager.*;
import TravelAgency.TouristsManager.*;

public class TravelAgency {
	TicketsManager ticketsManager;
	TouristsManager touristsManager;

	public TravelAgency() {
		ticketsManager = new TicketsManager();
		touristsManager = new TouristsManager();
	}


	/* --- menu --- */
	public void userMenu() {
		while (true) {
			int menuSelect = 0;

			System.out.println("\n --- Travel agency menu --- ");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Manager");
			System.out.println(" 2. Tourist");

			menuSelect = Main.enterIntValue("Select an item:", 0, 2);
			System.out.println(" --- Travel agency menu --- ");

			switch (menuSelect) {
				case 0:
					return;
				case 1:
					managerMenu();
					break;
				case 2:
					touristsManager.touristsMenu(ticketsManager);
					break;
			}
		}
	}

	public void managerMenu() {
		while (true) {
			int menuSelect = 0;

			System.out.println("\n --- Manager menu --- ");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Tickets manager menu");
			System.out.println(" 2. Tourists manager menu");

			menuSelect = Main.enterIntValue("Select an item:", 0, 2);
			System.out.println(" --- Manager menu --- ");

			switch (menuSelect) {
				case 0:
					return;
				case 1:
					ticketsManager.menu(touristsManager);
					break;
				case 2:
					touristsManager.menu(ticketsManager);
					break;
			}
		}
	}
	/* --- menu --- */

}
