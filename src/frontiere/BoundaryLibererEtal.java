package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui !");
		} else {
			String[] donneeEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneeEtal[0].compareTo("true") == 0) {
				System.out.println("Vous avez vendu " + donneeEtal[4] + " sur " + donneeEtal[3] + " " + donneeEtal[2]);
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journee");
			}
		}
	}

}
