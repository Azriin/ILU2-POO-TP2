package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private ControlEmmenager ctrl;
	
	@BeforeEach
	void init() {
		this.village = new Village("zgj", 10, 2);
		this.village.setChef(new Chef("Abra", 8, village));
		this.ctrl = new ControlEmmenager(village);
	}
	
	@Test
	void testIsHabitant() {
		assertFalse(ctrl.isHabitant("Asterix"));
		ctrl.ajouterGaulois("Asterix", 15);
		assertTrue(ctrl.isHabitant("Asterix"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(ctrl.isHabitant("Panoramix"));
		ctrl.ajouterDruide("Panoramix", 2, 5, 15);
		assertTrue(ctrl.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(ctrl.isHabitant("Obelix"));
		ctrl.ajouterDruide("Obelix", 2, 5, 15);
		assertTrue(ctrl.isHabitant("Obelix"));
	}

}
