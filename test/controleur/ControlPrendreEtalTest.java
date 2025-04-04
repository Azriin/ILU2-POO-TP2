package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	Village village;
	ControlPrendreEtal ctrl;
	
	@BeforeEach
	void init() {
		village = new Village("ahugiuzhguaf", 54, 2);
		village.setChef(new Chef("zhghzrj", 4, village));
		ctrl = new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
	}
	
	@Test
	void testResteEtals() {
		assertTrue(ctrl.resteEtals());
		Gaulois bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleurs", 24);
		assertTrue(ctrl.resteEtals());
		Gaulois panoramix = new Gaulois("Panoramix", 1);
		village.ajouterHabitant(panoramix);
		village.installerVendeur(panoramix, "Potions", 24);
		assertFalse(ctrl.resteEtals());		
	}

	@Test
	void testPrendreEtal() {
		Gaulois bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(bonemine);
		Gaulois panoramix = new Gaulois("Panoramix", 1);
		village.ajouterHabitant(panoramix);
		
		assertEquals(ctrl.prendreEtal("Bonemine", "fleurs", 10), 1);
		assertEquals(ctrl.prendreEtal("Panoramix", "fleurs", 10), 2);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(ctrl.verifierIdentite("un villagois"));
		village.ajouterHabitant(new Gaulois("un villagois", 42));
		ctrl.prendreEtal("un villagois", "des trucs", 6);
		assertTrue(ctrl.verifierIdentite("un villagois"));
	}

}
