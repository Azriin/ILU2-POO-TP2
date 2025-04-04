package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	ControlAcheterProduit ctrl;
	Village village;
	
	@BeforeEach
	void init() {
		village = new Village("3 maisons dans une forest", 50, 5);
		village.setChef(new Chef("Abra", 5, village));
		ctrl = new ControlAcheterProduit(new ControlVerifierIdentite(village), new ControlTrouverEtalVendeur(village), village);
	}
	
	
	@Test
	void testVerifierIdentite() {
		assertTrue(ctrl.verifierIdentite("Abra"));
		assertFalse(ctrl.verifierIdentite("personne"));
		
	}

	@Test
	void testGetVendeurs() {
		assertNull(ctrl.getVendeurs("os"));
		Gaulois idefix = new Gaulois("idefix", 1);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix, "os", 18);
		assertArrayEquals(ctrl.getVendeurs("os"), new Gaulois[] {idefix});	
	}

	@Test
	void testGetEtalVendeur() {
		assertNull(ctrl.getEtalVendeur("idefix"));
		Gaulois idefix = new Gaulois("idefix", 1);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix, "os", 18);
		assertEquals(ctrl.getEtalVendeur("idefix"), village.rechercherEtal(idefix));
	}

	@Test
	void testAcheterProduit() {
		Gaulois idefix = new Gaulois("idefix", 1);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix, "os", 18);
		assertEquals(ctrl.acheterProduit("idefix", 10), 10);
		assertEquals(ctrl.acheterProduit("idefix", 10), 8);
		assertEquals(ctrl.acheterProduit("idefix", 10), 0);
	}

}
