package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import Rps.*;

public class MainFrame extends javax.swing.JFrame {
	Button[][] buttons;
	JPanel panel1 = new JPanel();
	

	public MainFrame(RPSonline game) {
		this.initComponents(game);
		this.setTitle("RPS-Online");
		this.setSize(800, 500);
		this.setResizable(false);
		this.setLocation(50, 50);
		this.setVisible(true);
		

	}

	private void initComponents(RPSonline game) {
		Spielfigur[][] feld = game.gebeFeld();
		JPanel panel = new JPanel();
		buttons = new Button[feld.length][];
		for (int i = 0; i < feld.length; i++) {
			buttons[i] = new Button[feld[i].length];
		}
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		for (int i = buttons.length-1;i>=0; i--) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new Button(String.format("%10s", ""));
				buttons[i][j].setPreferredSize(new Dimension(100,50));
				panel.add(buttons[i][j]);
			}
		}
		panel1=panel;
		this.add(panel1);
	}

	public void refresh(RPSonline game) {
		this.remove(panel1);
		Spielfigur[][] feld = game.gebeFeld();
		JPanel panel = new JPanel();
		
		for (int i = buttons.length-1;i>=0; i--) {
			for (int j = 0; j < buttons[i].length; j++) {
				
				if (feld[i][j] != null) {
					if (feld[i][j] instanceof Stein) {
						buttons[i][j] = new Button((Stein) feld[i][j]);
						buttons[i][j].setPreferredSize(new Dimension(100,50));
						buttons[i][j].addActionListener(new ActionAuswahl(game,feld[i][j]));
						panel.add(buttons[i][j]);
					}
					if (feld[i][j] instanceof Schere) {
						buttons[i][j] = new Button((Schere) feld[i][j]);
						buttons[i][j].setPreferredSize(new Dimension(100,50));
						buttons[i][j].addActionListener(new ActionAuswahl(game,feld[i][j]));
						panel.add(buttons[i][j]);
					}
					if (feld[i][j] instanceof Papier) {
						buttons[i][j] = new Button((Papier) feld[i][j]);
						buttons[i][j].setPreferredSize(new Dimension(100,50));
						buttons[i][j].addActionListener(new ActionAuswahl(game,feld[i][j]));
						panel.add(buttons[i][j]);
					}
					if (feld[i][j] instanceof Flagge) {
						buttons[i][j] = new Button((Flagge) feld[i][j]);
						buttons[i][j].setPreferredSize(new Dimension(100,50));
						panel.add(buttons[i][j]);
					}
					if (feld[i][j] instanceof Falle) {
						buttons[i][j] = new Button((Falle) feld[i][j]);
						buttons[i][j].setPreferredSize(new Dimension(100,50));
						panel.add(buttons[i][j]);
					}
				} else {
					buttons[i][j] = new Button(String.format("%10s", ""));
					buttons[i][j].setPreferredSize(new Dimension(100,50));
					panel.add(buttons[i][j]);
				}

			}
		}
		panel1=panel;
		this.add(panel1);
		this.validate();
	}

}
