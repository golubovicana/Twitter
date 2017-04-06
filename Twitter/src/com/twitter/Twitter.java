package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa vrsi unos twitova u listu Poruke i upisuje odgovarajuce poruke iz liste u niz
 * @author Ana Golubovic
 * @version 2.0
 */
public class Twitter {
	/**
	 * Lista objekata tipa TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Vraca celu listu objekata tipa TwitterPoruka
	 * @return objekte iz liste koji su tipa TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Unosi novi objekat tipa TwitterPoruka na kraj liste
	 * @param korisnik korisnik koji pise poruku
	 * @param poruka tekst poruke
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Pretrazuje listu i poruke koje sadrze odredjeni tag upisuje u niz
	 * @param maxBroj maksimalan broj poruka u nizu
	 * @param tag pod kojim se poruke pretrazuju
	 * @return niz tipa TwitterPoruka koji je duzine maxBroj i koji sadrzi poruke sa pretrazivanim tagom
	 * @throws java.lang.RuntimeException ako je uneti tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
