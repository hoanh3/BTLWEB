package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Item;

public interface ProductSizeAvaliabitityDao {
	void updateProductAvailiability(List<Item> items);
	int getSizeAvaiability(int productId, int sizeId);
}
