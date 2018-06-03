/**
 * 
 * @author luggi
 *
 */
public class Spielfigur {
	protected char symbol;
	protected boolean ansicht;
	protected int postion;

	/**
	 * 
	 * @param symbol
	 */
	public Spielfigur(char symbol) {
		this.setSymbol(symbol);
	}

	public boolean isAnsicht() {
		return ansicht;
	}

	public void setAnsicht(boolean ansicht) {
		this.ansicht = ansicht;
	}


	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

}
