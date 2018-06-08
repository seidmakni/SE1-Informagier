package Rps;
import java.util.Scanner;

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
/**Spielfigur bewegen und bei feindkontakt kaempfen
 * 
 * @param richtung nur Charakter aus Auswahl erlaubt
 * @param board spielfeld auf dem sich die Figur bewegt
 * @return bewegegung vollendet
 */
	public boolean bewegen(char richtung, SpielFeld board) {
		int i = this.getPostion() / 10;
		int j = this.getPostion() % 10;
		Spielfigur[][] feld = board.getFeld();
		// Abfrage ob gerade ein Gegner ist
		if (richtung == 'W') {
			if(feld[i+1][j]==null) {
				feld[i + 1][j] = this;
				int position=(i+1)*10+j;
				this.setPostion(position);
				feld[i][j] = null;
				return true;
			}
			if (feld[i + 1][j].getSymbol() != feld[i][j].getSymbol()) {
				feld[i + 1][j] = this.kaempfen(feld[i + 1][j]);
				int position=(i+1)*10+j;
				feld[i+1][j].setPostion(position);
				feld[i][j] = null;
				return true;
			}

		}
		// Abfrage ob links Frei oder ein Gegner ist
		if (richtung == 'A') {
			if(feld[i][j-1]==null) {
				feld[i][j - 1] = this;
				int position=i*10+j-1;
				this.setPostion(position);
				feld[i][j] = null;
				return true;
			}
			if (feld[i][j - 1].getSymbol() != feld[i][j].getSymbol()) {
				feld[i][j - 1] = this.kaempfen(feld[i][j - 1]);
				int position=(i)*10+j-1;
				feld[i][j-1].setPostion(position);
				feld[i][j] = null;
				return true;
			}
		}
		// Abfrage ob rueckwaerts Frei oder ein Gegner ist
		if (richtung == 'S') {
			if(feld[i-1][j]==null) {
				feld[i - 1][j] = this;
				int position=(i-1)*10+j;
				this.setPostion(position);
				feld[i][j] = null;
				return true;
			}
			if (feld[i - 1][j].getSymbol() != feld[i][j].getSymbol()) {
				feld[i - 1][j] = this.kaempfen(feld[i - 1][j]);
				int position=(i-1)*10+j;
				feld[i-1][j].setPostion(position);
				feld[i][j] = null;
				return true;
			} 
		}
		// Abfrage ob rechts Frei oder ein Gegner ist
		if (richtung == 'D') {
			if(feld[i][j+1]==null) {
				feld[i][j + 1] = this;
				int position=(i)*10+j+1;
				this.setPostion(position);
				feld[i][j] = null;
				return true;
			}
			if (feld[i][j + 1].getSymbol() != feld[i][j].getSymbol()) {
				feld[i][j + 1] = this.kaempfen(feld[i][j + 1]);
				int position=(i)*10+j+1;
				feld[i][j+1].setPostion(position);
				feld[i][j] = null;
				return true;
			} 
		}
		return false;
	}

	private Spielfigur kaempfen(Spielfigur spielfigur2) {
		// TODO kämpfen irgendwie
		if (spielfigur2 instanceof Falle) {
			return spielfigur2;
		}
		if (spielfigur2 instanceof Flagge) {
			// TODO für wen eingenommen
			((Flagge) spielfigur2).eingenommen();

		}
		if (this == spielfigur2) {
			//TODO wahl entscheidn
			System.out.println("Unentschieden bitte neu wählen");

			
		}

		if (this instanceof Stein) {
			if (((Stein) this).steinSchleagtSchere(spielfigur2)) {
				this.setSichbar(true);
				return this;
			}
		}
		if (this instanceof Papier) {
			if (((Papier) this).PapierSchleagtStein(spielfigur2)) {
				this.setSichbar(true);
				return this;
			}
		}

		if (this instanceof Schere) {
			if (((Schere) this).schereSchleagtPapier(spielfigur2)) {
				this.setSichbar(true);
				return this;
			}
		}
		return spielfigur2;
	}

	public boolean isSichtbar() {
		return sichtbar;
	}

	public void setSichbar(boolean sichtbar) {
		this.sichtbar = sichtbar;
	}

}
