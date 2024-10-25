package TravelAgency.TouristsManager;

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
	void getTouristPriceTest() {
		assertNull(touristsManager.getTourist());
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