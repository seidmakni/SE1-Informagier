package GUI;

import java.util.Scanner;

import Rps.RPSonline;
import Rps.Spielfigur;

public class TestThread1 implements Runnable {

	private boolean end;
	private RPSonline game;

	public TestThread1() {
		end=true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (end) {

			RPSonline game = new RPSonline(2, "lukas", "janik");
			// while schleife
			MainFrame frame = new MainFrame(game);

			// buttons die variable zahl buchstabe beeinflussen
			game.setzteFigur();
			game.welchselSpieler();
			game.setzteFigur();
			game.rpsPlazieren();
			
			frame.refresh(game);
			game.welchselSpieler();


			while (game.getEnde()) {
				frame.refresh(game);
				game.checkWinner();

				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				

			}
			frame.setVisible(false);

		}
	}

}
