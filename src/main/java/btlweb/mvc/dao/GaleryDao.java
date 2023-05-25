package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Galery;

public interface GaleryDao {
	
	Galery getGaleryById(int id);
	List<Galery> getGaleryByProductId(int productId);
	
	//phan trang
	List<Galery> getGaleryInPage(int pageId);
	int getNumOfGalery();
	
	//admin
	int insertGalery(Galery galery);
	int updateGalery(Galery galery);
	int deleteGalery(int id);
}
