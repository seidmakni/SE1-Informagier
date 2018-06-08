package GUI;

import java.util.Scanner;

import javax.swing.JPanel;

import Rps.*;

public class Main {


	public static void main(String[] args) {
	    // TODO code application logic here
		
	/*	Scanner sc =new Scanner(System.in);
		int anzSpieler=sc.nextInt();
		Scanner eingabeName1=new Scanner(System.in);
		String name1=eingabeName1.next();
		Scanner eingabeName2=new Scanner(System.in);
		String name2=eingabeName1.next();
	*/	
		
		RPSonline game= new RPSonline(2,"likas","janikk");
	    
	    
	    //while schleife
	    
	    //buttons die variable zahl buchstabe beeinflussen
	    int zahl=0;
	    int buchstabe=0;
	    game.getSpieler().setztFlagge(zahl, buchstabe);
	    zahl=0;
	    buchstabe=1;
	    game.getSpieler().setztFalle(zahl, buchstabe);
	    
	    zahl=0;
	    buchstabe=0;
	    game.welchselSpieler();
	    game.getSpieler().setztFlagge(zahl, buchstabe);
	    zahl=0;
	    buchstabe=5;
	    game.getSpieler().setztFalle(zahl, buchstabe);
	    
	    game.start();
	    game.welchselSpieler();
	 	    
	    
	    MainFrame frame=new MainFrame(game);
	    frame.refresh(game);
	    
	    
	  
	}

}
