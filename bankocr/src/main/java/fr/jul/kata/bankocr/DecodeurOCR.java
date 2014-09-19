package fr.jul.kata.bankocr;

public class DecodeurOCR {
    
    private static final String MOTIF_CHIFFRE_ZERO = " _ " + "| |" + "|_|";
    
    public String decoder(String entree) {
        String resultat = "";
        
        for (int i = 0; i < (entree.length()); i++) {
            int index = i;
            String ligneCaractere1;
            if (i == 0) {
                index = 1;
                ligneCaractere1 = entree.substring(i, i + 3);
            } else {
                ligneCaractere1 = entree.substring(i * 3, (i * 3) + 3);
            }
            String ligneCaractere2 = entree.substring(index * 9 * 3, (index * 9 * 3) + 3);
            String ligneCaractere3 = entree.substring(index * 18 * 3, (index * 18 * 3) + 3);
            
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
