package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Product;

public interface ProductService {

	List<Product> getAll(String path);
	List<Product> getTopSale(String path);
	List<Product> getBestSeller(String path);
	List<Product> searchProductByName(String name, String path);
	Product getProductById(int productId, String path);
	List<Product> getProductByCatId(String catId, String path);
	
	int getNumberOfProduct();
	List<Product> getProductInPage(int pageId, String path);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int id);
}
