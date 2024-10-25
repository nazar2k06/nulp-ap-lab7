package TravelAgency.TicketsManager.TicketManager.ServicesManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicesManagerTest {
	private ServicesManager servicesManager;

	@BeforeEach
	void setUp() {
		servicesManager = new ServicesManager();
	}

	@Test
	void setAndGetNameTest() {
		servicesManager.setName("Food");
		assertEquals("Food", servicesManager.getName());
	}

	@Test
	void setAndGetAvailableCountTest() {
		servicesManager.setAvailableCount(12);
		assertEquals(12, servicesManager.getAvailableCount());
	}

	@Test
	void addServiceTest() {
		servicesManager.addService(new Service("Cake", 10));
		assertEquals(1, servicesManager.getServicesCount());
	}

	@Test
	void getServicesCountTest() {
		servicesManager.addService(new Service("Cake", 10));
		servicesManager.addService(new Service("Fish", 14));

		assertEquals(2, servicesManager.getServicesCount());
	}

	@Test
	void getServiceTest() {
		assertNull(servicesManager.getService());
	}
}