package onlineshop.menu.implementation;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.Order;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.implementation.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		
		printMenuHeader();
		
		if(context.getLoggedInUser() == null) {
		
			System.out.println("Please, log in or create new account to see list of orders");
			new MainMenu().start();
			return;
			
		} else {

			printUserOrdersToConsole();
		
		}
		new MainMenu().start();
		
	}
	
	
	public void printUserOrdersToConsole() {
		
		Order[] loggedInUserOrders = orderManagementService
				.getOrderByUserId(context.getLoggedInUser().getId());
		
		if(loggedInUserOrders == null || loggedInUserOrders.length == 0) {
		
			System.out.println("Unfotunately, you don't have any orders yet. "
					+ "Navigate back to main menu to place a new order");
	
		} else {

			for(Order order: loggedInUserOrders) {
				System.out.println(order);
			}

		}
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** My Orders *****");
	}

}
