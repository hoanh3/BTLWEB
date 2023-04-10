package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Galery;

public interface GaleryDao {
	List<Galery> getGaleryByProductId(int productId);
	
	//phan trang
	List<Galery> getGaleryInPage(int pageId);
	int getNumOfGalery();
	
	//admin
	int insertGalery(Galery product);
	int updateGalery(Galery product);
	int deleteGalery(int id);
}
