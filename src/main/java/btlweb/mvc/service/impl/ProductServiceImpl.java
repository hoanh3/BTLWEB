package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.dao.impl.ProductDaoImpl;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;
import btlweb.mvc.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao _productDao = new ProductDaoImpl();

	@Override
	public List<Product> getAll(String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getAll();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public List<Product> getTopSale(String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getTopSale();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public List<Product> getBestSeller(String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getBestSeller();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public List<Product> searchProductByName(String name, String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.searchProductByName(name);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public Product getProductById(int productId, String path) {
		// TODO Auto-generated method stub
		Product product = _productDao.getProductById(productId);
		product.setThumbnail(path + product.getThumbnail());
		return product;
	}

	@Override
	public List<Product> getProductByCatId(String catId, String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductByCatId(catId);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public int getNumberOfProduct() {
		// TODO Auto-generated method stub
		return _productDao.getNumberOfProduct();
	}

	@Override
	public List<Product> getProductInPage(int pageId, String path) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductInPage(pageId);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
		}
		return products;
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return _productDao.insertProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return _productDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		return _productDao.deleteProduct(id);
	}

}
