package Rps;

public class Flagge extends Spielfigur {

	private boolean status;

	public Flagge(char symbol) {
		super(symbol);
		status=false;
	}

	public void eingenommen() {
		status = true;
	}
	
	public boolean getStatus() {
		return status;
	}

	@Override
	public String toString() {
		if (this.isAnsicht()) {
			return String.format("%10s", this.getSymbol() + " Flagge");
		}
		return String.format("%10s", "" + this.getSymbol());

	}

}
