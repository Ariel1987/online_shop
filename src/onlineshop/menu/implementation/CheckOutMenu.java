package onlineshop.menu.implementation;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.entities.Order;
import onlineshop.entities.implementation.DefaultOrder;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.implementation.DefaultOrderManagementService;

public class CheckOutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	@Override
	public void start() {

		while(true) {

			printMenuHeader();
			
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.next();
			
			if(!createOrder(userInput)) {
				System.out.println("You entered invalid credit card number. "
						+ "Valid credit card should contain 16 digits. Please, try one more time");
				continue;
			}
			context.getSessionCart().clear();
			break;
			
		}

		System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email");
		new MainMenu().start();
		
	}

	private boolean createOrder(String creditCardNumber) {
		
		Order order = new DefaultOrder();

		if(!order.isCreditCardNumberValid(creditCardNumber)) {
			return false;
		}
		
		order.setCreditCardNumber(creditCardNumber);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		
		orderManagementService.addOrder(order);
		
		return true;
		
	}
	
	@Override
	public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
		System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
	}

}
