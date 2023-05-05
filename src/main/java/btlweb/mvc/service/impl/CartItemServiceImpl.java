package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.CartItemDao;
import btlweb.mvc.dao.impl.CartItemDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.service.CartItemService;

public class CartItemServiceImpl implements CartItemService{
	private CartItemDao _cartItemDao = new CartItemDaoImpl();

	@Override
	public List<Item> getCart(int userId) {
		// TODO Auto-generated method stub
		return _cartItemDao.getCart(userId);
	}

	@Override
	public void addItem(Item item) {
		// TODO Auto-generated method stub
		_cartItemDao.addItem(item);
		return;
	}

	@Override
	public void removeItem(int id) {
		// TODO Auto-generated method stub
		_cartItemDao.removeItem(id);
		return;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		_cartItemDao.updateItem(item);
		return;
	}

	@Override
	public int getTotalMoney(int userId) {
		// TODO Auto-generated method stub
		return _cartItemDao.getTotalMoney(userId);
	}

}
