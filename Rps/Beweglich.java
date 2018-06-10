package Rps;


public class Beweglich extends Spielfigur {

	protected boolean sichtbar;

	public Beweglich(char symbol) {
		super(symbol);

	}

	/**
	 * Methode zur Abfrage wo welche Spielfigur sich hin bewegen kann Trennzeichen
	 * im String: "|"
	 * 
	 * @param board:
	 *            Spielfeld aufdem sich die Figur befindet
	 * @return String mit Moeglichkeiten welche bewegungen ausgefuehrt werden kann
	 */
	public String gebeAuswahl(SpielFeld board) {
		Spielfigur[][] feld = board.getFeld();
		int i = this.getPostion() / 10;
		int j = this.getPostion() % 10;
		String s = "";
		// Abfrage ob gerade aus Frei oder ein Gegner ist
		if (i < feld.length - 1) {
			if (feld[i + 1][j] == null || feld[i + 1][j].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "W|";
			}
		}
		// Abfrage ob links Frei oder ein Gegner ist
		if (j > 0) {
			if (feld[i][j - 1] == null || feld[i][j - 1].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "A|";
			}
		}
		// Abfrage ob rueckwaerts Frei oder ein Gegner ist
		if (i > 0) {
			if (feld[i - 1][j] == null || feld[i - 1][j].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "S|";
			}
		}
		// Abfrage ob rechts Frei oder ein Gegner ist
		if (j < feld[i].length - 1) {
			if (feld[i][j + 1] == null || feld[i][j + 1].getSymbol() != feld[i][j].getSymbol()) {
				s = s + "D|";
			}
		}
		s = s + "ESC|";
		return s;
	}

	/**
	 * Spielfigur bewegen und bei feindkontakt kaempfen
	 * 
	 * @param richtung
	 *            nur Charakter aus Auswahl erlaubt
	 * @param board
	 *            spielfeld auf dem sich die Figur bewegt
	 * @return 1 bewegung gelungen ; 0 neuwahlen beim Kämpfen erforderlich ;-1 keine
	 *         bewegung möglich
	 */
	public int bewegen(char richtung, SpielFeld board) {
		int i = this.getPostion() / 10;
		int j = this.getPostion() % 10;
		Spielfigur[][] feld = board.getFeld();
		// Abfrage ob gerade ein Gegner ist
		if (richtung == 'W') {
			if (feld[i + 1][j] == null) {
				feld[i + 1][j] = this;
				int position = (i + 1) * 10 + j;
				this.setPostion(position);
				feld[i][j] = null;
				return 1;
			}
			if (feld[i + 1][j].getSymbol() != feld[i][j].getSymbol()) {
				if (this.kaempfen(feld[i + 1][j], feld) == 1) {
					feld[i + 1][j] = feld[i][j];
					int position = (i + 1) * 10 + j;
					feld[i + 1][j].setPostion(position);
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i + 1][j], feld) == -1) {
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i + 1][j], feld) == 0) {
					return 0;
				}

			}

		}
		// Abfrage ob links Frei oder ein Gegner ist
		if (richtung == 'A') {
			if (feld[i][j - 1] == null) {
				feld[i][j - 1] = this;
				int position = i * 10 + j - 1;
				this.setPostion(position);
				feld[i][j] = null;
				return 1;
			}
			if (feld[i][j - 1].getSymbol() != feld[i][j].getSymbol()) {
				if (this.kaempfen(feld[i][j - 1], feld) == 1) {
					feld[i][j - 1] = feld[i][j];
					int position = (i) * 10 + j - 1;
					feld[i][j - 1].setPostion(position);
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i][j-1], feld) == -1) {
					feld[i][j - 1] = null;
					return 1;
				}
				if (this.kaempfen(feld[i][j - 1], feld) == 0) {
					return 0;
				}

			}
		}
		// Abfrage ob rueckwaerts Frei oder ein Gegner ist
		if (richtung == 'S') {
			if (feld[i - 1][j] == null) {
				feld[i - 1][j] = this;
				int position = (i - 1) * 10 + j;
				this.setPostion(position);
				feld[i][j] = null;
				return 1;
			}
			if (feld[i - 1][j].getSymbol() != feld[i][j].getSymbol()) {
				if (this.kaempfen(feld[i - 1][j], feld) == 1) {
					int position = (i - 1) * 10 + j;
					feld[i - 1][j] = feld[i][j];
					feld[i - 1][j].setPostion(position);
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i - 1][j], feld) == -1) {
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i - 1][j], feld) == 0) {
					return 0;
				}

			}
		}
		// Abfrage ob rechts Frei oder ein Gegner ist
		if (richtung == 'D') {
			if (feld[i][j + 1] == null) {
				feld[i][j + 1] = this;
				int position = (i) * 10 + j + 1;
				this.setPostion(position);
				feld[i][j] = null;
				return 1;
			}
			if (feld[i][j + 1].getSymbol() != feld[i][j].getSymbol()) {
				if (this.kaempfen(feld[i][j + 1], feld) == 1) {
					feld[i][j + 1] = feld[i][j];
					int position = (i) * 10 + j + 1;
					feld[i][j + 1].setPostion(position);
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i][j + 1], feld) == -1) {
					feld[i][j] = null;
					return 1;
				}
				if (this.kaempfen(feld[i][j + 1], feld) == 0) {
					return 0;
				}

			}
		}
		return -1;
	}

	/**
	 * Spielfiguren kämpfen gegeneineander bei 0 neuwahlen
	 * 
	 * @param spielfigur2
	 * @return 1=angreifende Figur gewinnt ;0=untentschieden; -1=angreifende Figur
	 *         verliert
	 */
	private int kaempfen(Spielfigur spielfigur2, Spielfigur[][] feld) {
		if (spielfigur2 instanceof Falle) {
			return -1;
		}
		if (spielfigur2 instanceof Flagge) {
			((Flagge) spielfigur2).eingenommen();
			return 1;

		}

		if (this instanceof Stein) {
			if (((Stein) this).steinSchleagtSchere(spielfigur2)) {
				this.setSichbar(true);
				return 1;
			}
		}
		if (this instanceof Papier) {
			if (((Papier) this).PapierSchleagtStein(spielfigur2)) {
				this.setSichbar(true);
				return 1;
			}
		}

		if (this instanceof Schere) {
			if (((Schere) this).schereSchleagtPapier(spielfigur2)) {
				this.setSichbar(true);
				return 1;
			}
		}
		if (spielfigur2 instanceof Beweglich) {
			((Beweglich) spielfigur2).setSichbar(true);
		}
		if (this.equals(spielfigur2)) {
			// TODO wahl entscheidn
			this.setSichbar(false);
			return 0;
		}
		return -1;
	}

	public boolean isSichtbar() {
		return sichtbar;
	}

	public void setSichbar(boolean sichtbar) {
		this.sichtbar = sichtbar;
	}

}
