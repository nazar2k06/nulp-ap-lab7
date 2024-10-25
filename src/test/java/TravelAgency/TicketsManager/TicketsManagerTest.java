package TravelAgency.TicketsManager;

import TravelAgency.TicketsManager.TicketManager.TicketManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
	private TicketsManager ticketsManager;
	private TicketManager ticketManager;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		ticketsManager = new TicketsManager();
		ticketManager = new TicketManager();
	}

	@Test
	public void testGetTicketManagersCount() {
		assertEquals(0, ticketsManager.getTicketManagersCount());
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
}