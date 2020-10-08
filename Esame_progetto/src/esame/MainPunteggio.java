package esame;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainPunteggio {

	public static void main(String[] args) {
		Personaggio player=new Personaggio("Mario");
		MemorizzaPersonaggi memoria=new MemorizzaPersonaggi(player);
		Dashboard dashboard=new Dashboard(player, memoria);
	}
}
