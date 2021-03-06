
public class SpielFeld {
	private Spielfigur[][] feld;

	public SpielFeld() {
		feld = new Spielfigur[6][7];
	}
	/**
	 * 
	 * @param zahl: Index der Reihen im Spielfeld
	 * @param buchstabe: Index der Splaten im Spielfeld
	 * @param symbol: zugehoeriges Symbol der Spielfiguren
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
	 * @param zahl Index der Reihen im Spielfeld
	 * @param buchstabe Index der Splaten im Spielfeld
	 * @param symbol zugehoeriges Symbol der Spielfiguren
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
	 *Befuellt das Spielfeld mit der "fuellen" Methode
	 *Player 1 bekommt "O" als Zeichen
	 *Player 2 bekommt "X" als Zeichen
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

	/**Erstellt ein zufaelliges befuelltes Array mit Schere Stein Papier
	 * 
	 * @param symbol: zeigt Spieler welche Figur wem gehoert
	 * @return zufaelliges befuelltes Array mit Schere Stein Papier Obejecten
	 */
	private static Spielfigur[] fuellen(char symbol) {
		Spielfigur container[] = new Spielfigur[12];
		for (int i = 0; i < container.length; i++) {
			int rmd;
			//suche zuf�lligen leeren Platzt im Array
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
	
/** Methode zur Abfrage wo welche Spielfigur sich hin bewegen kann
 * Trennzeichen im String: ","
 * @param i index der Reihe im Spielfeld
 * @param j index der Spalten im Spieleld
 * @return String mit Moeglichkeiten welche bewegungen ausgefuehrt werden kann
 */
	// TODO namen �ndern!
	public String istBesetzt(int i, int j) {
		String s = "";
		// Abfrage ob gerade aus Frei oder ein Gegner ist
		if (i < feld.length - 1) {
			if (feld[i + 1][j] == null || feld[i + 1][j].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "W, ";
			}
		}
		// Abfrage ob links  Frei oder ein Gegner ist
		if (j > 0) {
			if (feld[i][j - 1] == null || feld[i][j - 1].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "A, ";
			}
		}
		// Abfrage ob rueckwaerts Frei oder ein Gegner ist
		if (i > 0) {
			if (feld[i - 1][j] == null || feld[i - 1][j].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "S, ";
			}
		}
		// Abfrage ob rechts Frei oder ein Gegner ist
		if (j < feld[i].length - 1) {
			if (feld[i][j + 1] == null || feld[i][j + 1].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "D, ";
			}
		}
		s = s + " Abbrechen";
		return s;
	}

	/**
	 * gebe Spielfeld aus
	 */
	public void printxy() {
		int counter = 1;
		char c = 'A';
		for (int i = 0; i <= feld.length; i++) {
			System.out.printf("%10s", c);
			c++;
		}
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			if (counter != 1)
				System.out.println();
			System.out.print(counter);
			counter++;
			for (int j = 0; j < feld[i].length; j++) {
				System.out.printf("%10s", feld[i][j]);

			}
		}
		System.out.println("\n");
	}

	/** Aufs Spielfeld zugreifen
	 * 
	 * @param i index der Reihe im Spielfeld
	 * @param j index der Reihe im Spielfeld
	 * @return Spielfigur an Position i,j
	 */
	public Spielfigur getSpielfigur(int i, int j) {

		return feld[i][j];

	}

}
