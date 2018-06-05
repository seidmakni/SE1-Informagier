
public class Beweglich extends Spielfigur {

	protected boolean sichtbar;

	public Beweglich(char symbol) {
		super(symbol);
		
	}

	public boolean bewegen(String richtung) {
		
		return false;
	}

	private Spielfigur kaempfen(Spielfigur spielfigur2) {
		// TODO k�mpfen irgendwie
		if (spielfigur2 instanceof Falle) {
			return spielfigur2;
		}
		if (spielfigur2 instanceof Flagge) {
			// TODO f�r wen eingenommen
			((Flagge) spielfigur2).eingenommen();

		}
		if (this == spielfigur2) {
			// TODO neu w�hlen
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
