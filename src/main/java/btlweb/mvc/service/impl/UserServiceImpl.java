package btlweb.mvc.service.impl;

import btlweb.mvc.model.User;
import btlweb.mvc.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User findUserByEmail(String email) {
		
		// TODO Auto-generated method stub
		return new User(0, "test", "test", "hoantch211@gmail.com", "$2a$12$NEeMwyXumjBFmpcSOKiaqeMpQVJiYHRWZIFYK7upZbO3gQKLhviJW", "test", "test", "test", "test", null);
	}

}
