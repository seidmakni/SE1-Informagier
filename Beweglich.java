
public class Beweglich extends Spielfigur {

	protected boolean sichtbar;

	public Beweglich(char symbol) {
		super(symbol);
		sichtbar = true;
	}

	public boolean bewegen(String richtung) {
		// TODO tausen abfragen ob das möfglich ist bei feindkontakt kämpfen und sonst
		// false
		// if abfrage ob falle oder flagge (bewegen und angreifen)
		
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
			// TODO neu wählen
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
