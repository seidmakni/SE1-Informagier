package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import Rps.RPSonline;
import Rps.SpielFeld;
import Rps.Spieler;
import Rps.Spielfigur;

public class ActionNeuWahl implements ActionListener {
	private String buttonname;
	private int position;
	private Spieler player;
	private RPSonline game;
	private JDialog frame;

	public ActionNeuWahl(String name, int position, RPSonline game,JDialog frame ) {
		this.game = game;
		this.buttonname = name;
		this.player = game.getSpieler();
		this.frame=frame;
		this.position = position;
	}
/**
 * ersetzt die figur durch eine Neue
 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		Spielfigur[][] feld = game.gebeFeld();
		int i = position / 10;
		int j = position % 10;
		feld[i][j] = player.einheitNeuwaehlen(feld[i][j], buttonname);
		frame.setVisible(false);

	}

}
