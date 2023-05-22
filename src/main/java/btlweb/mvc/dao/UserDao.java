package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.UserDto;

public interface UserDao {
	
	List<User> getAll();
	List<User> getAdmin();
	
	int insertUser(User user); // return ve status. != 0: thanhcong, == 0: that bai
	int update(UserDto user); // 	return ve status. != 0: thanhcong, == 0: that bai
	User findUserByEmail(String email);
	User adminFindByEmail(String email);
	User findUserById(int id);

	//phan trang
	List<User> getUserInPage(int pageId); // phan trang cho user
	int getNumOfUser(); // lay so luong user hien co
	
	// dung cho admin
	int delete(int id); // 	return ve status. != 0: thanhcong, == 0: that bai
}
