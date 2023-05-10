package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.ProductSizeAvaliabitityDao;
import btlweb.mvc.dao.impl.ProductSizeAvailiabilityDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.service.ProductAvaiService;

public class ProductAvaiServiceImpl implements ProductAvaiService{
	private ProductSizeAvaliabitityDao _proProductSizeAvaliabitityDao = new ProductSizeAvailiabilityDaoImpl();
	
	@Override
	public void updateProductAvailiability(List<Item> items) {
		// TODO Auto-generated method stub
		for(Item item : items) {
			item.setNum(_proProductSizeAvaliabitityDao.getSizeAvaiability(item.getProduct().getId(), item.getSize()) - item.getNum());
		}
		_proProductSizeAvaliabitityDao.updateProductAvailiability(items);
		return;
	}
}
