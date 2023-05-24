package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Item;

public interface ProductAvaiService {
	void updateProductAvailiability(List<Item> items);
	int getProductSA(int productId, int productSizeId);
	void addProductAvai(int sizeId, int productId, int avai);
	void update(int sizeId, int productId, int avai);
	void delete(int id);
}
