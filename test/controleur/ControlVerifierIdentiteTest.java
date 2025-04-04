package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	@Test
	void testVerifierIdentite() {
		Village village = new Village("aguiajgja", 15, 6);
		village.setChef(new Chef("Abra", 5, village));
		ControlVerifierIdentite ctrl = new ControlVerifierIdentite(village);	
		assertTrue(ctrl.verifierIdentite("Abra"));
		Gaulois bonemine = new Gaulois("Bonemine", 1);
		assertFalse(ctrl.verifierIdentite("Bonemine"));
		village.ajouterHabitant(bonemine);
		assertTrue(ctrl.verifierIdentite("Bonemine"));
	}

}
