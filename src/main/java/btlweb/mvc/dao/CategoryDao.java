package btlweb.mvc.dao;

import java.util.List;

import btlweb.mvc.model.Category;

public interface CategoryDao {
	List<Category> getAll();
	
	//phan trang
	int getNumOfCategory();
	List<Category> getCategoryInPage(int pageId);
	
	//admin
	Category getCategoryById(int id);
	int insertCategory(Category category);
	int updateCategory(Category category);
	int deleteCategory(int id);
}
