package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.UserDao;
import btlweb.mvc.dao.impl.UserDaoImpl;
import btlweb.mvc.model.Role;
import btlweb.mvc.model.User;
import btlweb.mvc.model.dto.AdminDto;
import btlweb.mvc.model.dto.UserDto;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao _userDao = new UserDaoImpl();
	private CartItemService _cartItemService = new CartItemServiceImpl();

	@Override
	public User findUserByEmail(String email) {
		return _userDao.findUserByEmail(email);
	}

	@Override
	public int insertUser(String email, String password, String firstName, String lastName, int role) {
		User user = new User(0, firstName, lastName, email, password, "", "", "", "", new Role(role, "USER"));
		return _userDao.insertUser(user);
	}

	@Override
	public int update(UserDto user) {
		return _userDao.update(user);
	}

	@Override
	public User findUserById(int id) {
		return _userDao.findUserById(id);
	}

	@Override
	public List<User> getUserInPage(int pageId) {
		return _userDao.getUserInPage(pageId);
	}

	@Override
	public int getNumOfUser() {
		return _userDao.getNumOfUser();
	}

	@Override
	public int delete(int id) {
		_cartItemService.deleteItemByUserId(id);
		return _userDao.delete(id);
	}

	@Override
	public List<User> getAll() {
		return _userDao.getAll();
	}

	@Override
	public User adminFindUserByEmail(String email) {
		// TODO Auto-generated method stub
		return _userDao.adminFindByEmail(email);
	}

	@Override
	public List<User> getAdmin() {
		// TODO Auto-generated method stub
		return _userDao.getAdmin();
	}

	@Override
	public int insertAdmin(AdminDto adminDto) {
		User user = new User(0, adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(),
				adminDto.getPassword(), adminDto.getPhoneNumber(), adminDto.getCity(),
				adminDto.getDistrict(), adminDto.getStreetAddress(), new Role(1, "ADMIN"));
		return _userDao.insertUser(user);
	}
}
