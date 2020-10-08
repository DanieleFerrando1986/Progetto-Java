package esame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class QualitaVista {

	public ArrayList<VistaItem> qualitaVistaItem = new ArrayList<VistaItem>();
	private Personaggio player;
	
	public QualitaVista(Personaggio player, JPanel panel) {
		this.player = player;
		
		Label QUALITA = new Label("QUALITA'");
		QUALITA.setFont(new Font("Tahoma", Font.BOLD, 16));
		QUALITA.setAlignment(Label.CENTER);
		QUALITA.setForeground(Color.BLUE);
		Label LIVELLO = new Label("LIVELLO");
		LIVELLO.setFont(new Font("Tahoma", Font.BOLD, 16));
		LIVELLO.setAlignment(Label.CENTER);
		LIVELLO.setForeground(Color.BLUE);	
		Label AGGIORNA = new Label("AGGIORNA");
		AGGIORNA.setFont(new Font("Tahoma", Font.BOLD, 16));
		AGGIORNA.setAlignment(Label.CENTER);
		AGGIORNA.setForeground(Color.BLUE);
		Label PROSSIMOLIVELLO = new Label("PROSSIMO LIVELLO");
		PROSSIMOLIVELLO.setFont(new Font("Tahoma", Font.BOLD, 16));
		PROSSIMOLIVELLO.setAlignment(Label.CENTER);
		PROSSIMOLIVELLO.setForeground(Color.BLUE);	
		
		panel.add(QUALITA);
		panel.add(LIVELLO);
		panel.add(AGGIORNA);
		panel.add(PROSSIMOLIVELLO);
			
		String [] arrayQualita = player.getQualitaVistaItemQualitaVista();
		for(int indice=0; indice < arrayQualita.length; indice++) {
			qualitaVistaItem.add(new VistaItem(panel, player, null, indice, true));
		}
		
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));	
	}
}
