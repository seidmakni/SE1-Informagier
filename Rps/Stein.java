package Rps;

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
			return String.format("%10s",this.getSymbol() + " Stein");
		}
		return String.format("%10s",""+this.getSymbol());

	}
	@Override
	public boolean equals(Object o) {
		if(o==null)return false;
		if(o instanceof Stein) {
			return true;
		}return false;
	}

}
