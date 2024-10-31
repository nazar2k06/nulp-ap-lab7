package TravelAgency;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelAgencyTest {
	private TravelAgency travelAgency;

	@BeforeEach
	void setUp() {
		travelAgency = new TravelAgency();
	}

	@Test
	void userMenu() {
		assertEquals(1, travelAgency.userMenu());
	}

	@Test
	void managerMenu() {
		assertEquals(2, travelAgency.managerMenu());
	}
}