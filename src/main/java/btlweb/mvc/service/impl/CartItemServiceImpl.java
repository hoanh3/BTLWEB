package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.CartItemDao;
import btlweb.mvc.dao.impl.CartItemDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.service.CartItemService;
import btlweb.mvc.service.ProductService;

public class CartItemServiceImpl implements CartItemService{
	private CartItemDao _cartItemDao = new CartItemDaoImpl();
	private ProductService _productService = new ProductServiceImpl();

	@Override
	public List<Item> getCart(int userId, String path, String pathGalery) {
		// TODO Auto-generated method stub
		List<Item> items = _cartItemDao.getCart(userId);
		for(Item item : items) {
			item.setProduct(_productService.getProductById(item.getProduct().getId(), path, pathGalery));
		}
		return items;
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

	@Override
	public void checkOutComplete(int userId) {
		// TODO Auto-generated method stub
		_cartItemDao.checkOutComplete(userId);
	}

}
