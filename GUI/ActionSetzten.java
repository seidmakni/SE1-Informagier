package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Rps.*;

public class ActionSetzten implements ActionListener {
	private RPSonline game;
	private Spieler player;
	private int i;
	private int j;
	
	public ActionSetzten(RPSonline game,int i,int j){
		this.game=game;
		this.player=game.getSpieler();
		this.i=i;
		this.j=j;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// falgge mit buttons setzten
		player.setztFlagge(i,j);
			
	}

}
