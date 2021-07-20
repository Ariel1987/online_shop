package onlineshop.services;

import onlineshop.entities.User;

public interface UserManagementService {

	String registerUser(User user);
	
	User[] getUsers();
	
	User getUserByEmail(String userEmail);

}
