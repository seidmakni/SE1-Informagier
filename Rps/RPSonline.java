package Rps;


public class RPSonline {
	private int spielerAnz;
	private SpielFeld feld=new SpielFeld();
	private int amZug;
	public Spieler[] player;

	public RPSonline(int spielerAnz,String name1,String name2) {
		player=new Spieler[2];
		amZug=0;
		player[0]=new MenschlicherSpieler(feld,name1);
		player[1]=new MenschlicherSpieler(feld,name2);
		
	}
	
	public void welchselSpieler() {
		if(amZug==0)
			amZug=1;
		else {
			amZug=0;
		}
		feld.dreheFeld();
	}
	
	public void start() {
		feld.befuellen();
	}
	
	public Spieler getSpieler() {
		return player[amZug];
	}
	
	public Spielfigur[][] gebeFeld(){
		return feld.getFeld();
	}
	
	public SpielFeld gebeSpielfeld(){
		return feld;
	}


}
