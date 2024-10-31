package TravelAgency.TouristsManager;

import TravelAgency.TicketsManager.TicketsManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TouristsManagerTest {
	TouristsManager touristsManager;

	@BeforeEach
	void setUp() {
		touristsManager = new TouristsManager();
	}

	@Test
	void menuTest() {
		assertEquals(1, touristsManager.menu(new TicketsManager()) );
	}

	@Test
	void printTourists() {
		assertEquals(0, touristsManager.printTourists());
	}

	@Test
	void addTouristTest() {
		touristsManager.addTourist();
		assertEquals(1, touristsManager.getTouristCount());
	}

	@Test
	void getTouristPriceTest() {
		assertNull(touristsManager.getTourist());
	}

	@Test
	void printTouristsIndexTest() {
		assertEquals(false, touristsManager.printTouristsIndex());
	}

	@Test
	void appendTouristTest() {
		touristsManager.appendTourist(new Tourist());
		assertEquals(1, touristsManager.getTouristCount());
	}

	@Test
	void removeTouristTest() {
		Tourist tourist = new Tourist();
		touristsManager.appendTourist(new Tourist());
		touristsManager.appendTourist(tourist);
		touristsManager.removeTourist(tourist);

		assertEquals(1, touristsManager.getTouristCount());
	}

	@Test
	void getTouristCountTest() {
		touristsManager.appendTourist(new Tourist());
		touristsManager.appendTourist(new Tourist());

		assertEquals(2, touristsManager.getTouristCount());
	}
}