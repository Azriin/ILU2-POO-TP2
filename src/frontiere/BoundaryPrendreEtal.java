package frontiere;

import controleur.ControlPrendreEtal;
import frontiere.Clavier;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desolee " + nomVendeur + " mais il faut etre un habitant du village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un etal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desolee "+ nomVendeur + ", je n'ai plus d'etal qui ne sois pas deja occupe.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("c'est parfait il me reste un etal pour vous !\n");
		question.append("il me faudrait quelques renseignement :\n");
		question.append("Quels produits souhaitez vous vendre ?\n");
		String produit = Clavier.entrerChaine(question.toString());
		question.setLength(0);
		question.append("Combien souhaitez vous en vendre ?\n");
		int nb = Clavier.entrerEntier(question.toString());
		controlPrendreEtal.prendreEtal(nomVendeur, produit, nb);
		
		
		
	}
}
