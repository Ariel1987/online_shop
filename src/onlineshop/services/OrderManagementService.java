package onlineshop.services;

import onlineshop.entities.Order;

public interface OrderManagementService {

	void addOrder(Order order);
	
	Order[] getOrderByUserId(int userId);
	
	Order[] getOrders();

}
