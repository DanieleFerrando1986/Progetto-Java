package esame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class VistaItem {
	
	public TextField punti = new TextField(); 
	public TextField costo = new TextField();

	public VistaItem(JPanel panel, Personaggio player, TextField puntiEsperienza, int scoreIndex, boolean isQualita) {
		
		this.punti.setText(Integer.toString(player.getCaratteristiche().get(scoreIndex).getLivello()));
		
		Label nome = isQualita == true ? new Label(player.getQualita().get(scoreIndex).nome) : new Label(player.getCaratteristiche().get(scoreIndex).nome);
		nome.setFont(new Font("Tahoma", Font.BOLD, 16));
		nome.setAlignment(Label.CENTER);
		
		Button button = new Button("Incrementa");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBackground(Color.YELLOW);
		button.setForeground(Color.MAGENTA);
		
		getPunti().setFont(new Font("Tahoma", Font.BOLD, 16));
		getPunti().setBackground(Color.WHITE);
		getPunti().setForeground(Color.BLACK);
		
		costo.setFont(new Font("Tahoma", Font.BOLD, 16));
		costo.setBackground(Color.WHITE);
		costo.setForeground(Color.BLACK);
		if(isQualita)  
		{
			costo.setText(player.getCaratteristiche().get(player.getQualita().get(scoreIndex).caratteristica1).nome + " = " 
					+ (player.getQualita().get(scoreIndex).getLivello() * player.getQualita().get(scoreIndex).car1Mod + 1) + "   "  
					+ player.getCaratteristiche().get(player.getQualita().get(scoreIndex).caratteristica2).nome + 
					"  = " + (player.getQualita().get(scoreIndex).getLivello() * player.getQualita().get(scoreIndex).car2Mod + 1));
		}
		else 
		{
			costo.setText(Integer.toString(player.getCaratteristiche().get(scoreIndex).getCosto()));
		}
		
		panel.add(nome);
		panel.add(getPunti());
		panel.add(button);
		panel.add(costo);
		
		button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(isQualita) 
            	{
            		player.getQualita().get(scoreIndex).incrementaLivello(player);
    				getPunti().setText("" + player.getQualita().get(scoreIndex).getLivello());    
    				costo.setText(player.getCaratteristiche().get(player.getQualita().get(scoreIndex).caratteristica1).nome + " = " 
    						+ (player.getQualita().get(scoreIndex).getLivello() * player.getQualita().get(scoreIndex).car1Mod + 1) + "   "  
    						+ player.getCaratteristiche().get(player.getQualita().get(scoreIndex).caratteristica2).nome + 
    						"  = " + (player.getQualita().get(scoreIndex).getLivello() * player.getQualita().get(scoreIndex).car2Mod + 1));
            	}
            	else 
            	{
            		player.incrementaPunteggio(scoreIndex);         	
                    getPunti().setText("" + player.getCaratteristiche().get(scoreIndex).getLivello());
                    costo.setText("" + player.getCaratteristiche().get(scoreIndex).getCosto());   
                    puntiEsperienza.setText("" + player.getEsperienza());	   
            	}
            }
        });
	}

	public TextField getPunti() {
		return punti;
	}

	public void setPunti(TextField punti) {
		this.punti = punti;
	}
}
