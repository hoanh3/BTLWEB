package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.UserDto;

public interface UserService {
	List<User> getAll();
	int insertUser(String email, String password, String firstName, String lastName);
	int update(UserDto user);
	User findUserByEmail(String email);
	User findUserById(int id);


	List<User> getUserInPage(int pageId);
	int getNumOfUser();
	
	int delete(int id);
}
