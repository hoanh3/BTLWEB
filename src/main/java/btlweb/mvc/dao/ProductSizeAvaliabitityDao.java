package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Item;
import btlweb.mvc.model.ProductSize;

public interface ProductSizeAvaliabitityDao {
	void updateProductAvailiability(List<Item> items);
	int getSizeAvaiability(int productId, int sizeId);
	void addProductAvai(ProductSize productSize);
	void update(ProductSize productSize);
	void deleteByProductId(int pid);
}
