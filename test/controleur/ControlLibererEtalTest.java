package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	Village village;
	ControlLibererEtal ctrl;
	
	@BeforeEach
	void init() {
		village = new Village("ahugiuzhguaf", 54, 2);
		village.setChef(new Chef("Abra", 4, village));
		ctrl = new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
	}
	@Test
	void testIsVendeur() {
		assertFalse(ctrl.isVendeur("Abra"));
		assertFalse(ctrl.isVendeur("idefix"));
		Gaulois idefix = new Gaulois("idefix", 1);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix, "os", 18);
		assertTrue(ctrl.isVendeur("idefix"));
	}

	@Test
	void testLibererEtal() {
		Gaulois idefix = new Gaulois("idefix", 1);
		village.ajouterHabitant(idefix);
		village.installerVendeur(idefix, "os", 18);
		assertArrayEquals(ctrl.libererEtal("idefix"), new String[] {"true", "idefix", "os", "18", "0"});
		assertNull(ctrl.libererEtal("intru"));
	}

}
