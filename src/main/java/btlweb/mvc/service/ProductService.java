package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Product;
import btlweb.mvc.model.dto.ProductDto;

public interface ProductService {

	List<Product> getAll();
	List<Product> getTopSale();
	List<Product> getBestSeller();
	List<Product> searchProductByName(String name);
	Product getProductById(int productId);
	List<Product> getProductByCatId(String catId);
	
	int getNumberOfProduct();
	List<Product> getProductInPage(int pageId);
	
	int insertProduct(ProductDto product);
	int updateProduct(ProductDto product, int pid);
	int deleteProduct(int id);
}
