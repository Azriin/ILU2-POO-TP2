package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	
	
	@Test
	void testDonnerInfoMarche() {
		Village village = new Village("ahugiuzhguaf", 54, 54);
		village.setChef(new Chef("zhghzrj", 4, village));
		ControlAfficherMarche ctrl = new ControlAfficherMarche(village);
		
		assertArrayEquals(ctrl.donnerInfoMarche(), new String[0]);
		Gaulois bonemine = new Gaulois("Bonemine", 1);
		village.ajouterHabitant(bonemine);
		village.installerVendeur(bonemine, "Fleurs", 24);
		assertArrayEquals(ctrl.donnerInfoMarche(), new String[] {"Bonemine", "24", "Fleurs"});		
	}

}
