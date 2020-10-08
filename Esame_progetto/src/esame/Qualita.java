package esame;

/**
 * Classe che rappresenta la qualit&agrave; del gioco
 * @author Daniele Ferrando
 * @version 1.0
 * @see Punteggio
 */
public class Qualita extends Punteggio {
	
	private int livello=0;
	public int caratteristica1, caratteristica2;
	public int car1Mod, car2Mod; //modificatori di incremento dinamici
	
	/**
	 * Costruttore che genera una qualit&agrave;
	 * @param nome il nome del punteggio;
	 * @param livello il livello del punteggio
	 * @param caratteristica1 la caratteristica uno necessaria all'incremento della qualit&agrave;
	 * @param caratteristica2 la caratteristica due necessaria all'incremento della qualit&agrave;
	 * @param car1Mod modificatore dinamico uno della qualit&agrave;
	 * @param car2Mod modificatore dinamico due della qualit&agrave;
	 */
	public Qualita(String nome, int livello, int caratteristica1, int caratteristica2, int car1Mod, int car2Mod) {
		super(nome, livello);
		this.caratteristica1=caratteristica1;
		this.caratteristica2=caratteristica2;
		this.car1Mod=car1Mod;		
		this.car2Mod=car2Mod;	
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
	}
		
	/**
	 * Incrementa il livello della qualit&agrave;
	 * @param personaggio l'oggetto di tipo <em>Personaggio</em> su cui lavorare
	 */
	public void incrementaLivello(Personaggio personaggio) {  
		//getLivello()>0 (la somma di +1 della forza e della costituzione appartiene a "getLivello()>0")
		if(livello==0 
		   && personaggio.getCaratteristiche().get(caratteristica1).getLivello()>0 && personaggio.getCaratteristiche().get(caratteristica2).getLivello()>0)
		   livello=1;
		if(livello>=1 
		   && personaggio.getCaratteristiche().get(caratteristica1).getLivello()>this.livello*this.car1Mod && personaggio.getCaratteristiche().get(caratteristica2).getLivello()>this.livello*this.car2Mod)
		   livello++;
		
		else  
		{
			System.out.println("Non ho abbastanza punti caratteristiche");
		}
	}
}
