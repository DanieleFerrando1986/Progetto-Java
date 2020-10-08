package esame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class PunteggioVista {

	private Personaggio player;
	public TextField puntiEsperienzaTextField;
	public ArrayList<VistaItem> caratteristicheVistaItem = new ArrayList<VistaItem>();
	
	public PunteggioVista(Personaggio player, JPanel panel) {
		this.player = player;
		this.puntiEsperienzaTextField = new TextField(player.getEsperienza());
		
		Label CARATTERISTICHE = new Label("CARATTERISTICHE");
		CARATTERISTICHE.setFont(new Font("Tahoma", Font.BOLD, 16));
		CARATTERISTICHE.setAlignment(Label.CENTER);
		CARATTERISTICHE.setForeground(Color.RED);
		Label PUNTI = new Label("PUNTI");
		PUNTI.setFont(new Font("Tahoma", Font.BOLD, 16));
		PUNTI.setAlignment(Label.CENTER);
		PUNTI.setForeground(Color.RED);
		Label AGGIORNA = new Label("AGGIORNA");
		AGGIORNA.setFont(new Font("Tahoma", Font.BOLD, 16));
		AGGIORNA.setAlignment(Label.CENTER);
		AGGIORNA.setForeground(Color.RED);
		Label COSTOPUNTIESPERIENZA = new Label("COSTO PUNTI ESPERIENZA");
		COSTOPUNTIESPERIENZA.setFont(new Font("Tahoma", Font.BOLD, 16));
		COSTOPUNTIESPERIENZA.setAlignment(Label.CENTER);
		COSTOPUNTIESPERIENZA.setForeground(Color.RED);

		Label puntiEsperienza = new Label("Punti Esperienza");
		puntiEsperienza.setFont(new Font("Tahoma", Font.BOLD, 16));
		puntiEsperienza.setAlignment(Label.CENTER);

		puntiEsperienzaTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		puntiEsperienzaTextField.setBackground(Color.WHITE);
		puntiEsperienzaTextField.setForeground(Color.BLACK);
		puntiEsperienzaTextField.setText(Integer.toString(player.getEsperienza()));
		
		panel.add(CARATTERISTICHE);
		panel.add(PUNTI);	
		panel.add(AGGIORNA);
		panel.add(COSTOPUNTIESPERIENZA);

		String [] arrayCaratteristiche = player.getCaratteristicheVistaItemPunteggioVista();
		for(int indice=0; indice < arrayCaratteristiche.length; indice++) {
			caratteristicheVistaItem.add(new VistaItem(panel, player, puntiEsperienzaTextField, indice, false));
		}
		
		panel.add(puntiEsperienza);
		panel.add(puntiEsperienzaTextField);
		panel.add(new JLabel(""));
		panel.add(new JLabel(""));		
	}
}
