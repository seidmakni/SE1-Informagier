package Rps;

public class SpielFeld {
	private Spielfigur[][] feld;

	public SpielFeld() {
		feld = new Spielfigur[6][7];
	}

	/**
	 * 
	 * @param zahl:
	 *            Index der Reihen im Spielfeld
	 * @param buchstabe:
	 *            Index der Splaten im Spielfeld
	 * @param symbol:
	 *            zugehoeriges Symbol der Spielfiguren
	 * @return Flagge wurde gesetzt / Flagge wurde nicht gesetzt
	 */
	public boolean flaggeSetzen(int zahl, int buchstabe, char symbol) {
		if (feld[zahl][buchstabe] == null) {
			feld[zahl][buchstabe] = new Flagge(symbol);
			feld[zahl][buchstabe].setPostion(zahl * 10 + buchstabe);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param zahl
	 *            Index der Reihen im Spielfeld
	 * @param buchstabe
	 *            Index der Splaten im Spielfeld
	 * @param symbol
	 *            zugehoeriges Symbol der Spielfiguren
	 * @return boolean: Fallge wurde gesetzt / Falle wurde nicht gesetzt
	 */
	public boolean falleSetzen(int zahl, int buchstabe, char symbol) {
		if (feld[zahl][buchstabe] == null) {
			feld[zahl][buchstabe] = new Falle(symbol);
			feld[zahl][buchstabe].setPostion(zahl * 10 + buchstabe);
			return true;
		}
		return false;
	}

	/**
	 * Befuellt das Spielfeld mit der "fuellen" Methode Player 1 bekommt "O" als
	 * Zeichen Player 2 bekommt "X" als Zeichen
	 */
	public void befuellen() {

		int count = 0;
		Spielfigur container1[] = fuellen('O');
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == null) {
					feld[i][j] = container1[count];
					feld[i][j].setPostion(i * 10 + j);
					count++;
				}
			}
		}
		count = 0;
		Spielfigur container2[] = fuellen('X');
		for (int i = feld.length - 1; i > feld.length - 3; i--) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == null) {
					feld[i][j] = container2[count];
					feld[i][j].setPostion(i * 10 + j);
					count++;
				}
			}
		}

	}

	/**
	 * Erstellt ein zufaelliges befuelltes Array mit Schere Stein Papier
	 * 
	 * @param symbol:
	 *            zeigt Spieler welche Figur wem gehoert
	 * @return zufaelliges befuelltes Array mit Schere Stein Papier Obejecten
	 */
	private static Spielfigur[] fuellen(char symbol) {
		Spielfigur container[] = new Spielfigur[12];
		for (int i = 0; i < container.length; i++) {
			int rmd;
			// suche zufälligen leeren Platzt im Array
			do {
				rmd = (int) (Math.random() * 12);
			} while (container[rmd] != null);
			if (i < 4) {
				container[rmd] = new Schere(symbol);
			} else if (i > 7) {
				container[rmd] = new Stein(symbol);
			} else {
				container[rmd] = new Papier(symbol);
			}
		}
		return container;
	}

	/**
	 * 
	 * @return Spielfeld mit Figuren
	 */
	public Spielfigur[][] getFeld() {
		return this.feld;
	}
/**
 * Macht alle spielfiguren eines Symbols sichbar
 * @param symbol des Spielers
 */
	public void macheSichbar(char symbol) {
		for(int i=0;i<feld.length;i++) {
			for(int j=0;j<feld[i].length;j++) {
				if(feld[i][j]!=null) {
					if(feld[i][j].getSymbol()==symbol) {
						feld[i][j].setAnsicht(true);
					}else {
						feld[i][j].setAnsicht(false);
					}
				}
			}
		}
	}
	/**
	 * gebe Spielfeld auf der console aus
	 */
	public void printxy() {
		int counter = 5;
		char c = 'A';
		for (int i = 0; i <= feld.length; i++) {
			System.out.printf("%10s", c);
			c++;
		}
		System.out.println();
		for (int i = feld.length - 1; i >= 0; i--) {
			if (counter != 5)
				System.out.println();
			System.out.print(counter);
			counter--;
			for (int j = 0; j < feld[i].length; j++) {
				System.out.printf("%10s", feld[i][j]);

			}
		}
		System.out.println("\n");
	}

	/**
	 * Aufs Spielfeld zugreifen
	 * 
	 * @param i
	 *            index der Reihe im Spielfeld
	 * @param j
	 *            index der Reihe im Spielfeld
	 * @return Spielfigur an Position i,j
	 */
	public Spielfigur getSpielfigur(int i, int j) {

		return feld[i][j];

	}

	/**
	 * dreht das feld 
	 */
	public void dreheFeld() {
		for (int i = 0; i < feld.length / 2; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] != null) {
					feld[i][j].setPostion((feld.length - 1 - i) * 10 + feld[i].length - 1 - j);
				}
				if (feld[feld.length - 1 - i][feld[i].length - 1 - j] != null) {
					feld[feld.length - 1 - i][feld[i].length - 1 - j].setPostion(i * 10 + j);
				}

				Spielfigur x = feld[i][j];
				feld[i][j] = feld[feld.length - 1 - i][feld[i].length - 1 - j];
				feld[feld.length - 1 - i][feld[i].length - 1 - j] = x;
			}
		}
	}
}
