
public class Papier extends Beweglich{
	
	public Papier (char symbol) {
		super(symbol);
	}

	public boolean PapierSchleagtStein(Spielfigur spielfigur2) {
		if(spielfigur2 instanceof Stein) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		if (this.isSichtbar() || this.isAnsicht()) {
			return this.getSymbol() + " Papier";
		}
		return ""+this.getSymbol();

	}
}
