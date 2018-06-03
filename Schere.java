
public class Schere extends Beweglich {
	
	public Schere (char symbol) {
		super(symbol);
	}
	
	public boolean schereSchleagtPapier(Spielfigur spielfigur2) {
		if(spielfigur2 instanceof Papier) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (this.isSichtbar() || this.isAnsicht()) {
			return this.getSymbol() + " Schere";
		}
		return ""+this.getSymbol();

	}

}
