
public abstract class Spieler {

	protected String name;
	protected int scoreWins;
	protected int scoreLooses;
	protected SpielFeld feld;
	protected char symbol;
	private static int instanzZeahler;

	
	private Spieler() {
		//zaehlt die erzeugten instanzen der Klasse gerade="O" symbol ungerade="X" symbol
		if (instanzZeahler % 2 == 0) {
			symbol = 'O';
		} else {
			symbol = 'X';
		}
		instanzZeahler++;
	}

	public Spieler(SpielFeld feld) {
		//Name wird als "Gast" gesetzt wenn man diesen Leer lässt
		this();
		setName("Gast");
		this.feld = feld;
	}

	public Spieler(SpielFeld feld, String name) {
		this(feld);
		setName(name);
	}

	/**Zeigt dem spieler in welche Richtung eine Spielfigur sich bewegen kann
	 * 
	 * @param spielfigur welche man bewegen moechte
	 */
	public void einheitAusweahlen(Spielfigur spielfigur) {
		if (spielfigur instanceof Beweglich) {
			int i = spielfigur.getPostion() / 10;
			int j = spielfigur.getPostion() % 10;
			System.out.println(feld.istBesetzt(i, j));
		} else {
			System.out.println("Bitte eine Bewegliche Eiheit auswählen");
		}

	}

	public boolean setztFlagge(int zahl, int buchstabe) {
		return feld.flaggeSetzen(zahl, buchstabe, symbol);
	}

	public boolean setztFalle(int zahl, int buchstabe) {
		return feld.falleSetzen(zahl, buchstabe, symbol);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() > 3 || name.length() < 11 && name != "Gast")
			this.name = name;
	}
}
