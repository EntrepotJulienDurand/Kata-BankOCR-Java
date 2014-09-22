package fr.jul.kata.bankocr;

public class DecodeurOCR {
    
    private static final int DEBUT_LIGNE_3 = 54;
    private static final int DEBUT_LIGNE_2 = 27;
    private static final int TAILLE_DU_CHIFFRE = 3;
    private static final String MOTIF_CHIFFRE_ZERO = " _ " + "| |" + "|_|";
    
    public String decoder(String entree) {
        String resultat = "";
        // String ligneCaractere1 = entree.substring(0, 3);
        // String ligneCaractere2 = entree.substring(27, 30);
        // String ligneCaractere3 = entree.substring(54, 57);
        //
        // String chiffre = ligneCaractere1 + ligneCaractere2 + ligneCaractere3;
        //
        // System.out.println(ligneCaractere1);
        // System.out.println(ligneCaractere2);
        // System.out.println(ligneCaractere3);
        //
        // ligneCaractere1 = entree.substring(3, 6);
        // ligneCaractere2 = entree.substring(30, 33);
        // ligneCaractere3 = entree.substring(60, 63);
        //
        // System.out.println(ligneCaractere1);
        // System.out.println(ligneCaractere2);
        // System.out.println(ligneCaractere3);
        //
        // ligneCaractere1 = entree.substring(6, 9);
        // ligneCaractere2 = entree.substring(33, 36);
        // ligneCaractere3 = entree.substring(63, 66);
        //
        // System.out.println(ligneCaractere1);
        // System.out.println(ligneCaractere2);
        // System.out.println(ligneCaractere3);
        
        for (int i = 0; i < 9; i++) {
            int indexDebutChiffre = i * TAILLE_DU_CHIFFRE;
            int indexFinChiffre = indexDebutChiffre + TAILLE_DU_CHIFFRE;
            String ligneCaractere1 = entree.substring(indexDebutChiffre, indexFinChiffre);
            String ligneCaractere2 = entree.substring(indexDebutChiffre + DEBUT_LIGNE_2, indexFinChiffre + DEBUT_LIGNE_2);
            String ligneCaractere3 = entree.substring(indexDebutChiffre + DEBUT_LIGNE_3, indexFinChiffre + DEBUT_LIGNE_3);
            
            String chiffre = ligneCaractere1 + ligneCaractere2 + ligneCaractere3;
            
            if (MOTIF_CHIFFRE_ZERO.equals(chiffre)) {
                resultat += "0";
            } else {
                resultat += "1";
            }
            System.out.println(ligneCaractere1);
            System.out.println(ligneCaractere2);
            System.out.println(ligneCaractere3);
        }
        
        return resultat;
    }
}
