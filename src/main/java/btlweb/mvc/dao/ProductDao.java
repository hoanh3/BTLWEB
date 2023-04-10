package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Product;

public interface ProductDao {
	List<Product> getAll();
	List<Product> getTopSale(); // lay danh sach san pham giam gia nhieu nhat
	List<Product> getBestSeller(); // lay danh sach san pham ban chay nhat
	List<Product> searchProductByName(String name);
	Product getProductById(int productId);
	List<Product> getProductByCatId(String catId);// danh sach san pham theo danh muc
	
	// phan trang
	int getNumberOfProduct();
	List<Product> getProductInPage(int pageId);
	
	// admin
	int insertProduct(Product product);
	int updateProduct(Product product);
	int deleteProduct(int id);
}
