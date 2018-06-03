
public class SpielFeld {
	private Spielfigur[][] feld;
	private int eingabeZeahler;

	public SpielFeld() {
		feld = new Spielfigur[6][7];
		eingabeZeahler = 0;

	}

	public boolean befuellen(int zahl, int buchstabe) {
		// TODO einzelne cases machen
		eingabeZeahler++;
		switch (eingabeZeahler) {
		case 1:
			feld[zahl][buchstabe] = new Flagge('O');
			return true;
		case 2:
			if (feld[zahl][buchstabe] == null) {
				feld[zahl][buchstabe] = new Falle('O');

				int count = 0;
				Spielfigur container1[] = fuellen('O');
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
			feld[zahl][buchstabe] = new Flagge('X');
			return true;
		case 4:
			if (feld[zahl][buchstabe] == null) {
				feld[zahl][buchstabe] = new Falle('X');
				int count = 0;

				Spielfigur container2[] = fuellen('X');
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

	private static Spielfigur[] fuellen(char symbol) {
		Spielfigur container[] = new Spielfigur[12];
		for (int i = 0; i < container.length; i++) {
			int rmd;
			do {
				rmd = (int) (Math.random() * 12);
			} while (container[rmd] != null);
			if (i < 4) {
				container[rmd] = new Schere(symbol);
			} else if (i > 7) {
				container[rmd] = new Stein(symbol);
			} else {
				container[rmd] = new Papier(symbol);
			}
		}
		return container;
	}

	public void printxy() {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				System.out.println(feld[i][j]);
			}
		}
	}

}
