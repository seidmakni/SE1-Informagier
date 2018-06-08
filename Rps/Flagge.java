package Rps;

public class Flagge extends Spielfigur {

	public Flagge(char symbol) {
		super(symbol);
	}
	
	public boolean eingenommen() {
		return true;
	}
	
	@Override
	public String toString() {
		if (this.isAnsicht()) {
			return String.format("%10s", this.getSymbol() + " Flagge");
		}
		return String.format("%10s",""+this.getSymbol());

	}

}
