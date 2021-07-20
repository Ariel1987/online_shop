package onlineshop.menu.implementation;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class ChangeEmailMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {

		printMenuHeader();
		
		Scanner scanner = new Scanner(System.in);
		
		String userInput = scanner.next();
		
		context.getLoggedInUser().setEmail(userInput);
		
		System.out.println("Your password has been succesfully changed");
		
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Change Email *****");
		System.out.print("Please, enter your new email: ");

	}

}
