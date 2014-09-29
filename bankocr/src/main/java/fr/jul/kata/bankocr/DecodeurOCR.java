package fr.jul.kata.bankocr;

public class DecodeurOCR {

	private static final int DEBUT_LIGNE_3 = 54;
	private static final int DEBUT_LIGNE_2 = 27;
	private static final int TAILLE_DU_CHIFFRE = 3;
	private static final String MOTIF_CHIFFRE_ZERO = " _ " + "| |" + "|_|";

	public String decoder(String entree) {
		String chiffre = "";

		for (int i = 0; i < 9; i++) {
			String chiffreOCR = decouperLeIemeChiffre(entree, i);

			chiffre += determinerChiffreSelonMotif(chiffreOCR);
		}

		return chiffre;
	}

	public String determinerChiffreSelonMotif(String chiffre) {
		String resultat;
		if (MOTIF_CHIFFRE_ZERO.equals(chiffre)) {
			resultat = "0";
		} else {
			resultat = "1";
		}
		return resultat;
	}

	public String decouperLeIemeChiffre(String entree, int i) {
		int indexDebutChiffre = i * TAILLE_DU_CHIFFRE;
		int indexFinChiffre = indexDebutChiffre + TAILLE_DU_CHIFFRE;
		String ligneCaractere1 = entree.substring(indexDebutChiffre, indexFinChiffre);
		String ligneCaractere2 = entree.substring(indexDebutChiffre + DEBUT_LIGNE_2, indexFinChiffre + DEBUT_LIGNE_2);
		String ligneCaractere3 = entree.substring(indexDebutChiffre + DEBUT_LIGNE_3, indexFinChiffre + DEBUT_LIGNE_3);

		String chiffre = ligneCaractere1 + ligneCaractere2 + ligneCaractere3;
		return chiffre;
	}

	public void afficherLeChiffre(String ligneCaractere1, String ligneCaractere2, String ligneCaractere3) {
		System.out.println(ligneCaractere1);
		System.out.println(ligneCaractere2);
		System.out.println(ligneCaractere3);
	}
}
