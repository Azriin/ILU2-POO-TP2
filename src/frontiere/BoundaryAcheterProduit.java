package frontiere;

import java.util.List;

import controleur.ControlAcheterProduit;
import controleur.ControlVerifierIdentite;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Quels produit voulez vous acherter ?\n");
			String produit = Clavier.entrerChaine(question.toString());
			Gaulois[] listVendeur = controlAcheterProduit.getVendeurs(produit);
			if (listVendeur.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				question.append("Chez quel marchand voulez vous acherter des " + produit + "?\n");
				for (int i = 1; i < listVendeur.length; i++) {
					question.append(i + " - " + listVendeur[i-1].getNom() + "\n");
				}
				int vendeur;
				do {
					vendeur = Clavier.entrerEntier(question.toString());
				} while (vendeur > 0 && vendeur <= listVendeur.length);
				vendeur --;
				question.append(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + listVendeur[vendeur]);
				listVendeur[vendeur].parler("Bonjour " + nomAcheteur);
				question.append("Combien de "+ produit +" voulez-vous acheter ?");
				int quantite = Clavier.entrerEntier(question.toString());
				
			}
		}
	}
}
