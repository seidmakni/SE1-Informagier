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
		Thread test1=new Thread(new TestThread1());
	    test1.start();
	  
	}

}
