package Rps;

import java.util.regex.Pattern;

public abstract class Spieler {

	protected String name;
	protected int scoreWins;
	protected int scoreLooses;
	protected SpielFeld feld;
	protected char symbol;
	private static int instanzZeahler;

	private Spieler() {
		// zaehlt die erzeugten instanzen der Klasse gerade="O" symbol ungerade="X"
		// symbol
		if (instanzZeahler % 2 == 0) {
			symbol = 'X';
		} else {
			symbol = 'O';
		}
		instanzZeahler++;
	}

	public Spieler(SpielFeld feld) {
		// Name wird als "Gast" gesetzt wenn man diesen Leer lässt
		this();
		setName("Gast");
		this.feld = feld;
	}

	public Spieler(SpielFeld feld, String name) {
		this(feld);
		setName(name);
	}

	/**
	 * Zeigt dem spieler in welche Richtung eine Spielfigur sich bewegen kann
	 * 
	 * @param spielfigur
	 *            welche man bewegen moechte
	 */
	public String[] einheitAusweahlen(Spielfigur spielfigur) {
		String[] auswahl;
		if (spielfigur instanceof Beweglich) {
			String s= ((Beweglich) spielfigur).gebeAuswahl(feld);
			auswahl=s.split(Pattern.quote("|"));
			return auswahl;
		
		} else {
			auswahl=new String[1];
			auswahl[0]= "Dies ist keine Bewegliche Figur";
			return auswahl;
		}

	}

	public boolean einheitBewegen(Spielfigur spielfigur, char richtung) {
		if (spielfigur instanceof Beweglich) {
			((Beweglich) spielfigur).bewegen(richtung, feld);
			return true;
		} else {
			return false;
		}

	}

	public boolean setztFlagge(int zahl, int buchstabe) {
		if (zahl < 2 && zahl >= 0 && buchstabe < 7 && buchstabe >= 0) {
			return feld.flaggeSetzen(zahl, buchstabe, symbol);
		}
		return false;
	}

	public boolean setztFalle(int zahl, int buchstabe) {
		if (zahl < 2 && zahl >= 0 && buchstabe < 7 && buchstabe >= 0) {
			return feld.falleSetzen(zahl, buchstabe, symbol);
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() > 3 || name.length() < 11 && name != "Gast")
			this.name = name;
	}
}
