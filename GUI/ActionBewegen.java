package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import Rps.RPSonline;
import Rps.Spieler;
import Rps.Spielfigur;

public class ActionBewegen implements ActionListener {
	private Spieler player;
	private Spielfigur spielfigur;
	private JDialog frame2;
	private RPSonline game;
	private String buttonName;
	private String neuWahl;

	public ActionBewegen(RPSonline game, Spielfigur spielfigur, String name, JDialog frame2) {
		this.player = game.getSpieler();
		this.spielfigur = spielfigur;
		this.frame2 = frame2;
		this.game = game;
		this.buttonName = name;

	}
/**
 * bewegt die Einheit nach vorne
 * bei unentscheiden neuer frame mit auswahlmöglichkeiten seine figur zu ändern
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		char c = buttonName.charAt(0);
		if (c == 'E') {
			frame2.setVisible(false);
		} else {
			if (player.einheitBewegen(spielfigur, c) == 0) {
				int position = spielfigur.getPostion();
				frame2.setVisible(false);
				JDialog frame = new JDialog();
				frame.setTitle(game.getSpieler().getName() + " wähle neu");
				frame.setSize(200, 200);
				frame.setLocation(850, 200);
				JPanel panel2 = new JPanel();

				Button button1 = new Button("Schere");
				button1.addActionListener(new ActionNeuWahl(button1.getName(), position, game, frame));
				Button button2 = new Button("Stein");
				button2.addActionListener(new ActionNeuWahl(button2.getName(), position, game, frame));
				Button button3 = new Button("Papier");
				button3.addActionListener(new ActionNeuWahl(button3.getName(), position, game, frame));

				panel2.add(button1);
				panel2.add(button2);
				panel2.add(button3);
				frame.add(panel2);
				frame.setVisible(true);

				if (c == 'W') {
					position = position+10;
				}
				if (c == 'A') {
					position = position-1;
				}
				if (c == 'S') {
					position = position-10;
				}
				if (c == 'D') {
					position =position +1;
				}
				JDialog frame2 = new JDialog();
				frame2.setTitle(game.getSpieler().getName() + " wähle neu");
				frame2.setSize(200, 200);
				frame2.setLocation(850, 200);
				JPanel panel3 = new JPanel();

				button1 = new Button("Schere");
				button1.addActionListener(new ActionNeuWahl(button1.getName(), position, game, frame2));
				button2 = new Button("Stein");
				button2.addActionListener(new ActionNeuWahl(button2.getName(), position, game, frame2));
				button3 = new Button("Papier");
				button3.addActionListener(new ActionNeuWahl(button3.getName(), position, game, frame2));

				panel3.add(button1);
				panel3.add(button2);
				panel3.add(button3);
				frame2.add(panel3);
				frame2.setVisible(true);
			} else {
				frame2.setVisible(false);
				game.welchselSpieler();
			}
		}
	}
	


}
