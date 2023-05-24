package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.ProductSizeAvaliabitityDao;
import btlweb.mvc.dao.impl.ProductSizeAvailiabilityDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.ProductSize;
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

	@Override
	public int getProductSA(int productId, int productSizeId) {
		// TODO Auto-generated method stub
		return _proProductSizeAvaliabitityDao.getSizeAvaiability(productId, productSizeId);
	}
	
	public static void main(String[] args) {
		ProductAvaiService productAvaiService = new ProductAvaiServiceImpl();
		System.out.println(productAvaiService.getProductSA(1, 1));
	}

	@Override
	public void addProductAvai(int sizeId, int productId, int avai) {
		_proProductSizeAvaliabitityDao.addProductAvai(new ProductSize(0, sizeId, avai, productId));
		return ;
	}

	@Override
	public void update(int sizeId, int productId, int avai) {
		// TODO Auto-generated method stub
		_proProductSizeAvaliabitityDao.update(new ProductSize(0, sizeId, avai, productId));
		return ;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		_proProductSizeAvaliabitityDao.deleteByProductId(id);
		return;
	}
}
