package esame;

import java.util.*;

/**
 * Classe che rappresenta un personaggio del gioco
 * @author Daniele Ferrando
 * @version 1.0
 * @see Punteggio
 * @see Qualita
 * @see MemorizzaPersonaggi
 */
public class Personaggio extends Observable {
	
	private String nomePersonaggio;
	private ArrayList<Punteggio> caratteristiche;
	private ArrayList<Qualita> qualita;
	private int esperienza;

	/**
	 * Costruttore che genera un personaggio
	 * @param nome il nome del personaggio
	 */
	public Personaggio(String nome) {
		this.nomePersonaggio=nome;
		/*this.setCaratteristiche(new ArrayList<Punteggio>(Arrays.asList(
														new Punteggio("Forza", 0),//0 indice della caratteristica
														new Punteggio("Destrezza", 0),//1
														new Punteggio("Costituzione", 0),//2
														new Punteggio("Intelligenza", 0),//3
														new Punteggio("Saggezza", 0),//4
														new Punteggio("Carisma", 0))//5
				));*/
		ArrayList<Punteggio> punteggi = new ArrayList<Punteggio>();
		String [] caratteristiche = this.getCaratteristicheVistaItemPunteggioVista();
		for(int index=0; index < caratteristiche.length; index++) {
			punteggi.add(new Punteggio(caratteristiche[index], 0));
		}
		this.setCaratteristiche(punteggi);
		
		this.setQualita(new ArrayList<Qualita>(Arrays.asList(
														new Qualita("Uso armi da taglio", 0, 0, 2, 5, 2), //0=livello iniziale, 0=forza, 2=costitizione, 5 e 2 sono modificatori dinamici di livello 
														new Qualita("Uso armi da distanza", 0, 1, 0, 3, 5),//1
														new Qualita("Armature", 0, 2, 0, 3, 4),//2
														new Qualita("Magia", 0, 3, 5, 5, 3),//3
														new Qualita("Capacità mediche", 0, 4, 3, 5, 3))//4 
				));		
		this.setEsperienza(5000);
	}
	
	/**
	 * Incrementa i punteggi di una caratteristica
	 * @param caratteristica l'indice della caratteristica
	 */
	public void incrementaPunteggio(int caratteristica) {  
		this.getCaratteristiche().get(caratteristica).incrementaLivello(this);
	}
		
	/**
	 * Incrementa i punteggi di una qualit&agrave;
	 * @param qualita l'indice della qualit&agrave;
	 */
	public void incrementaQualita(int qualita) { 
		this.getQualita().get(qualita).incrementaLivello(this);
	}

	/**
	 * Ritornano le caratteristiche del personaggio come ArrayList Punteggio
	 * @return le caratteristiche del personaggio
	 */
	public ArrayList<Punteggio> getCaratteristiche() {
		return this.caratteristiche;
	}

	/**
	 * Setta le nuove caratteristiche del personaggio con un nuovo arraylist definito da ArrayList Punteggio <em>nuove caratteristiche</em>
	 * @param nuoveCaratteristiche le nuove caratteristiche del personaggio
	 */
	public void setCaratteristiche(ArrayList<Punteggio> nuoveCaratteristiche) {
		this.caratteristiche=nuoveCaratteristiche;
	}

	/**
	 * Ritornano le qualit&agrave; del personaggio come ArrayList Qualit&agrave;
	 * @return le qualit&agrave; del personaggio
	 */
	public ArrayList<Qualita> getQualita() {
		return this.qualita;
	}

	/**
	 * Setta la nuova qualit&agrave; del personaggio con un nuovo arraylist definito da ArrayList Qualit&agrave; <em>nuova qualit&agrave;</em>
	 * @param nuovaQualita la nuova qualit&agrave; del personaggio
	 */
	public void setQualita(ArrayList<Qualita> nuovaQualita) {
		this.qualita=nuovaQualita;
	}

	/**
	 * Ritorna l'esperienza del personaggio come int
	 * @return l'esperienza del personaggio
	 */
	public int getEsperienza() {
		return this.esperienza;
	}

	/**
	 * Setta la nuova esperienza del personaggio con un nuovo intero definito da int <em>nuova esperienza</em>
	 * @param nuovaEsperienza la nuova esperienza del personaggio
	 */
	public void setEsperienza(int nuovaEsperienza) {
		this.esperienza=nuovaEsperienza;
	}
	
	/**
	 * Ritorna l'array delle caratteristiche come String[] 
	 * @return Le caratteristiche del punteggio
	 */
	public String[] getCaratteristicheVistaItemPunteggioVista() {
		String [] caratt = {"forza", "destrezza", "costituzione", "intelligenza", "saggezza", "carisma"};
		return caratt;
	}
	
	/**
	 * Cicla con il ciclo for l'indice delle caratteristiche vista;
	 * @param nomeCaratteristica Il nome della caratteristica
	 * @return L'indice delle caratteristiche vista
	 */
	public int getIndiceCaratteristicheVistaItemPunteggioVista(String nomeCaratteristica) {
		String [] array = getCaratteristicheVistaItemPunteggioVista();
		for(int indice=0; indice <= array.length; indice++) {
			if(array[indice].equalsIgnoreCase(nomeCaratteristica)) {
				return indice;
			}
		}
		return -1; //non ha trovato la caratteristica
	}
	
	/**
	 * Ritorna l'array delle qualit&agrave; come String[] 
	 * @return Le qualit&agrave; del punteggio
	 */
	public String[] getQualitaVistaItemQualitaVista() {
		String [] qual = {"usoArmiTaglio", "usoArmiDistanza", "armature", "magia", "capacitaMediche"};
		return qual;
	}
	
	/**
	 * Cicla con il ciclo for l'indice della qualit&agrave; vista;
	 * @param nomeQualita Il nome della qualit&agrave; 
	 * @return L'indice della qualit&agrave; vista
	 */
	public int getIndiceQualitaVistaItemQualitaVista(String nomeQualita) {
		String [] array = getQualitaVistaItemQualitaVista();
		for(int indice=0; indice <= array.length; indice++) {
			if(array[indice].equalsIgnoreCase(nomeQualita)) {
				return indice;
			}
		}
		return -1; //non ha trovato la qualità
	}
}
