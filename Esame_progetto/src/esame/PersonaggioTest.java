package esame;

import static org.junit.Assert.*;
import org.junit.*;

public class PersonaggioTest {
	
	Personaggio personaggio; //classe test personaggio
	
	@Before
	public void crea() {
		personaggio = new Personaggio("Daniele");  //costrutto
	}
	
	@Test
	public void testPersonaggio() {		
		int k=0; //indice di caratteristica
		
		assertTrue(personaggio.getCaratteristiche().get(k).getLivello()==0); //controlla che il valore ad inizializzazione sia effettivamente 0 per i "PUNTI"	
		assertTrue(personaggio.getCaratteristiche().get(k).getCosto()==10); //controlla che il valore ad inizializzazione sia effettivamente 10 per il "COSTO PUNTI ESPERIENZA"
	
		personaggio.getCaratteristiche().get(k).incrementaLivello(personaggio);  //si lancia il metodo "incrementaLivello(personaggio)": ora il metodo aggiorna vale 1
		assertTrue(personaggio.getCaratteristiche().get(k).getCosto()==10); //si controlla che il metodo "incrementaLivello()" abbia fatto il suo dovere cioè ora vale 1
		
		personaggio.getCaratteristiche().get(k).setLivello(7); //si aggiorna il valore per avverare il primo if(this.livello > 5) {this.costo=40;}
		assertTrue(personaggio.getCaratteristiche().get(k).getCosto()==40); //TESTIAMO CHE IL VALORE DI RITORNO DEL METODO GETCOSTO() SIA == DA 40
			
		personaggio.getCaratteristiche().get(k).setLivello(11); //si aggiorna il valore per avverare il secondo if(this.livello > 10) {this.costo=80;}
		assertFalse(personaggio.getCaratteristiche().get(k).getCosto()!=80); //TESTIAMO CHE IL VALORE DI RITORNO DEL METODO GETCOSTO() SIA != DA 80
		//assertFalse(return 40,80); cioè 40 è diverso a 80
		
		personaggio.getCaratteristiche().get(k).setLivello(16); //si aggiorna il valore per avverare il terzo if(this.livello > 15) {this.costo=120;}
		assertEquals(personaggio.getCaratteristiche().get(k).getCosto(),120); //TESTIAMO CHE IL VALORE DI RITORNO DEL METODO GETCOSTO() SIA == 120
		//assertEquals(return 120,120); cioè 120 è uguale a 120
	}
	
	@Test
	public void testQualita() {
		int h=0; 
		
		assertTrue(personaggio.getQualita().get(h).getLivello()==0); //controlla che il valore ad inizializzazione sia effettivamente 0
		
		//si aggiorna il valore per avverare il primo if(livello==0 && personaggio.caratteristiche.get(caratteristica1).getLivello()>0 && personaggio.caratteristiche.get(caratteristica2).getLivello()>0)
		personaggio.getQualita().get(h).setLivello(7); //si inserisce 7 come valore intero casuale perchè deve essere maggiore di 0 	       		
		personaggio.incrementaQualita(h); //si lancia il metodo "incrementaQualita(h)": ora il metodo vale 1		
		assertTrue(personaggio.getQualita().get(h).getLivello()==7); //si controlla che il metodo "incrementaQualita(h)" abbia fatto il suo dovere cioè ora vale 1
	
	
		//si aggiorna il valore per avverare il secondo if(livello>=1 && personaggio.caratteristiche.get(caratteristica1).getLivello()>this.livello*this.car1Mod && personaggio.caratteristiche.get(caratteristica2).getLivello()>this.livello*this.car2Mod)
		personaggio.getQualita().get(h).setLivello(20); //si inserisce 20 come valore intero casuale perchè deve essere > di "this.livello*this.car1Mod" e > di "this.livello*this.car2Mod"
		personaggio.incrementaQualita(h); //si lancia il metodo "incrementaQualita(h)": ora il metodo vale 2		
		assertTrue(personaggio.getQualita().get(h).getLivello()==20); //si controlla che il metodo "incrementaQualita(h)" abbia fatto il suo dovere cioè ora vale 2
	}
}
