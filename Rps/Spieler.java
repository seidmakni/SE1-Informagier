package Rps;


import java.util.regex.Pattern;



public abstract class Spieler {

	protected String name;
	protected int scoreWins;
	protected int scoreLooses;
	protected SpielFeld feld;
	protected char symbol;
	protected Flagge myFlag;
	private static int instanzZeahler;
	/**
	 * gibt Spieler1 das Symbol X und Spieler2 O
	 */
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

	/**
	 * Spieler ohne Name wird als Gast benannt
	 * @param feld aufm dem der Spieler spielt
	 */
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
	
	/*
	 * mache das Spielfeld für einen Spieler Sichbar
	 */
	public void macheSichbar() {
		feld.macheSichbar(this.symbol);
	}

	/**
	 * Zeigt dem spieler in welche Richtung eine Spielfigur sich bewegen kann
	 * 
	 * @param spielfigur
	 * @return Richtung in die man sich bewegen kann
	 */
	public String[] einheitAusweahlen(Spielfigur spielfigur) {
		String[] auswahl;
		if (spielfigur instanceof Beweglich&&this.symbol==spielfigur.symbol) {
			String s= ((Beweglich) spielfigur).gebeAuswahl(feld);
			auswahl=s.split(Pattern.quote("|"));
			return auswahl;
		
		} else {
			auswahl=new String[1];
			auswahl[0]= "-";
			return auswahl;
		}

	}
/**
 * 
 * @param spielfigur die bewegt werden soll
 * @param richtung richung 'W''A'S'D'
 * @return 1 bewegung gelungen 0unenteschieden beim kämpfen -1 keine beweung möglich
 */
	public int einheitBewegen(Spielfigur spielfigur, char richtung) {
		if (spielfigur instanceof Beweglich) {
			return ((Beweglich) spielfigur).bewegen(richtung, feld);
			
		} else {
			return -1;
		}

	}
	/**
	 * 
	 * @param spielfigur welche geändert werden soll
	 * @param s eingbae in was
	 * @return neue Spielfigur auf dem PLatz der alten
	 */
	public Beweglich einheitNeuwaehlen(Spielfigur spielfigur,String s) {
		if(s=="Schere") {
			int position=spielfigur.getPostion();
			char symbol=spielfigur.getSymbol();
			Beweglich bew=new Schere(symbol);
			bew.setPostion(position);
			bew.setSichbar(false);
			return bew;
		}
		if(s=="Stein") {
			int position=spielfigur.getPostion();
			char symbol=spielfigur.getSymbol();
			Beweglich bew=new Stein(symbol);
			bew.setPostion(position);
			bew.setSichbar(false);

			return bew ;
		}
		if(s=="Papier") {
			int position=spielfigur.getPostion();
			char symbol=spielfigur.getSymbol();
			Beweglich bew=new Papier(symbol);
			bew.setPostion(position);
			bew.setSichbar(false);

			return bew;
		}
		return null;
	}
	/**
	 * 
	 * @param zahl index der Zeilen im 2d. array
	 * @param buchstabe index der Spalten im 2d. array
	 * @return flagge gesetzt JA/NEIN
	 */
	public boolean setztFlagge(int zahl, int buchstabe) {
		if (zahl < 2 && zahl >= 0 && buchstabe < 7 && buchstabe >= 0) {
			feld.flaggeSetzen(zahl, buchstabe, symbol);
			myFlag=(Flagge)feld.getSpielfigur(zahl, buchstabe);
			return true;
		}
		return false;
	}
	
	/**
	 * überprüft ob ein SPieler seine flagge verloren hat
	 * @return
	 */
	public boolean cheackWin() {
		return myFlag.getStatus();
	}
	/**
	 * 
	 * @param zahl index der Zeilen im 2d. array
	 * @param buchstabe index der Spalten im 2d. array
	 * @return flagge gesetzt JA/NEIN
	 */
	public boolean setztFalle(int zahl, int buchstabe) {
		if (zahl < 2 && zahl >= 0 && buchstabe < 7 && buchstabe >= 0) {
			return feld.falleSetzen(zahl, buchstabe, symbol);
		}
		return false;
	}

	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setName(String name) {
		if (name.length() > 3 || name.length() < 11 && name != "Gast")
			this.name = name;
	}
	
}
