package GUI;

import Rps.RPSonline;
import Rps.Spielfigur;

public class TestThread1 implements Runnable {

	private boolean end;
	private RPSonline game;
	private boolean refresh;

	public TestThread1() {
		end=true;
		refresh=true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (end) {

			RPSonline game = new RPSonline(2, "likas", "janikk");

			// while schleife

			// buttons die variable zahl buchstabe beeinflussen
			int zahl = 0;
			int buchstabe = 0;
			game.getSpieler().setztFlagge(zahl, buchstabe);
			zahl = 0;
			buchstabe = 1;
			game.getSpieler().setztFalle(zahl, buchstabe);

			zahl = 0;
			buchstabe = 0;
			game.welchselSpieler();
			game.getSpieler().setztFlagge(zahl, buchstabe);
			zahl = 0;
			buchstabe = 5;
			game.getSpieler().setztFalle(zahl, buchstabe);

			game.start();
			game.welchselSpieler();

			MainFrame frame = new MainFrame(game);
			frame.refresh(game);
			game.welchselSpieler();


			while (refresh) {
				frame.refresh(game);

				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}

			}

		}
	}

}
