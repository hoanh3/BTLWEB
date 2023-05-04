package btlweb.mvc.service.impl;

import java.util.List;

import btlweb.mvc.dao.GaleryDao;
import btlweb.mvc.dao.impl.GaleryDaoImpl;
import btlweb.mvc.model.Galery;
import btlweb.mvc.service.GaleryService;

public class GaleryServiceImpl implements GaleryService{
	private GaleryDao _galeryDao = new GaleryDaoImpl();

	@Override
	public Galery getGaleryById(int id, String path) {
		// TODO Auto-generated method stub
		Galery galery = _galeryDao.getGaleryById(id);
		galery.setThumbnail(path + galery.getThumbnail());
		return galery;
	}

	@Override
	public List<Galery> getGaleryByProductId(int productId, String path) {
		// TODO Auto-generated method stub
		List<Galery> galeries = _galeryDao.getGaleryByProductId(productId);
		for(Galery galery : galeries) {
			galery.setThumbnail(path + galery.getThumbnail());
		}
		return galeries;
	}

	@Override
	public List<Galery> getGaleryInPage(int pageId, String path) {
		// TODO Auto-generated method stub
		List<Galery> galeries = _galeryDao.getGaleryInPage(pageId);
		for(Galery galery : galeries) {
			galery.setThumbnail(path + galery.getThumbnail());
		}
		return galeries;
	}

	@Override
	public int getNumOfGalery() {
		// TODO Auto-generated method stub
		return _galeryDao.getNumOfGalery();
	}

	@Override
	public int insertGalery(Galery galery) {
		// TODO Auto-generated method stub
		return _galeryDao.insertGalery(galery);
	}

	@Override
	public int updateGalery(Galery galery) {
		// TODO Auto-generated method stub
		return _galeryDao.updateGalery(galery);
	}

	@Override
	public int deleteGalery(int id) {
		// TODO Auto-generated method stub
		return _galeryDao.deleteGalery(id);
	}
	
}
