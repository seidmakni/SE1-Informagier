
public class Spielfigur {
	private String art;
	private char symbol;
	private boolean sichtbar;

	public Spielfigur(String art) {
		this.setArt(art);
		sichtbar=true;
	}
	public Spielfigur(String art, char symbol) {
		this.setArt(art);
		this.setSymbol(symbol);
		sichtbar=true;
	}

	public Spielfigur kaempfen(Spielfigur spielfigur2) {
		// TODO kämpfen irgendwie
		return null;
	}

	public boolean isSichtbar() {
		return sichtbar;
	}

	public void setSichbar(boolean sichtbar) {
		this.sichtbar = sichtbar;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String s) {
		this.art = s;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		if (sichtbar) {
			return "" + this.getSymbol() + "" + this.getArt();
		} else {
			return "" + this.getSymbol();
		}
	}
}
