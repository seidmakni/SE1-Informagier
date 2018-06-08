package GUI;

import Rps.*;

import javax.swing.JButton;

public class Button extends JButton{
	private String name;
	
	public Button() {
		super();
	}
	
	public Button(String s) {
		super(s);
		name=s;
	}
	
	public Button(Object o) {
		super(o.toString());
		name=o.toString();
	}

	public String getName() {
		return name;
	}
}
