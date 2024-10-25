package TravelAgency.TicketsManager.TicketManager;

import TravelAgency.TicketsManager.TicketManager.ServicesManager.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
	private Ticket ticket;

	@BeforeEach
	void setUp() {
		ticket = new Ticket();
	}

	@Test
	void cloneObject() {
		Ticket clonedTicket = ticket.cloneObject();
		assertEquals(ticket.getName(), clonedTicket.getName());
	}

	@Test
	void setAndGetNameTest() {
		ticket.setName("Cruise");
		assertEquals("Cruise", ticket.getName());
	}

	@Test
	void setAndGetPriceTest() {
		ticket.setPrice(12);
		assertEquals(12, ticket.getPrice());
	}

	@Test
	void getAllPriceTest() {
		ticket.setPrice(10);
		ticket.addService(new Service("service1", 5));
		ticket.addService(new Service("service2", 1));

		assertEquals(16, ticket.getAllPrice());
	}

	@Test
	void addServiceTest() {
		ticket.addService(new Service("test", 5));
		assertEquals(1, ticket.getServicesCount());
	}
}