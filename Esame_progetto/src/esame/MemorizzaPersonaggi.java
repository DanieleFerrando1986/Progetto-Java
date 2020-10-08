package esame;

import java.io.*;
import java.util.*;

/**
 * Classe che memorizza i personaggi del gioco
 * @author Daniele Ferrando
 * @version 1.0
 */
public class MemorizzaPersonaggi {

		private Personaggio modelloPersonaggio;
		//private String localPath="C:/Users/Daniele/eclipse-workspace/Esame_progetto/src/esame/players/";
		private String absPath = new File(".").getAbsolutePath()+"//players_";
		
		public int vettLinea[]=new int[23];
		public String forza="";
		public String destrezza="";
		public String costituzione="";
		public String intelligenza="";
		public String saggezza="";
		public String carisma="";
		public String puntiesperienza="";
		public String taglio="";
		public String distanza="";
		public String armature="";
		public String magia="";
		public String capacitaMediche=""; 
		public String prossimoLivelloUsoArmiDaTaglio="";
		public String prossimoLivelloUsoArmiDaDistanza="";
		public String prossimoLivelloArmature="";
		public String prossimoLivelloMagia="";
		public String prossimoLivelloCapacitaMediche="";
		
		/**
		 * Ritorna l'array delle caratteristiche; come String[] 
		 * @return Le caratteristiche del punteggio
		 */
		public String[] getCaratteristicheMemorizzaPersonaggi() {
			String [] caratt = {"forza", "destrezza", "costituzione", "intelligenza", "saggezza", "carisma"};
			return caratt;
		}
		
		/**
		 * Cicla con il ciclo for l'indice delle caratteristiche memorizza personaggi
		 * @param nomeCaratteristica Il nome della caratteristica
		 * @return L'indice delle caratteristiche memorizza personaggi
		 */
		public int getIndiceCaratteristicheMemorizzaPersonaggi(String nomeCaratteristica) {
			String [] array = getCaratteristicheMemorizzaPersonaggi();
			for(int indice=0; indice <= array.length; indice++) {
				if(array[indice].equalsIgnoreCase(nomeCaratteristica)) {
					return indice;
				}
			}
			return -1; //non ha trovato la caratteristica di MemorizzaPersonaggi
		}
		
		/**
		 * Ritorna l'array delle qualit&agrave; come String[]
		 * @return Le qualit&agrave; del punteggio
		 */
		public String[] getQualitaMemorizzaPersonaggi() {
			String [] qual = {"usoArmiTaglio", "usoArmiDistanza", "armature", "magia", "capacitaMediche"};
			return qual;
		}
		
		/**
		 * Cicla con il ciclo for l'indice della qualit&agrave; memorizza personaggi
		 * @param nomeQualita Il nome della qualit&agrave;
		 * @return L'indice della qualit&agrave; memorizza personaggi
		 */
		public int getIndiceQualitaMemorizzaPersonaggi(String nomeQualita) {
			String [] array = getQualitaMemorizzaPersonaggi();
			for(int indice=0; indice <= array.length; indice++) {
				if(array[indice].equalsIgnoreCase(nomeQualita)) {
					return indice;
				}
			}
			return -1; //non ha trovato la qualità di MemorizzaPersonaggi
		}
		
		/**
		 * Costruttore che memorizza i personaggi
		 * @param player l'oggetto <em>Personaggio</em> da salvare
		 */
		public MemorizzaPersonaggi(Personaggio player) {
			this.modelloPersonaggio=player;
		}
			
		/**
		 * Scrive sul file di testo i punteggi
		 * @param nomefile il nome del file su cui salvare i punteggi
		 */
		public void scrivi(String nomefile) {
			try {
				PrintWriter in=new PrintWriter(new File(this.absPath+nomefile));
				/*in.printf(this.modelloPersonaggio.getCaratteristiche().get(0).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getCaratteristiche().get(1).getLivello() + "\n"); 
				in.printf(this.modelloPersonaggio.getCaratteristiche().get(2).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getCaratteristiche().get(3).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getCaratteristiche().get(4).getLivello() + "\n"); 
				in.printf(this.modelloPersonaggio.getCaratteristiche().get(5).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getEsperienza() + "\n");
				in.printf(this.modelloPersonaggio.getQualita().get(0).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getQualita().get(1).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getQualita().get(2).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getQualita().get(3).getLivello() + "\n");
				in.printf(this.modelloPersonaggio.getQualita().get(4).getLivello() + "\n");
				in.close();*/
				for(int i=0; i<=5; i++) {
					in.print(this.modelloPersonaggio.getCaratteristiche().get(i).getLivello()+ "\n");
				}
				in.print(this.modelloPersonaggio.getEsperienza()+ "\n");
				
				for(int i=0; i<=4; i++) {
					in.print(this.modelloPersonaggio.getQualita().get(i).getLivello()+ "\n");
				}
				in.close();
			}
			catch(FileNotFoundException e) {System.out.println("Non ho trovato il file");}
		}
		
		/**
		 * Legge sul file di testo i punteggi
		 * @param nomefile il nome del file da leggere
		 * @return l'esito della lettura
		 */
		public boolean leggi(String nomefile) {
			try {							
				FileReader f1=new FileReader(this.absPath+nomefile);
				BufferedReader fIN=new BufferedReader(f1);		
				forza=fIN.readLine();
				destrezza=fIN.readLine();
				costituzione=fIN.readLine();
				intelligenza=fIN.readLine();
				saggezza=fIN.readLine();
				carisma=fIN.readLine();
				puntiesperienza=fIN.readLine();		
				taglio=fIN.readLine();
				distanza=fIN.readLine();
				armature=fIN.readLine();
				magia=fIN.readLine();
				capacitaMediche=fIN.readLine();
				f1.close();	
				return true;
			}			
			catch(IOException e) {
				System.out.println("Errore nella lettura del file");
				return false;
			}		
		}
}
