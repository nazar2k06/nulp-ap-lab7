package TravelAgency.TouristsManager;

import TravelAgency.TicketsManager.TicketManager.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TouristTest {
	Tourist tourist;

	@BeforeEach
	void setUp() {
		tourist = new Tourist();
	}

	@Test
	void setAndGetNameTest() {
		tourist.setName("Nazar");
		assertEquals("Nazar", tourist.getName());
	}

	@Test
	void appendTicketTest() {
		tourist.appendTicket(new Ticket());
		assertEquals(1, tourist.getTicketsCount());
	}

	@Test
	void removeTicketTest() {
		Ticket ticket = new Ticket();
		tourist.appendTicket(new Ticket());
		tourist.appendTicket(ticket);
		tourist.removeTicket(ticket);

		assertEquals(1, tourist.getTicketsCount());
	}

	@Test
	void getTicketsCountTest() {
		tourist.appendTicket(new Ticket());
		tourist.appendTicket(new Ticket());

		assertEquals(2, tourist.getTicketsCount());
	}

	@Test
	void getAllPriceTest() {
		tourist.appendTicket(new Ticket());
		tourist.appendTicket(new Ticket());

		assertEquals(0, tourist.getAllPrice());
	}

	@Test
	void getTicketTest() {
		assertNull(tourist.getTicket());
	}
}