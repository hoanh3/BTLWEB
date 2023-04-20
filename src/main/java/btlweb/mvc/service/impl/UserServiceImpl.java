package btlweb.mvc.service.impl;

import btlweb.mvc.dao.UserDao;
import btlweb.mvc.dao.impl.UserDaoImpl;
import btlweb.mvc.model.User;
import btlweb.mvc.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao _userDao = new UserDaoImpl();

	@Override
	public User findUserByEmail(String email) {
		return _userDao.findUserByEmail(email);
	}

	@Override
	public int insertUser(String email, String password) {
		User user = new User(0, "", "", email, password, "", "", "", "", null);
		return _userDao.insertUser(user);
	}

}
