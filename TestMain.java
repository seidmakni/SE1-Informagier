import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpielFeld board = new SpielFeld();
		MenschlicherSpieler player1=new MenschlicherSpieler(board,"Lukas");
		MenschlicherSpieler player2=new MenschlicherSpieler(board,"Janik");
		
		//Scanner sc =new Scanner(System.in);
		//int i=sc.nextInt();		
		player1.setztFlagge(0,0);
		player1.setztFalle(0,1);
	
		
		player2.setztFlagge(5,1);
		player2.setztFalle(5,2);
	
		board.befuellen();
		
		board.printxy();
		
		player1.einheitAusweahlen(board.getSpielfigur(5, 0));
		
		

	}
	
	
	

}
