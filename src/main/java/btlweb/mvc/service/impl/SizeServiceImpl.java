package btlweb.mvc.service.impl;

import btlweb.mvc.dao.SizeDao;
import btlweb.mvc.dao.impl.SizeDaoImpl;
import btlweb.mvc.service.SizeService;

public class SizeServiceImpl implements SizeService{
	private SizeDao _sizeDao = new SizeDaoImpl();
	
	@Override
	public String getSizeName(int sid) {
		// TODO Auto-generated method stub
		return _sizeDao.getSizeName(sid);
	}

}
