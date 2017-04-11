package com.twitter.poruke;
/**
 * Klasa koja dokumentuje poruke korisnika
 * 
 * @author Ana Golubovic
 * @version 1.0
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika
	 */
	private String korisnik;
	/**
	 * Poruka korisnika
	 */
	private String poruka;
	/**
	 * Vraca vrednost atributa ime korisnika
	 * @return ime korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Dodeljuje vrednost atributu korisnik
	 * @param korisnik
	 * @throws java.lang.RuntimeException ako je uneto ime:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.isEmpty())
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Vraca vrednost atributa poruka korisnika
	 * @return poruka korisnika kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Dodeljuje vrednost atributu poruka
	 * @param poruka
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>duzina poruke veca od 140</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka == new String("") ||
				poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Vraca podatke o korisniku i njegovoj poruci
	 * @return naziv korisnika i tekst poruke tipa String
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
