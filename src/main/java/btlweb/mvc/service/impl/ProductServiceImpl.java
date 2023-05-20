package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ietf.jgss.Oid;

import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.dao.impl.GaleryDaoImpl;
import btlweb.mvc.dao.impl.ProductDaoImpl;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;
import btlweb.mvc.service.GaleryService;
import btlweb.mvc.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao _productDao = new ProductDaoImpl();
	GaleryService _galeryService = new GaleryServiceImpl();

	@Override
	public List<Product> getAll(String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getAll();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		}
		return products;
	}

	@Override
	public List<Product> getTopSale(String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getTopSale();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		}
		return products;
	}

	@Override
	public List<Product> getBestSeller(String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getBestSeller();
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		}
		return products;
	}

	@Override
	public List<Product> searchProductByName(String name, String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.searchProductByName(name);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		}
		return products;
	}

	@Override
	public Product getProductById(int productId, String path, String galeryPath) {
		// TODO Auto-generated method stub
		Product product = _productDao.getProductById(productId);
		product.setThumbnail(path + product.getThumbnail());
		product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		return product;
	}

	@Override
	public List<Product> getProductByCatId(String catId, String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductByCatId(catId);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
		}
		return products;
	}

	@Override
	public int getNumberOfProduct() {
		// TODO Auto-generated method stub
		return _productDao.getNumberOfProduct();
	}

	@Override
	public List<Product> getProductInPage(int pageId, String path, String galeryPath) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductInPage(pageId);
		for(Product product : products) {
			product.setThumbnail(path + product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId(), galeryPath));
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

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		List<Product> products = productService.getProductByCatId("1", "", "");
		for(Product product : products) {
			System.out.println(product);
		}
	}
}
