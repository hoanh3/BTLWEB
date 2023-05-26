package btlweb.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import btlweb.mvc.dao.OrderDetailDao;
import btlweb.mvc.dao.impl.OrderDetailDaoImpl;
import btlweb.mvc.model.Item;
import btlweb.mvc.model.OrderDetail;
import btlweb.mvc.model.Product;
import btlweb.mvc.model.dto.OrderDetailDto;
import btlweb.mvc.service.OrderDetailService;
import btlweb.mvc.service.ProductService;
import btlweb.mvc.service.SizeService;

public class OrderDetailServiceImpl implements OrderDetailService{
	private OrderDetailDao _orderDetailDao = new OrderDetailDaoImpl();
	private ProductService _productService = new ProductServiceImpl();
	private SizeService _sizeService = new SizeServiceImpl();

	@Override
	public void addOrderLine(List<Item> items, int oid) {
		// TODO Auto-generated method stub
		_orderDetailDao.addOrderLine(items, oid);
		return;
	}

	@Override
	public List<OrderDetailDto> getOrderDetailInOrder(int oid) {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetails = _orderDetailDao.getOrderDetailInOrder(oid);
		List<OrderDetailDto> res = new ArrayList<>();
		for(OrderDetail orderDetail : orderDetails) {
			Product product = _productService.getProductById(orderDetail.getProductId());
			res.add(new OrderDetailDto(product.getTitle(), product.getThumbnail(), orderDetail.getPrice(), product.getPrice(), orderDetail.getNum(), _sizeService.getSizeName(Integer.parseInt(orderDetail.getProductSizeName()))));
		}
		return res;
	}

	@Override
	public void deleteByOrderId(int oid) {
		// TODO Auto-generated method stub
		_orderDetailDao.deleteByOrderId(oid);
		return;
	}
}
