package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.User;

public interface UserService {
	List<User> getAll();
	int insertUser(String email, String password);
	int update(User user);
	User findUserByEmail(String email);
	User findUserById(int id);


	List<User> getUserInPage(int pageId);
	int getNumOfUser();
	
	int delete(int id);
}
