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

	@Test
	public void peutReconnaitre222222222() {
		DecodeurOCR decodeurOCR = new DecodeurOCR();

		String entreeDecodee = decodeurOCR.decoder(this.fabriquerUneEntreeDeDeux());

		assertThat(entreeDecodee).isEqualTo("222222222");
	}

	private String fabriquerUneEntreeDeDeux() {
		return " _  _  _  _  _  _  _  _  _ " + " _| _| _| _| _| _| _| _| _|" + "|_ |_ |_ |_ |_ |_ |_ |_ |_ " + "                           ";
	}

	@Test
	public void peutReconnaitre123456789() {
		DecodeurOCR decodeurOCR = new DecodeurOCR();

		String entreeDecodee = decodeurOCR.decoder(this.fabriquerUneEntree123456789());

		assertThat(entreeDecodee).isEqualTo("123456789");
	}

	private String fabriquerUneEntree123456789() {
		return "    _  _     _  _  _  _  _ " + "  | _| _||_||_ |_   ||_||_|" + "  ||_  _|  | _||_|  ||_| _|";
	}

	@Test
	public void leNumeroDeCompte345882865EstValide() {
		DecodeurOCR decodeur = new DecodeurOCR();
		String entreedecodee = decodeur.decoder(fabriquerUnCompteValide());

		boolean estUnCompteValide = decodeur.estUnCompteValide(entreedecodee);

		assertThat(estUnCompteValide).isTrue();
	}

	private String fabriquerUnCompteValide() {
		return " _     _  _  _  _  _  _  _ " + " _||_||_ |_||_| _||_||_ |_ " + " _|  | _||_||_||_ |_||_| _|";

	}

	@Test
	public void leNumeroDeCompte222222222NEstPasValide() {
		DecodeurOCR decodeur = new DecodeurOCR();
		String entreedecodee = decodeur.decoder(fabriquerUneEntreeDeDeux());

		boolean estUnCompteValide = decodeur.estUnCompteValide(entreedecodee);

		assertThat(estUnCompteValide).isFalse();
	}
}
