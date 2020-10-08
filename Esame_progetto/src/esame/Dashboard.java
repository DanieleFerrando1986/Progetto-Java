package esame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame {
	
	private Personaggio player;
	private MemorizzaPersonaggi memoria;
		
	public Dashboard(Personaggio player, MemorizzaPersonaggi memoria) {
		this.player=player;
		this.memoria=memoria;
		
		JFrame frame = new JFrame("Gestione Personaggi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1365,730);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(16,4));
		panel.setBackground(Color.LIGHT_GRAY);
		
		PunteggioVista punteggioVista = new PunteggioVista(this.player, panel);
		QualitaVista qualitaVista = new QualitaVista(this.player, panel);	
		PersonaggioVista personaggioVista = new PersonaggioVista(this.memoria, this.player, panel, punteggioVista, qualitaVista);
		
		frame.add(panel);	
		frame.setVisible(true);
	}
}


