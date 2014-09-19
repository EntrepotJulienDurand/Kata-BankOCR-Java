package fr.jul.kata.bankocr;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class DecodeurOCRTest {
    
    @Test
    public void peutReconnaitre000000000() {
        DecodeurOCR decodeurOCR = new DecodeurOCR();
        
        String entreeDecodee = decodeurOCR.decoder(this.fabriquerUneEntreeDeZero());
        
        assertThat(entreeDecodee).isEqualTo("000000000");
    }
    
    private String fabriquerUneEntreeDeZero() {
        return " _  _  _  _  _  _  _  _  _ " + "| || || || || || || || || |" + "|_||_||_||_||_||_||_||_||_|" + "                           ";
    }
    
    @Test
    public void peutReconnaitre111111111() {
        DecodeurOCR decodeurOCR = new DecodeurOCR();
        
        String entreedecodee = decodeurOCR.decoder(this.fabriquerUneEntreeDeUn());
        
        assertThat(entreedecodee).isEqualTo("111111111");
    }
    
    private String fabriquerUneEntreeDeUn() {
        return "                           " + "  |  |  |  |  |  |  |  |  |" + "  |  |  |  |  |  |  |  |  |" + "                           ";
    }
}
