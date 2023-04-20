package btlweb.mvc.service;

import btlweb.mvc.model.User;

public interface UserService {

	User findUserByEmail(String email);
	int insertUser(String email, String password);
}
