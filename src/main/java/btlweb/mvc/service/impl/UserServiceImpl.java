package btlweb.mvc.service.impl;

import java.util.List;

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

	@Override
	public int update(User user) {
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
		return _userDao.delete(id);
	}

	@Override
	public List<User> getAll() {
		return _userDao.getAll();
	}

}
