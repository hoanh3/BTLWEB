package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.CartItemDao;
import btlweb.mvc.dao.impl.CartItemDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.Product;
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
		Item itemInDB = _cartItemDao.getItem(item.getUserId(), item.getProduct().getId());
		if(itemInDB == null) {
			_cartItemDao.addItem(item);
		} else {
			int nNum = item.getNum() + itemInDB.getNum();
			item.setNum(nNum);
			_cartItemDao.updateItem(item);
		}
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

	public static void main(String[] args) {
		ProductService _productService = new ProductServiceImpl();
		CartItemService cartItemService = new CartItemServiceImpl();
		
		cartItemService.addItem(new Item(0, 2, _productService.getProductById(1, "", ""), 1, 1, 59000));
	}
}
