package btlweb.mvc.service;

import java.util.List;

import btlweb.mvc.model.Galery;

public interface GaleryService {

	Galery getGaleryById(int id, String path);
	List<Galery> getGaleryByProductId(int productId, String path);
	
	List<Galery> getGaleryInPage(int pageId, String path);
	int getNumOfGalery();
	
	int insertGalery(Galery galery);
	int updateGalery(Galery galery);
	int deleteGalery(int id);
}
