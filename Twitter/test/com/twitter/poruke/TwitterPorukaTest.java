/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ana
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */

	public void testSetKorisnik() {
		t.setKorisnik("Petar");
		assertEquals("Petar", t.getKorisnik());
		
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		t.setKorisnik("");
		
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */

	public void testSetPoruka() {
		t.setPoruka("Twitter poruka.");
		assertEquals("Twitter poruka.", t.getPoruka());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		t.setPoruka("");
		
	}
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugackaPoruka() {
		t.setPoruka("*************************************************************************************"
				+ "****************************************************************************************"
				+ "*************************************************************************************"
				+ "*****************************************");
		
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */

	public void testToString() {
		t.setKorisnik("Petar");
		t.setPoruka("Twitter poruka");
		
		assertEquals("KORISNIK:"+"Petar"+" PORUKA:"+"Twitter poruka", t.toString());
		
	}

}
