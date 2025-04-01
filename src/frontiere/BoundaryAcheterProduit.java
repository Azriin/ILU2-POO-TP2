package frontiere;


import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis desolee " + nomAcheteur + " mais il faut etre un habitant de notre village pour commercer ici.");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Quels produit voulez vous acherter ?\n");
			String produit = Clavier.entrerChaine(question.toString());
			question.delete(0, question.length());
			Gaulois[] listVendeur = controlAcheterProduit.getVendeurs(produit);
			if (listVendeur == null) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			} else {
				question.append("Chez quel marchand voulez vous acherter des " + produit + "?\n");
				for (int i = 0; i < listVendeur.length; i++) {
					question.append((i+1) + " - " + listVendeur[i].getNom() + "\n");
				}
				int idVendeur = -1;
				do {
					idVendeur = Clavier.entrerEntier(question.toString())-1;
				} while (idVendeur < 0 && idVendeur >= listVendeur.length);
				question.append(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + listVendeur[idVendeur].getNom() + "\n");
				question.append("Bonjour " + nomAcheteur + "\n");
				question.append("Combien de "+ produit +" voulez-vous acheter ?\n");
				int quantite = Clavier.entrerEntier(question.toString());
				question.delete(0, question.length());
				int nbAchete = controlAcheterProduit.acheterProduit(listVendeur[idVendeur].getNom(), quantite);
				if (nbAchete == quantite) {
					System.out.println(nomAcheteur + " achète " + quantite + " " + produit 
							+" à " + listVendeur[idVendeur].getNom());
				} else if (nbAchete == 0) {
					System.out.println(nomAcheteur +" veut acheter " + quantite + " " + produit 
							+", malheureusement il n’y en a plus !");
				} else {
					System.out.println(nomAcheteur +" veut acheter " + quantite + " " + produit 
							+", malheureusement " + listVendeur[idVendeur].getNom() + " n’en a "
							+ "plus que "+ nbAchete +". " + nomAcheteur +" achète "
							+ "tout le stock de " + listVendeur[idVendeur].getNom() +".");
				}
			}
		}
	}
}
