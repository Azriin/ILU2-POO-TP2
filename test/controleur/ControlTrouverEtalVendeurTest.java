package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	@Test
	void testTrouverEtalVendeur() {
		Village village = new Village("zghazhg", 15, 3);
		village.setChef(new Chef("Abra", 8, village));
		ControlTrouverEtalVendeur ctrl = new ControlTrouverEtalVendeur(village);
		Gaulois bonemine = new Gaulois("Bonemine", 1);
		assertNull(ctrl.trouverEtalVendeur("Bonemine"));
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleurs", 24);
		assertNotNull(ctrl.trouverEtalVendeur("Bonemine"));
	}

}
