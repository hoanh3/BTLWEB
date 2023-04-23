package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Product;

public interface ProductService {

	List<Product> getAll();
	List<Product> getTopSale();
	List<Product> getBestSeller();
	List<Product> searchProductByName(String name);
	Product getProductById(int productId);
	List<Product> getProductByCatId(String catId);
	
	int getNumberOfProduct();
	List<Product> getProductInPage(int pageId);
	
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int id);
}
