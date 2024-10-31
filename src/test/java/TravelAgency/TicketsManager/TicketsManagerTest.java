package TravelAgency.TicketsManager;

import TravelAgency.TicketsManager.TicketManager.TicketManager;
import TravelAgency.TouristsManager.TouristsManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
	private TicketsManager ticketsManager;
	private TicketManager ticketManager;

	@BeforeEach
	void setUp() {
		ticketsManager = new TicketsManager();
		ticketManager = new TicketManager();
	}

	@Test
	public void menuTest() {
		assertEquals(1, ticketsManager.menu(new TouristsManager()) );
	}

	@Test
	void getTicketManagerTest() {
		assertEquals(null, ticketsManager.getTicketManager());
	}

	@Test
	void printAvailableTicketsUITest() {
		assertEquals(0, ticketsManager.printAvailableTicketsUI());
	}

	@Test
	void addTicketUITest() {
		ticketsManager.addTicketUI();

		assertEquals(1, ticketsManager.getTicketManagersCount());
	}

	@Test
	public void testGetTicketManagersCount() {
		assertEquals(0, ticketsManager.getTicketManagersCount());
	}

	@Test
	public void testPrintTicketManagersIndex() {
		assertEquals(false, ticketsManager.printTicketManagersIndex());
	}

	@Test
	public void testAppendTicketManager() {
		ticketsManager.appendTicketManager(ticketManager);
		assertEquals(1, ticketsManager.getTicketManagersCount());
	}

	@Test
	public void testRemoveTicketManager() {
		ticketsManager.removeTicketManager(ticketManager);
		assertEquals(0, ticketsManager.getTicketManagersCount());
	}

	@Test
	public void getTicketTest() {
		assertEquals(null, ticketsManager.getTicket());
	}
}