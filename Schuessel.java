
public class Schuessel {
	private boolean schluessel;
	private int anzahl;
	private String test;
	
	public Schuessel(){
		schluessel=true;
	}

	public boolean isSchluessel() {
		return schluessel;
	}

	public void setSchluessel(boolean schluessel) {
		this.schluessel = schluessel;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
