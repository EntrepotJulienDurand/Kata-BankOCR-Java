package fr.jul.kata.bankocr;

import java.util.HashMap;
import java.util.Map;

public class DecodeurOCR {
    
    private static final int DEBUT_LIGNE_3 = 54;
    private static final int DEBUT_LIGNE_2 = 27;
    private static final int TAILLE_DU_CHIFFRE = 3;
    private static final String MOTIF_CHIFFRE_ZERO = " _ " + "| |" + "|_|";
    private static final String MOTIF_CHIFFRE_UN = "   " + "  |" + "  |";
    private static final String MOTIF_CHIFFRE_DEUX = " _ " + " _|" + "|_ ";
    private static final String MOTIF_CHIFFRE_TROIS = " _ " + " _|" + " _|";
    private static final String MOTIF_CHIFFRE_QUATRE = "   " + "|_|" + "  |";
    private static final String MOTIF_CHIFFRE_CINQ = " _ " + "|_ " + " _|";
    private static final String MOTIF_CHIFFRE_SIX = " _ " + "|_ " + "|_|";
    private static final String MOTIF_CHIFFRE_SEPT = " _ " + "  |" + "  |";
    private static final String MOTIF_CHIFFRE_HUIT = " _ " + "|_|" + "|_|";
    private static final String MOTIF_CHIFFRE_NEUF = " _ " + "|_|" + " _|";
    private static Map<String, String> correspondanceMotifChiffre = new HashMap<String, String>();
    static {
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_ZERO, "0");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_UN, "1");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_DEUX, "2");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_TROIS, "3");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_QUATRE, "4");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_CINQ, "5");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_SIX, "6");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_SEPT, "7");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_HUIT, "8");
        correspondanceMotifChiffre.put(MOTIF_CHIFFRE_NEUF, "9");
    }
    
    public String decoder(String entree) {
        String chiffre = "";
        
        for (int i = 0; i < 9; i++) {
            String chiffreOCR = this.decouperLeIemeChiffre(entree, i);
            
            chiffre += this.determinerChiffreSelonMotif(chiffreOCR);
        }
        
        return chiffre;
    }
    
    public String determinerChiffreSelonMotif(String chiffre) {
        return correspondanceMotifChiffre.get(chiffre);
        
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
