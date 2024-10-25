package TravelAgency.TicketsManager.TicketManager;

import TravelAgency.TicketsManager.TicketManager.ServicesManager.ServicesManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
	TicketManager ticketManager;

	@BeforeEach
	void setUp() {
		ticketManager = new TicketManager();
	}

	@Test
	void setAndGetAvailableCountTest() {
		ticketManager.setAvailableCount(4);

		assertEquals(4, ticketManager.getAvailableCount());
	}

	@Test
	void setDemoTicketTest() {
		ticketManager.setDemoTicket(new Ticket("test", 3));

		assertEquals("test", ticketManager.getName());
	}

	@Test
	void getNameTest() {
		ticketManager.setDemoTicket(new Ticket("myTicket", 3));
		ticketManager.setDemoTicket(new Ticket("newTicket", 3));

		assertEquals("newTicket", ticketManager.getName());
	}

	@Test
	void addServicesManagerTest() {
		ticketManager.addServicesManager(new ServicesManager());

		assertEquals(1, ticketManager.getServicesManagersCount());
	}

	@Test
	void getServicesManagersCountTest() {
		ticketManager.addServicesManager(new ServicesManager());
		ticketManager.addServicesManager(new ServicesManager());

		assertEquals(2, ticketManager.getServicesManagersCount());
	}

	@Test
	void getTicketTest() {
		assertNull(ticketManager.getTicket());
	}

}