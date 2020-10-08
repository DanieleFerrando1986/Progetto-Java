package esame;

/**
 * Classe che rappresenta il punteggio del gioco
 * @author Daniele Ferrando
 * @version 1.0
 */
public class Punteggio {

	public final String nome;
	private int livello=0;
	private int costo=10;
	
	/**
	 * Costruttore che genera il punteggio 
	 * @param nome il nome del punteggio
	 * @param livello il livello del punteggio
	 */
	public Punteggio(String nome, int livello) {
		this.nome=nome;
		this.livello=livello;
		aggiornaCosto();
	}
	
	/**
	 * Ritorna il livello del punteggio come int
	 * @return Il livello del punteggio
	 */
	public int getLivello() {
		return this.livello;
	}
	
	/**
	 * Setta il livello del punteggio con un nuovo valore definito da un int <em>livello</em>
	 * @param livello Il nuovo livello del punteggio
	 */
	public void setLivello(int livello) {
		this.livello=livello;
		aggiornaCosto(); //setta il costo
	}
	
	/**
	 * Ritorna il costo del punteggio come int
	 * @return Il costo del punteggio
	 */
	public int getCosto() {
		return this.costo;
	}
	
	/**
	 * Incrementa il livello delle caratteristiche ed aggiorna il costo
	 * @param personaggio l'oggetto di tipo <em>Personaggio</em> su cui lavorare
	 */
	public void incrementaLivello(Personaggio personaggio) {
		if((personaggio.getEsperienza()-costo) >= 0) { //verifico che abbia sufficienti punti esperienza
			personaggio.setEsperienza(personaggio.getEsperienza()-costo);
			livello++; //livello punti caratteristiche
		}
		else 
		{
			System.out.println("Non ho abbastanza punti esperienza");
		}		
		aggiornaCosto();
	}
	
	/**
	 * Aggiorna il costo del livello
	 */
	private void aggiornaCosto() {			
		if(this.livello <= 5) {
			this.costo=10;
		}
		else 
		{
			this.costo=((this.livello-1)/5)*40;
		}
	}
}
