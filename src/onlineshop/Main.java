package onlineshop;

import onlineshop.menu.Menu;
import onlineshop.menu.implementation.MainMenu;

public class Main {

	public static final String EXIT_COMMAND = "exit";
	
	public static void main(String[] args) {

		Menu menu = new MainMenu();
		menu.start();
		
	}

}
