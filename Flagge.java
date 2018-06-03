
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
			return this.getSymbol() + " Flagge";
		}
		return ""+this.getSymbol();

	}

}
