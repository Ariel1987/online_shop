package onlineshop.menu.implementation;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.User;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.implementation.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {

		printMenuHeader();
		
		User[] users = userManagementService.getUsers();
		
		if(users.length == 0) {
			System.out.println("Unfortunatelly, there are no customers");
		} else {

			for(User user: users) {
				System.out.println(user);
			}

		}
		context.getMainMenu().start();
	
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** Customer List *****");
	}

}
