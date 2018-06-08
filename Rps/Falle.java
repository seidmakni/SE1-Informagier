package Rps;

public class Falle extends Spielfigur {

	public Falle(char symbol) {
		super(symbol);
	}
	
	public Spielfigur entferntEinheit(Spielfigur spielfigur2) {
		spielfigur2=null;
		return spielfigur2;
	}
	
	@Override
	public String toString() {
		if (this.isAnsicht()) {
			return String.format("%10s", this.getSymbol() + " Falle");
		}
		return String.format("%10s", ""+this.getSymbol());

	}

}
