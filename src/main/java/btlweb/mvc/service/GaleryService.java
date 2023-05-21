package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Galery;

public interface GaleryService {

	Galery getGaleryById(int id);
	List<Galery> getGaleryByProductId(int productId);
	
	List<Galery> getGaleryInPage(int pageId);
	int getNumOfGalery();
	
	int insertGalery(Galery galery);
	int updateGalery(Galery galery);
	int deleteGalery(int id);
}
