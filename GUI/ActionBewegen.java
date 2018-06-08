package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import Rps.Spieler;
import Rps.Spielfigur;

public class ActionBewegen implements ActionListener {
	private Spieler player;
	private Spielfigur spielfigur;
	private JDialog frame;

	public ActionBewegen(Spieler player, Spielfigur spielfigur,JDialog frame) {
		this.player = player;
		this.spielfigur = spielfigur;
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		player.einheitBewegen(spielfigur,'W');
		frame.setVisible(false);

	}

}
