package fr.jul.kata.bankocr;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class DecodeurOCRTest {

	@Test
	public void peutReconnaitre000000000() {
		DecodeurOCR decodeurOCR = new DecodeurOCR(fabriquerUneEntreeDeZero());

		String entréeDecodé = decodeurOCR.decoder();

		assertThat(entréeDecodé).isEqualTo("000000000");

	}

	private String fabriquerUneEntreeDeZero() {
		return " _  _  _  _  _  _  _  _  _ " + "| || || || || || || || || |" + "|_||_||_||_||_||_||_||_||_|"
				+ "                           ";
	}
}
