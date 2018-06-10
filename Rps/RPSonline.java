package Rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RPSonline {
	private int spielerAnz;
	private SpielFeld feld = new SpielFeld();
	private int amZug;
	private boolean ende;
	private Spieler[] player;

	public RPSonline(int spielerAnz, String name1, String name2) {
		player = new Spieler[2];
		amZug = 0;
		ende = true;
		player[0] = new MenschlicherSpieler(feld, name1);
		player[1] = new MenschlicherSpieler(feld, name2);

	}

	public void welchselSpieler() {
		if (amZug == 0)
			amZug = 1;
		else {
			amZug = 0;
		}
		this.getSpieler().macheSichbar();
		feld.dreheFeld();
	}

	public void rpsPlazieren() {
		feld.befuellen();
	}

	public Spieler getSpieler() {
		return player[amZug];
	}

	public Spielfigur[][] gebeFeld() {
		return feld.getFeld();
	}

	public void setzteFigur() {
		int zahl;
		int buchstabe;
		boolean ok = false;
		do {
			System.out.println(
					this.getSpieler().getName() + " bitte gebe sie coordinaten für die Flagge ein von 00-16 ein");
			Scanner sc = new Scanner(System.in);
			try {
				int eingabe = sc.nextInt();
				zahl = eingabe / 10;
				buchstabe = eingabe % 10;
				ok = this.getSpieler().setztFlagge(zahl, buchstabe);
			} catch (InputMismatchException e) {
				System.out.println("keine zahl");
			}

		} while (!ok);

		ok = false;
		do {
			System.out.println(
					this.getSpieler().getName() + " bitte gebe sie coordinaten für die Falle ein von 00-16 ein");
			Scanner sc = new Scanner(System.in);
			try {
				int eingabe = sc.nextInt();
				zahl = eingabe / 10;
				buchstabe = eingabe % 10;
				ok = this.getSpieler().setztFalle(zahl, buchstabe);
				System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
			} catch (InputMismatchException e) {
				System.out.println("keine zahl");
			}

		} while (!ok);
	}

	public boolean getEnde() {
		return ende;
	}
	
	//TODO boolean mit fenster übergabe 
	public void checkWinner() {
		if (this.getSpieler().cheackWin()) {
			ende = false;
			System.out.println(this.getSpieler().getName() + " hat gewonnen");
		}
	}

}
