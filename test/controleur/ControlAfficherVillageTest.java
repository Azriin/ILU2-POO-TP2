package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private ControlAfficherVillage ctrl;
	
	@BeforeEach
	void init() {
		village = new Village("ahugiuzhguaf", 54, 54);
		village.setChef(new Chef("zhghzrj", 4, village));
		ctrl = new ControlAfficherVillage(village);
	}
	
	@Test
	void testDonnerNomsVillageois() {
		assertArrayEquals(ctrl.donnerNomsVillageois(), new String[] {"zhghzrj"});
		Gaulois bonemine = new Gaulois("Bonemine", 1);
		village.ajouterHabitant(bonemine);
		assertArrayEquals(ctrl.donnerNomsVillageois(), new String[] {"zhghzrj", "Bonemine"});
		village.ajouterHabitant(new Druide("Panoramix", 3, 5, 15));
		assertArrayEquals(ctrl.donnerNomsVillageois(), new String[] {"zhghzrj", "Bonemine", "le druide Panoramix"});
		
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(ctrl.donnerNomVillage(), "ahugiuzhguaf");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(ctrl.donnerNbEtals(), 54);
	}

}
