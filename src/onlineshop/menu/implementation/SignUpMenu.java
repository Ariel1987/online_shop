package onlineshop.menu.implementation;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.User;
import onlineshop.entities.implementation.DefaultUser;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.implementation.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		
		printMenuHeader();
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please, enter your fisrt name: ");
		String firstName = scanner.next();

		System.out.print("Please, enter your last Name: ");
		String lastName = scanner.next();
		
		System.out.print("Please, enter your password: ");
		String password = scanner.next();
		
		System.out.print("Please, enter your email: ");

		scanner = new Scanner(System.in);
		String email = scanner.nextLine();
		
		User user = new DefaultUser(firstName, lastName, password, email);
		
		String errorMessage = userManagementService.registerUser(user);
		
		if(errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			System.out.println("New User Created");
		} else {
			System.out.println(errorMessage);
		}

		context.getMainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SING UP *****");
	}

}
