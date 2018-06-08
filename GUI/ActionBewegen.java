package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import Rps.RPSonline;
import Rps.Spieler;
import Rps.Spielfigur;

public class ActionBewegen implements ActionListener {
	private Spieler player;
	private Spielfigur spielfigur;
	private JDialog frame2;
	private RPSonline game;
	private String buttonName;

	public ActionBewegen(RPSonline game, Spielfigur spielfigur, String name, JDialog frame2) {
		this.player = game.getSpieler();
		this.spielfigur = spielfigur;
		this.frame2 = frame2;
		this.game = game;
		this.buttonName = name;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char c = buttonName.charAt(0);
		if (c == 'E') {
			frame2.setVisible(false);
		} else {
			player.einheitBewegen(spielfigur, c);
			frame2.setVisible(false);
			game.welchselSpieler();
		}
	}

}
