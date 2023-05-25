package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.ietf.jgss.Oid;

import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.dao.ProductDao;
import btlweb.mvc.dao.impl.GaleryDaoImpl;
import btlweb.mvc.dao.impl.ProductDaoImpl;
import btlweb.mvc.model.Category;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.dto.ProductDto;
import btlweb.mvc.service.CategoryService;
import btlweb.mvc.service.GaleryService;
import btlweb.mvc.service.ProductAvaiService;
import btlweb.mvc.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao _productDao = new ProductDaoImpl();
	CategoryService _categoryService = new CategoryServiceImpl();
	ProductAvaiService _productAvaiService = new ProductAvaiServiceImpl();
	GaleryService _galeryService = new GaleryServiceImpl();

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getAll();
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public List<Product> getTopSale() {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getTopSale();
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public List<Product> getBestSeller() {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getBestSeller();
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public List<Product> searchProductByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.searchProductByName(name);
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Product product = _productDao.getProductById(productId);
		product.setThumbnail(product.getThumbnail());
		product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		return product;
	}

	@Override
	public List<Product> getProductByCatId(String catId) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductByCatId(catId);
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public int getNumberOfProduct() {
		// TODO Auto-generated method stub
		return _productDao.getNumberOfProduct();
	}

	@Override
	public List<Product> getProductInPage(int pageId) {
		// TODO Auto-generated method stub
		List<Product> products = _productDao.getProductInPage(pageId);
		for(Product product : products) {
			product.setThumbnail(product.getThumbnail());
			product.setGaleries(_galeryService.getGaleryByProductId(product.getId()));
		}
		return products;
	}

	@Override
	public int insertProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Date create = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(create);
		create = new java.sql.Date(calendar.getTimeInMillis());
		Product product = new Product(0, productDto.getTitle(), 5, productDto.getPrice(),
				productDto.getDiscount(), productDto.getThumbnail(),
				productDto.getDescription(), create, create,
				_categoryService.getCategoryById(productDto.getCategory()), new ArrayList<>());
		int pid = _productDao.insertProduct(product);
		_productAvaiService.addProductAvai(productDto.getSize(), pid, productDto.getAvai());
		return pid;
	}

	@Override
	public int updateProduct(ProductDto productDto, int pid) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		date = new java.sql.Date(calendar.getTimeInMillis());
		Product product = getProductById(pid);
		product.setTitle(productDto.getTitle());
		product.setPrice(productDto.getPrice());
		product.setDiscount(productDto.getDiscount());
		product.setThumbnail(productDto.getThumbnail());
		product.setDescription(productDto.getDescription());
		product.setUpdatedAt(date);
		product.setCategory(_categoryService.getCategoryById(productDto.getCategory()));
		if(productDto.getSize() != 0) {
			_productAvaiService.update(productDto.getSize(), pid, productDto.getAvai());			
		}
		return _productDao.updateProduct(product);
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub`
		_productAvaiService.delete(id);
		return _productDao.deleteProduct(id);
	}

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		List<Product> products = productService.getProductByCatId("1");
		for(Product product : products) {
			System.out.println(product);
		}
	}

	@Override
	public int deleteProductByCategoryId(int cid) {
		// TODO Auto-generated method stub
		return _productDao.deletProductByCategoryId(cid);
	}
}
