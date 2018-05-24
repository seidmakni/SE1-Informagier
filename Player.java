
public class Player {

	private void befuellen(Spielfigur[][] feld) {
		//Player1 fuelle erste und zweite Reihe des Spielfelds
		for(int i=0;i<2;i++) {
			for(int j=0;j<feld[i].length;j++) {
				if(feld[i][j]==null) {
				//TODO Spielfigruen zufällig erzeugen

				}
			}
		}
		//Player2 fuelle letzte und vorletzte Reihe des Spielfelds 
		for(int i=feld.length;i>feld.length-2;i--) {
			for(int j=0;j<feld[i].length;j++) {
				if(feld[i][j]==null) {
				//TODO Spielfiguren zufällig  erzeugen
				}
			}
		}
	}
	
	
	
}
