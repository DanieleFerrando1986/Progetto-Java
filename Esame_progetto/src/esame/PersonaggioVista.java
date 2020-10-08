package esame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PersonaggioVista
{
	private MemorizzaPersonaggi memoria;
	private Personaggio player;
	
	public PersonaggioVista(MemorizzaPersonaggi memoria, Personaggio player, JPanel panel, PunteggioVista pv, QualitaVista qv) 
	{
		this.memoria = memoria;
		this.player = player;
		
		TextField txtfile = new TextField();
		txtfile.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtfile.setBackground(Color.WHITE);
		txtfile.setForeground(Color.BLACK);
		Button buttonSalva = new Button("Salva");
		buttonSalva.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonSalva.setBackground(Color.BLUE);
		buttonSalva.setForeground(Color.PINK);
		Button buttonCarica = new Button("Carica");
		buttonCarica.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonCarica.setBackground(Color.RED);
		buttonCarica.setForeground(Color.GREEN);
		Label SALVAPLAYER = new Label("SALVA PLAYER");
		SALVAPLAYER.setFont(new Font("Tahoma", Font.BOLD, 16));
		SALVAPLAYER.setAlignment(Label.CENTER);
		SALVAPLAYER.setForeground(Color.BLACK);
		
		panel.add(SALVAPLAYER);
		panel.add(buttonSalva);
		panel.add(buttonCarica);
		panel.add(txtfile);
		
		buttonSalva.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				if(txtfile.getText().length() > 0) {			
					String nomefile = txtfile.getText()+".txt";
					memoria.scrivi(nomefile);
			    }
				else 
				{
					System.out.println("Scrivi un nome valido");
				}
	        }
		});
		
		buttonCarica.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				String nomefile = txtfile.getText()+".txt";
				if(memoria.leggi(nomefile)) 
				{				
					ArrayList<Punteggio> caratteristiche1 = player.getCaratteristiche();
					caratteristiche1.get(0).setLivello(Integer.parseInt(memoria.forza));
	                pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("forza")).getPunti().setText("" + caratteristiche1.get(0).getLivello());
	                pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("forza")).costo.setText("" + caratteristiche1.get(0).getCosto());
	                
	                ArrayList<Punteggio> caratteristiche2 = player.getCaratteristiche();
	                caratteristiche2.get(1).setLivello(Integer.parseInt(memoria.destrezza));
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("destrezza")).getPunti().setText("" + caratteristiche2.get(1).getLivello());
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("destrezza")).costo.setText("" + caratteristiche2.get(1).getCosto()); 

					ArrayList<Punteggio> caratteristiche3 = player.getCaratteristiche();
					caratteristiche3.get(2).setLivello(Integer.parseInt(memoria.costituzione));
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("costituzione")).getPunti().setText("" + caratteristiche3.get(2).getLivello());
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("costituzione")).costo.setText("" + caratteristiche3.get(2).getCosto()); 
	                
					ArrayList<Punteggio> caratteristiche4 = player.getCaratteristiche();
					caratteristiche4.get(3).setLivello(Integer.parseInt(memoria.intelligenza));
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("intelligenza")).getPunti().setText("" + caratteristiche4.get(3).getLivello());
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("intelligenza")).costo.setText("" + caratteristiche4.get(3).getCosto()); 
	                
					ArrayList<Punteggio> caratteristiche5 = player.getCaratteristiche();
					caratteristiche5.get(4).setLivello(Integer.parseInt(memoria.saggezza));
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("saggezza")).getPunti().setText("" + caratteristiche5.get(4).getLivello());
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("saggezza")).costo.setText("" + caratteristiche5.get(4).getCosto()); 
	                
					ArrayList<Punteggio> caratteristiche6 = player.getCaratteristiche();
					caratteristiche6.get(5).setLivello(Integer.parseInt(memoria.carisma));
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("carisma")).getPunti().setText("" + caratteristiche6.get(5).getLivello());
					pv.caratteristicheVistaItem.get(player.getIndiceCaratteristicheVistaItemPunteggioVista("carisma")).costo.setText("" + caratteristiche6.get(5).getCosto()); 
	                
					player.setEsperienza(Integer.parseInt(memoria.puntiesperienza));
	                pv.puntiEsperienzaTextField.setText("" + player.getEsperienza());	                   
	                    
	                
	                ArrayList<Qualita> qualita1 = player.getQualita();
	                qualita1.get(0).setLivello(Integer.parseInt(memoria.taglio));
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("usoArmiTaglio")).getPunti().setText("" + qualita1.get(0).getLivello());
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("usoArmiTaglio")).costo.setText("Forza = " + (qualita1.get(0).getLivello() * qualita1.get(0).car1Mod + 1) + "    Costituzione = " + (qualita1.get(0).getLivello() * qualita1.get(0).car2Mod + 1));	                
	               	           
	                ArrayList<Qualita> qualita2 = player.getQualita();
	                qualita2.get(1).setLivello(Integer.parseInt(memoria.distanza));	              
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("usoArmiDistanza")).getPunti().setText("" + qualita2.get(1).getLivello()); //usoArmiDistanza
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("usoArmiDistanza")).costo.setText("Destrezza = " + (qualita2.get(1).getLivello() * qualita2.get(1).car1Mod + 1) + "    Forza = " + (qualita2.get(1).getLivello() * qualita2.get(1).car2Mod + 1));
	                
	                ArrayList<Qualita> qualita3 = player.getQualita();
	                qualita3.get(2).setLivello(Integer.parseInt(memoria.armature));	               
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("armature")).getPunti().setText("" + qualita3.get(2).getLivello()); //armature
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("armature")).costo.setText("Costituzione = " + (qualita3.get(2).getLivello() * qualita3.get(2).car1Mod + 1) + "    Forza = " + (qualita3.get(2).getLivello() * qualita3.get(2).car2Mod + 1));
	                
	                ArrayList<Qualita> qualita4 = player.getQualita();
	                qualita4.get(3).setLivello(Integer.parseInt(memoria.magia));
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("magia")).getPunti().setText("" + qualita4.get(3).getLivello()); //magia
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("magia")).costo.setText("Intelligenza = " + (qualita4.get(3).getLivello() * qualita4.get(3).car1Mod + 1) + "    Carisma = " + (qualita4.get(3).getLivello() * qualita4.get(3).car2Mod + 1));
	                
	                ArrayList<Qualita> qualita5 = player.getQualita();
	                qualita5.get(4).setLivello(Integer.parseInt(memoria.capacitaMediche));
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("capacitaMediche")).getPunti().setText("" + qualita5.get(4).getLivello());
	                qv.qualitaVistaItem.get(player.getIndiceQualitaVistaItemQualitaVista("capacitaMediche")).costo.setText("Saggezza = " + (qualita5.get(4).getLivello() * qualita5.get(4).car1Mod + 1) + "    Intelligenza = " + (qualita5.get(4).getLivello() * qualita5.get(4).car2Mod + 1));  
				}                       
	        }
		});
	}	
}
