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
	public int userMenu() {
		return 1;
	}

	public int managerMenu() {
		return 2;
	}
	/* --- menu --- */

}
