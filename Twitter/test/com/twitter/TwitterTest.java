/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Ana
 *
 */
public class TwitterTest {
	private Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	
	public void testVratiSvePoruke() {
		t.unesi("Petar", "Twitter");
		t.unesi("Marko", "Poruka");
		t.unesi("Nikola", "Prva");
		
		LinkedList<TwitterPoruka> lista = t.vratiSvePoruke();
		
		assertEquals("Petar", lista.get(0).getKorisnik());
		assertEquals("Marko", lista.get(1).getKorisnik());
		assertEquals("Nikola", lista.get(2).getKorisnik());
		
		assertEquals("Twitter", lista.get(0).getPoruka());
		assertEquals("Poruka", lista.get(1).getPoruka());
		assertEquals("Prva", lista.get(2).getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	
	public void testUnesi() {
		LinkedList <TwitterPoruka> poruke = t.vratiSvePoruke();
		String ime = "Petar";
		String poruka = "Twitter";
		t.unesi(ime, poruka);
		assertEquals(poruka, poruke.getLast().getPoruka());
		assertEquals(ime, poruke.getLast().getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	
	public void testVratiPoruke() {
		t.unesi("Petar", "Twitter");
		t.unesi("Marko", "Poruka");
		t.unesi("Nikola", "Prva Poruka");
		int brojac = 0;
		
		TwitterPoruka [] niz = t.vratiPoruke(100, "Poruka");
		for (int i=0;i<niz.length;i++){
			if(niz[i] != null)
				brojac++;
		}
		assertEquals(2, brojac);
	}
	
	public void testVratiPoruke2(){
		TwitterPoruka[] niz = t.vratiPoruke(30, "Prva");
		assertEquals(30, niz.length);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(10, null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		t.vratiPoruke(10, "");
	}
}
