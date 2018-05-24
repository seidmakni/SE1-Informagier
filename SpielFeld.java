
public class SpielFeld {
	private Spielfigur[][] feld;
	private int eingabeZeahler;

	public SpielFeld() {
		feld = new Spielfigur[6][7];
		eingabeZeahler = 0;

	}

	public boolean befuellen(int zahl, int buchstabe) {
		// TODO LOL ROFL EINzelne cases machen
		eingabeZeahler++;
		switch (eingabeZeahler) {
		case 1:
			feld[zahl][buchstabe] = new Spielfigur("Flagge", 'O');
			return true;
		case 2:
			if (feld[zahl][buchstabe] == null) {
				feld[zahl][buchstabe] = new Spielfigur("Falle", 'O');

				int count = 0;
				Spielfigur container1[] = SpielFeld.fuellen('O');
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < feld[i].length; j++) {
						if (feld[i][j] == null) {
							feld[i][j] = container1[count];
							count++;
						}
					}
				}
				return true;
			}
			return false;
		case 3:
			feld[zahl][buchstabe] = new Spielfigur("Flagge", 'X');
			return true;	
		case 4:
			if (feld[zahl][buchstabe] == null) {
				feld[zahl][buchstabe] = new Spielfigur("Falle", 'X');
				int count = 0;

				Spielfigur container2[] = SpielFeld.fuellen('X');
				for (int i = feld.length - 1; i > feld.length - 3; i--) {
					for (int j = 0; j < feld[i].length; j++) {
						if (feld[i][j] == null) {
							feld[i][j] = container2[count];
							count++;
						}
					}
				}
				return true;
			}
			return false;
		default:
			return false;
		}

	}

	public boolean bewegen(int zahl, int buchstabe) {
		// TODO tausen abfragen ob das möfglich ist bei feindkontakt kämpfen und sonst
		// false
		// if abfrage ob falle oder flagge (bewegen und angreifen)
		return false;
	}

	private static Spielfigur[] fuellen(char x) {
		Spielfigur container[] = new Spielfigur[12];
		for (int i = 0; i < container.length; i++) {
			int rmd;
			do {
				rmd = (int) (Math.random() * 12);
			} while (container[rmd] != null);
			if (i < 4) {
				container[rmd] = new Spielfigur("Schere",x);
			}
			else if (i > 7) {
				container[rmd] = new Spielfigur("Stein",x);
			} else {
				container[rmd] = new Spielfigur("Papier",x);
			}
		}
		return container;
	}

	public void printSpielFled() {
		System.out.println("# # # # # # # # # # # # # #");
		System.out.println("#   x    |                #");
		System.out.println("# Schere |                #");
		System.out.println("# _______|                #");
		System.out.println("#                         #");
		System.out.println("#                         #");
		System.out.println("#                         #");
		System.out.println("#                         #");
		System.out.println("#                         #");
		System.out.println("# # # # # # # # # # # # # #");

	}

	public void printxy() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				System.out.println(feld[i][j]);
			}
		}
	}

}
