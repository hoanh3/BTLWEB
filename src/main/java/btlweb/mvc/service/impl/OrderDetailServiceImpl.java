package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.OrderDetailDao;
import btlweb.mvc.dao.impl.OrderDetailDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{
	private OrderDetailDao _orderDetailDao = new OrderDetailDaoImpl();

	@Override
	public void addOrderLine(List<Item> items, int oid) {
		// TODO Auto-generated method stub
		_orderDetailDao.addOrderLine(items, oid);
		return;
	}

}
