
public abstract class Spieler {
	
	private String name;
	private int scoreWins;
	private int scoreLooses;
	
	public Spieler() {
		setName("Gast");	
	}

	public Spieler(String name) {
		setName(name);
	}
	
	public boolean  einheitBewegen(Beweglich spielfigur,String richtung) {
		return spielfigur.bewegen(richtung);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.length()>3||name.length()<11)
		this.name = name;
	}
}
