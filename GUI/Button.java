package GUI;

import Rps.*;

import javax.swing.JButton;

public class Button extends JButton{
	
	public Button() {
		super();
	}
	
	public Button(String s) {
		super(s);
	}
	
	public Button(Object o) {
		super(o.toString());
	}

}
