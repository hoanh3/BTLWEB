package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Product;

public interface ProductService {

	List<Product> getAll(String path, String galeryPath);
	List<Product> getTopSale(String path, String galeryPath);
	List<Product> getBestSeller(String path, String galeryPath);
	List<Product> searchProductByName(String name, String path, String galeryPath);
	Product getProductById(int productId, String path, String galeryPath);
	List<Product> getProductByCatId(String catId, String path, String galeryPath);
	
	int getNumberOfProduct();
	List<Product> getProductInPage(int pageId, String path, String galeryPath);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int id);
}
