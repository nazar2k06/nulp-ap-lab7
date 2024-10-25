package TravelAgency.TicketsManager.TicketManager.ServicesManager;

import TravelAgency.TicketsManager.TicketManager.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
	Service service;

	@BeforeEach
	void setUp() {
		service = new Service();
	}

	@Test
	void cloneObjectTest() {
		Service clonedService = service.cloneObject();
		assertEquals(service.getName(), clonedService.getName());
	}

	@Test
	void setAndGetNameTest() {
		service.setName("Car");
		assertEquals("Car", service.getName());
	}

	@Test
	void setAndGetNamePrice() {
		service.setPrice(12);
		assertEquals(12, service.getPrice());
	}
}