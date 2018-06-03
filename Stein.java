
public class Stein extends Beweglich {

	public Stein(char symbol) {
		super(symbol);
	}
	
	public boolean steinSchleagtSchere(Spielfigur spielfigur2) {
		if(spielfigur2 instanceof Schere) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		if (this.isSichtbar() || this.isAnsicht()) {
			return this.getSymbol() + " Stein";
		}
		return ""+this.getSymbol();

	}

}
