
public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x[][]=new String[7][6];
		SpielFeld board= new SpielFeld();

		board.befuellen(0, 0);
		board.befuellen(1, 0);
		board.befuellen(5, 0);
		board.befuellen(5, 1);
		board.befuellen(0, 0);


		board.printxy();
		
		

	}

}
