package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Rps.*;

public class ActionAuswahl implements ActionListener {
	private Spieler player;
	private Spielfigur spielfigur;
	private RPSonline game;
	
	public ActionAuswahl() {

	}

	public ActionAuswahl(RPSonline game,Spielfigur spielfigur) {
		this.game=game;
		this.player = game.getSpieler();
		this.spielfigur = spielfigur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JDialog frame2 = new JDialog();
		frame2.setTitle("Auswahl der Bewegung");
		frame2.setSize(200, 200);
		frame2.setLocation(850, 200);

		// TODO LABEL einbauen
		// JLabel label = new JLabel("Wo möchten sie hingehen");
		JPanel panel = new JPanel();
		String[] auswahl = player.einheitAusweahlen(spielfigur);
		Button[] buttons = new Button[auswahl.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(auswahl[i]);
			buttons[i].setPreferredSize(new Dimension(60, 60));
			// TODO Button action
			if (auswahl[i].equals("W")) {
				buttons[i].addActionListener(new ActionBewegen(game,spielfigur,buttons[i].getName(),frame2));
				panel.add(buttons[i], java.awt.BorderLayout.PAGE_START);
			}
			if (auswahl[i].equals("A")) {
				buttons[i].addActionListener(new ActionBewegen(game,spielfigur,buttons[i].getName(),frame2));
				panel.add(buttons[i], java.awt.BorderLayout.LINE_START);
			}
			if (auswahl[i].equals("S")) {
				buttons[i].addActionListener(new ActionBewegen(game,spielfigur,buttons[i].getName(),frame2));
				panel.add(buttons[i], java.awt.BorderLayout.CENTER);
			}
			if (auswahl[i].equals("D")) {
				buttons[i].addActionListener(new ActionBewegen(game,spielfigur,buttons[i].getName(),frame2));
				panel.add(buttons[i], java.awt.BorderLayout.LINE_END);
			}
			if (auswahl[i].equals("ESC")) {
				buttons[i].addActionListener(new ActionBewegen(game,spielfigur,buttons[i].getName(),frame2));
				panel.add(buttons[i], java.awt.BorderLayout.PAGE_END);
			}

		}

		frame2.add(panel);
		frame2.setVisible(true);
		frame2.pack();

	}

}
